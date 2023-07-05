package com.experimental.product.community.membershipservice.client;

public class PaymentOptionV2
{
    public PaymentType type;
    public String value;
    public PaymentOptionV2(PaymentType type, String value)
    {
        this.type=type;
        this.value=value;
    }
    public PaymentOptionV2()
    {

    }
}
