package com.experimental.product.community.membershipservice.client;

public class PreferenceDetailV2
{
    public PreferenceType type;
    public String value;
    public PreferenceDetailV2(PreferenceType type, String value)
    {
        this.type=type;
        this.value=value;
    }
    public PreferenceDetailV2()
    {

    }
}
