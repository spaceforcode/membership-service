package com.experimental.product.community.membershipservice.service;

import com.experimental.product.community.membershipservice.client.request.CreateCommunityRequest;
import com.experimental.product.community.membershipservice.client.request.CreateCommunityRequestV2;
import com.experimental.product.community.membershipservice.entity.Community;
import com.experimental.product.community.membershipservice.entity.CommunityV2;
import com.experimental.product.community.membershipservice.repository.CommunityRepositoryV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommunityAdminServiceV2 {

    @Autowired
    private CommunityRepositoryV2 communityRepository;


    public boolean save(CreateCommunityRequestV2 createCommunityRequest) {
        try {
            communityRepository.save(CommunityV2.toCommunity(createCommunityRequest));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
