package com.experimental.product.community.membershipservice.service;
import com.experimental.product.community.membershipservice.client.request.CreateMemberRequest;
import com.experimental.product.community.membershipservice.client.request.UpdateMemberRequest;
import com.experimental.product.community.membershipservice.entity.Member;
import com.experimental.product.community.membershipservice.entity.auxilary.AuditData;
import com.experimental.product.community.membershipservice.repository.MemberRepositoryV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MemberAdminServiceV2 {

    @Autowired
    private MemberRepositoryV2 memberRepository;

    public boolean save(CreateMemberRequest memberRequest) {

        LocalDateTime now = LocalDateTime.now();
        try {
            Member savingMember = Member.Companion.toMember(memberRequest);

            // audit data
            savingMember.setAuditData(new AuditData("test",LocalDateTime.now()));

            memberRepository.save(savingMember);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean update(UpdateMemberRequest updateMemberRequest) {
        try {
            Member existingMember = memberRepository.findById(updateMemberRequest.getId());
            Member updatedMember = existingMember.copy(
                    existingMember.getId(),
                    existingMember.getContactNumber(),
                    existingMember.getFirstName(),
                    existingMember.getLastName(),
                    existingMember.getEmailAddress(),
                    updateMemberRequest.getUnit(),
                    existingMember.getJoiningDate(),
                    updateMemberRequest.getMarried(),
                    existingMember.getActive(),
                    existingMember.getPaymentOptions(),
                    existingMember.getPreferences(),
                    existingMember.getFamily(),
                    existingMember.getAuditData()
            );
            if (updateMemberRequest.getPaymentOptions() != null && !updateMemberRequest.getPaymentOptions().isEmpty()) {
                updatedMember = updatedMember.updatePaymentOptions(updateMemberRequest.getPaymentOptions());
            }
            if (updateMemberRequest.getFamilyDetails() != null && !updateMemberRequest.getFamilyDetails().isEmpty()) {
                updatedMember = updatedMember.updateFamily(updateMemberRequest.getFamilyDetails());
            }
            if (updateMemberRequest.getPreferenceDetails() != null && !updateMemberRequest.getPreferenceDetails().isEmpty()) {
                updatedMember = updatedMember.updatePreference(updateMemberRequest.getPreferenceDetails());
            }

            // audit data
            if (updatedMember.getAuditData() != null) {
                updatedMember.getAuditData().setUpdatedBy("test");
                updatedMember.getAuditData().setUpdatedDate(LocalDateTime.now());
            }

            memberRepository.save(updatedMember);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean inactive(String id) {
        try {
            LocalDateTime now = LocalDateTime.now();
            Member activeMember = memberRepository.findById(id);
            // set active=false during copy
            Member inactiveMember=(new Member(activeMember.getId(),
                    activeMember.getContactNumber(),
                    activeMember.getFirstName(),
                    activeMember.getLastName(),
                    activeMember.getEmailAddress(),
                    activeMember.getUnit(),
                    activeMember.getJoiningDate(),
                    activeMember.getMarried(),
                    false,
                    activeMember.getPaymentOptions(),
                    activeMember.getPreferences(),
                    activeMember.getFamily(),
                    activeMember.getAuditData()));

            // audit data
            inactiveMember.getAuditData().setInactivatedBy("test");
            inactiveMember.getAuditData().setInactivatedDate(LocalDateTime.now());

            memberRepository.save(inactiveMember);
            return true;
        } catch (Exception e) {
            return false;
        }
    }



}
