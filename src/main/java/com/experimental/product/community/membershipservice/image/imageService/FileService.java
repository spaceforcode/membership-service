package com.experimental.product.community.membershipservice.image.imageService;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.experimental.product.community.membershipservice.entity.MemberV2;
import com.experimental.product.community.membershipservice.image.ImageProperties;
import com.experimental.product.community.membershipservice.repository.MemberRepositoryV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.utils.IoUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class FileService
{
    @Value("${bucketName}")
    private String bucketName;
    @Value("${region}")
    private String region;

    @Autowired
    private AmazonS3 s3client;
    @Autowired
    private MemberRepositoryV2 memberRepositoryV2;
    public String uploadFile(MultipartFile file, String id) throws IOException {
        File convertedFile = convertMultipartFile(file);
        PutObjectResult putObjectResult= s3client.putObject(new PutObjectRequest(bucketName,file.getOriginalFilename(),convertedFile));

        String key = file.getOriginalFilename();
        String objectUrl = String.format("https://%s.s3.%s.amazonaws.com/%s",
                bucketName, region ,file.getOriginalFilename());
        MemberV2 memberV2= memberRepositoryV2.findById(id).get();
        ImageProperties imageProperties =new ImageProperties(objectUrl,key);
        memberV2.addImage(imageProperties);
        memberRepositoryV2.save(memberV2);
        convertedFile.delete();
        return key;
    }
    public byte[] downloadFile(String key)
    {
        S3Object s3Object=s3client.getObject(bucketName,key);
        S3ObjectInputStream inputStream = s3Object.getObjectContent();
        try {
            byte[] content = IoUtils.toByteArray(inputStream);
            return content;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String deleteFile(String key,String id)
    {
        s3client.deleteObject(bucketName,key);
        MemberV2 memberV2= memberRepositoryV2.findById(id).get();
        List<ImageProperties> images = memberV2.getImages();
        images.removeIf(member->member.getImageKey().equals(key));
        memberV2.setImages(images);
        memberRepositoryV2.save(memberV2);
        return "removed";
    }

    private File convertMultipartFile(MultipartFile file) throws IOException {
        File convFile=new File(file.getOriginalFilename());
        FileOutputStream fos=new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }
}
