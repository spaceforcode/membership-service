package com.experimental.product.community.membershipservice.client.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DeleteMemberFromCommunityRequest {

    @JsonProperty("community_id")
    private String communityId;

    @JsonProperty("member_id")
    private String memberId;

    public String getCommunityId() {
        return communityId;
    }

    public void setCommunityId(String communityId) {
        this.communityId = communityId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }
}