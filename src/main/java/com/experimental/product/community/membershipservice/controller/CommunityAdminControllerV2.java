package com.experimental.product.community.membershipservice.controller;

import com.experimental.product.community.membershipservice.client.request.CreateCommunityRequest;
import com.experimental.product.community.membershipservice.client.request.UpdateCommunityRequest;
import com.experimental.product.community.membershipservice.client.request.UpdateMemberRequest;
import com.experimental.product.community.membershipservice.service.CommunityAdminServiceV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v2/communities")
public class CommunityAdminControllerV2 {
    @Autowired
    CommunityAdminServiceV2 communityAdminService;


    @PostMapping
    public ResponseEntity<String> saveCommunity(@RequestBody CreateCommunityRequest createCommunityRequest) {
        // TODO add validation
        boolean saved = communityAdminService.save(createCommunityRequest);
        if (saved) {
            return ResponseEntity.ok("Community saved successfully.");
        } else {
            return ResponseEntity.ok("Community not inserted");
        }
    }
}

