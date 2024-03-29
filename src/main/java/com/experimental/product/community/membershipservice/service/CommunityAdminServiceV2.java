package com.experimental.product.community.membershipservice.service;

import com.experimental.product.community.membershipservice.client.request.CreateCommunityRequestV2;
import com.experimental.product.community.membershipservice.client.request.DeleteMemberFromCommunityRequest;
import com.experimental.product.community.membershipservice.client.request.MemberAddToCommunityRequest;
import com.experimental.product.community.membershipservice.entity.CommunityV2;
import com.experimental.product.community.membershipservice.entity.Member;
import com.experimental.product.community.membershipservice.entity.MemberV2;
import com.experimental.product.community.membershipservice.entity.auxilary.MemberDetails;
import com.experimental.product.community.membershipservice.repository.CommunityRepositoryV2;
import com.experimental.product.community.membershipservice.repository.MemberRepositoryV2;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CommunityAdminServiceV2 {

    @Autowired
    private CommunityRepositoryV2 communityRepository;

    @Autowired
    private MemberRepositoryV2 memberRepository;


    public boolean save(CreateCommunityRequestV2 createCommunityRequest) {
        try {
            communityRepository.save(CommunityV2.toCommunity(createCommunityRequest));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean saveMemberID(@NotNull MemberAddToCommunityRequest memberAddToCommunityRequest) {
        try {
            Optional<CommunityV2> existingCommunity = communityRepository.findById(memberAddToCommunityRequest.getCommunityId());
            MemberV2 existingMember = memberRepository.findById(memberAddToCommunityRequest.getMemberId()).get();

            if (existingCommunity.isPresent() && existingMember != null) {
                List<MemberDetails> updatedMembersList = existingCommunity.get().getListofMembers();

                if (updatedMembersList == null) {
                    updatedMembersList = new ArrayList<>();
                }

                MemberDetails memberDetails = new MemberDetails(
                        existingMember.getFirstName(),
                        existingMember.getLastName(),
                        memberAddToCommunityRequest.getMemberId()
                );

                updatedMembersList.add(memberDetails);
                existingCommunity.get().setListofMembers(updatedMembersList);

                communityRepository.save(existingCommunity.get());

                return true;
            } else {
                return false; // Handle case when the community or member doesn't exist
            }
        } catch (Exception e) {
            return false;
        }
    }

    public boolean deleteMemmber(DeleteMemberFromCommunityRequest deleteMemberFromCommunityRequest) {
        try {
            Optional<CommunityV2> existingCommunity = communityRepository.findById(deleteMemberFromCommunityRequest.getCommunityId());
            MemberV2 existingMember = memberRepository.findById(deleteMemberFromCommunityRequest.getMemberId()).get();

            List<MemberDetails> updatedMembersList = null;
            if (existingCommunity.isPresent() && existingMember != null) {
                updatedMembersList = existingCommunity.get().getListofMembers();
            }
            if (updatedMembersList != null) {
                // Find and remove the member from the updated members list
                updatedMembersList.removeIf(member -> member.getMemberID().equals(deleteMemberFromCommunityRequest.getMemberId()));

                // Update the community's member list
                existingCommunity.get().setListofMembers(updatedMembersList);

                // Save the updated community
                communityRepository.save(existingCommunity.get());

                return true;

            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

}






