package com.experimental.product.community.membershipservice.entity.auxilary;

public class MemberDetails {
    private String firstName;
    private String lastName;
    private String memberID;

    public MemberDetails(String firstName, String lastName, String memberID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.memberID = memberID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMemberID() {
        return memberID;
    }

    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }
}
