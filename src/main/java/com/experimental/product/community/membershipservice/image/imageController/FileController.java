package com.experimental.product.community.membershipservice.image.imageController;

import com.amazonaws.services.s3.AmazonS3;
import com.experimental.product.community.membershipservice.image.imageService.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/files")
public class FileController
{
    @Autowired
    private AmazonS3 s3client;
    @Autowired
    private FileService service;
    @PostMapping("/upload")
    public ResponseEntity<String> upload (@RequestParam(value = "file") MultipartFile file , @RequestParam(value = "id") String id) throws IOException {
        return new ResponseEntity<>(service.uploadFile(file,id), HttpStatus.OK);
    }

    @GetMapping("/download")
    public ResponseEntity<ByteArrayResource> download(@RequestParam(value = "key") String key)
    {
        byte[] data = service.downloadFile(key);
        ByteArrayResource resource =new ByteArrayResource(data);
        return ResponseEntity
                .ok()
                .header("content-type","application/octet-stream")
                .header("content-disposition","attachment;filename=\""+key+"\"")
                .body(resource);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@RequestParam(value = "key") String key ,@PathVariable String id)
    {
        return new ResponseEntity<>(service.deleteFile(key,id),HttpStatus.OK);
    }
}
