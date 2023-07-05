package com.experimental.product.community.membershipservice.client;

public class FamilyDetailV2
{
    public FamilyRelationship relationship;
    public String name;
    public FamilyDetailV2(FamilyRelationship relationship, String name)
    {
        this.relationship=relationship;
        this.name=name;
    }
    public FamilyDetailV2()
    {

    }

}
