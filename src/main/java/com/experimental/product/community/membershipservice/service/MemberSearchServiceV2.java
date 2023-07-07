package com.experimental.product.community.membershipservice.service;

import com.experimental.product.community.membershipservice.client.response.MemberResponseV2;
import com.experimental.product.community.membershipservice.entity.MemberV2;
import com.experimental.product.community.membershipservice.repository.MemberRepositoryV2;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberSearchServiceV2 {


    @Autowired
    private  MemberRepositoryV2 memberRepository;
    private final Log logger = LogFactory.getLog(MemberSearchService.class);


    public List<MemberResponseV2> getAll() {
        try {
            List<MemberV2> dbMembers = memberRepository.findAll();
            return dbMembers.stream()
                    .map(member -> member.toMemberResponse())
                    .collect(Collectors.toList());
        } catch (Exception e) {
            logger.error(e.getMessage());
            return Collections.emptyList();
        }
    }

    public MemberResponseV2 get(String id) {
        try {
            MemberV2 dbMember = memberRepository.findById(id).get();
            return dbMember.toMemberResponse();
        } catch (Exception e) {
            return null;
        }
    }

    public MemberResponseV2 getByContactNumber(String contactNumber) {
        try {
            MemberV2 dbMember = memberRepository.findOneByContactNumber(contactNumber);
            return dbMember.toMemberResponse();
        } catch (Exception e) {
            return null;
        }
    }

    public MemberResponseV2 getByEmailAddress(String emailAddress) {
        try {
            MemberV2 dbMember = memberRepository.findOneByEmailAddress(emailAddress);
            return dbMember.toMemberResponse();
        } catch (Exception e) {
            return null;
        }
    }
}
