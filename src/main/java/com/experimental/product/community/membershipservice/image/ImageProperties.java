package com.experimental.product.community.membershipservice.image;

public class ImageProperties
{
    private String imageUrl;
    private String imageKey;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setImageKey(String imageKey) {
        this.imageKey = imageKey;
    }

    public String getImageKey() {
        return imageKey;
    }



    public ImageProperties(String imageUrl, String imageKey) {
        this.imageUrl = imageUrl;
        this.imageKey = imageKey;
    }

}
