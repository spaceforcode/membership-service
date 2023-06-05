package com.experimental.product.community.membershipservice.service;

import com.experimental.product.community.membershipservice.client.request.CreateCommunityRequest;
import com.experimental.product.community.membershipservice.client.request.UpdateCommunityRequest;
import com.experimental.product.community.membershipservice.client.request.UpdateMemberRequest;
import com.experimental.product.community.membershipservice.entity.Community;
import com.experimental.product.community.membershipservice.entity.Member;
import com.experimental.product.community.membershipservice.repository.CommunityRepository;
import com.experimental.product.community.membershipservice.repository.CommunityRepositoryV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

@Service
public class CommunityAdminServiceV2 {

    @Autowired
    private CommunityRepositoryV2 communityRepository;


    public boolean save(CreateCommunityRequest createCommunityRequest) {
        try {
            communityRepository.save(Community.Companion.toCommunity(createCommunityRequest));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
