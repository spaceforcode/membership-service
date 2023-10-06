package com.experimental.product.community.membershipservice.image.imageConfig;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StorageConfig
{
    @Value("${acessKey}")
    public String acessKey;

    @Value("${SecretKey}")
    private String SecretKey;

    @Value("${region}")
    public String region;

    @Value("${bucketName}")
    public String bucketName;

    @Bean
    public AmazonS3 amazonS3()
    {
        AWSCredentials awsCredentials=new BasicAWSCredentials(acessKey,SecretKey);
        return AmazonS3ClientBuilder.standard()
                .withRegion(region)
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .build();
    }


}
