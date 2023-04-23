package com.experimental.product.community.membershipservice.service;

import com.experimental.product.community.membershipservice.client.response.MemberResponse;
import com.experimental.product.community.membershipservice.entity.Member;
import com.experimental.product.community.membershipservice.repository.MemberRepository;
import com.experimental.product.community.membershipservice.repository.MemberRepositoryV2;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberSearchServiceV2 {

    private final MemberRepositoryV2 memberRepository;
    private final Log logger = LogFactory.getLog(MemberSearchService.class);

    public MemberSearchServiceV2(MemberRepositoryV2 memberRepository) {
        this.memberRepository = memberRepository;
    }

    public List<MemberResponse> getAll() {
        try {
            List<Member> dbMembers = memberRepository.findAll();
            return dbMembers.stream()
                    .map(member -> member.toMemberResponse())
                    .collect(Collectors.toList());
        } catch (Exception e) {
            logger.error(e.getMessage());
            return Collections.emptyList();
        }
    }

    public MemberResponse get(String id) {
        try {
            Member dbMember = memberRepository.findOneById(id);
            return dbMember.toMemberResponse();
        } catch (Exception e) {
            return null;
        }
    }

    public MemberResponse getByContactNumber(String contactNumber) {
        try {
            Member dbMember = memberRepository.findOneByContactNumber(contactNumber);
            return dbMember.toMemberResponse();
        } catch (Exception e) {
            return null;
        }
    }

    public MemberResponse getByEmailAddress(String emailAddress) {
        try {
            Member dbMember = memberRepository.findOneByEmailAddress(emailAddress);
            return dbMember.toMemberResponse();
        } catch (Exception e) {
            return null;
        }
    }
}
