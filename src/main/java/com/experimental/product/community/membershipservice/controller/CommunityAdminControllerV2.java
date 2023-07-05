package com.experimental.product.community.membershipservice.controller;


import com.experimental.product.community.membershipservice.client.request.CreateCommunityRequestV2;
import com.experimental.product.community.membershipservice.client.request.MemberAddToCommunityRequest;
import com.experimental.product.community.membershipservice.service.CommunityAdminServiceV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v2/communities")
public class CommunityAdminControllerV2 {
    @Autowired
    CommunityAdminServiceV2 communityAdminService;


    @PostMapping
    public ResponseEntity<String> saveCommunity(@RequestBody CreateCommunityRequestV2 createCommunityRequest) {
        // TODO add validation
        boolean saved = communityAdminService.save(createCommunityRequest);
        if (saved) {
            return ResponseEntity.ok("Community saved successfully.");
        } else {
            return ResponseEntity.ok("Community not inserted");
        }
    }
    @PostMapping("/AddMember")
    public ResponseEntity<String> AddMemberID(@RequestBody MemberAddToCommunityRequest memberAddToCommunityRequest) {
        // TODO add validation
        boolean saved = communityAdminService.saveMemberID(memberAddToCommunityRequest);
        if (saved) {
            return ResponseEntity.ok("Member added to this community successfully.");
        } else {
            return ResponseEntity.ok("Member not added");
        }
    }

}

