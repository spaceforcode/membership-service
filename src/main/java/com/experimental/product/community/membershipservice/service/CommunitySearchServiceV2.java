package com.experimental.product.community.membershipservice.service;

import com.experimental.product.community.membershipservice.client.response.CommunityResponse;
import com.experimental.product.community.membershipservice.entity.Community;
import com.experimental.product.community.membershipservice.repository.CommunityRepositoryV2;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class CommunitySearchServiceV2 {

    @Autowired
    private CommunityRepositoryV2 communityRepository;

    private final Log logger = LogFactory.getLog(CommunitySearchServiceV2.class);

    public List<CommunityResponse> getAll() {
        try {
            List<Community> dbMembers = communityRepository.findAll();
            return dbMembers.stream()
                    .map(community -> community.toCommunityResponse())
                    .collect(Collectors.toList());
        } catch (Exception e) {
            logger.error(e.getMessage());
            return Collections.emptyList();
        }
    }
    public Stream<Community> getById(String id) {
        try {
            Optional<Community> dbMember = communityRepository.findById(id);
            return dbMember.stream();
        } catch (Exception e) {
            return null;
        }
    }

    public Stream<Community> getByName(String name) {
        try {
            Optional<Community> dbMember = Optional.ofNullable(communityRepository.findOneByName(name));
            return dbMember.stream();
        } catch (Exception e) {
            return null;
        }
    }

}
