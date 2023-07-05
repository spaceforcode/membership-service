package com.experimental.product.community.membershipservice.entity.auxilary;

public class MemberDetails {
    private String first_name;
    private String last_name;
    private String community_id;
    private String member_id;

    // Constructor
    public MemberDetails(String first_name, String last_name, String community_id, String member_id) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.community_id = community_id;
        this.member_id = member_id;
    }

    // Getters and Setters
    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getCommunity_id() {
        return community_id;
    }

    public void setCommunity_id(String community_id) {
        this.community_id = community_id;
    }

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }
}
