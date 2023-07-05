package com.experimental.product.community.membershipservice.service;

import com.experimental.product.community.membershipservice.client.FamilyDetailV2;
import com.experimental.product.community.membershipservice.client.PaymentOptionV2;
import com.experimental.product.community.membershipservice.client.PreferenceDetailV2;
import com.experimental.product.community.membershipservice.client.request.CreateMemberRequestV2;
import com.experimental.product.community.membershipservice.client.request.UpdateMemberRequestV2;
import com.experimental.product.community.membershipservice.entity.MemberV2;
import com.experimental.product.community.membershipservice.entity.auxilary.FamilyInfo2;
import com.experimental.product.community.membershipservice.entity.auxilary.TypeValueInfo2;
import com.experimental.product.community.membershipservice.repository.MemberRepositoryV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class MemberAdminServiceV2 {

    @Autowired
    private MemberRepositoryV2 memberRepository;

    public boolean save(CreateMemberRequestV2 memberRequest)
    {

        //LocalDateTime now = LocalDateTime.now();
        try
        {
            MemberV2 savingMember = new MemberV2();
            savingMember.toMemberV2(memberRequest);

            // audit data
            //savingMember.setAuditData(new AuditData("test",LocalDateTime.now()));

            memberRepository.save(savingMember);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }
    public boolean update(UpdateMemberRequestV2 updateMemberRequest)
    {
        try
        {
            List<TypeValueInfo2> payment1 = new ArrayList<TypeValueInfo2>();
            Iterator iterator= updateMemberRequest.getPaymentOptions().iterator();

            while (iterator.hasNext())
            {
                PaymentOptionV2 type1 = (PaymentOptionV2) iterator.next();
                TypeValueInfo2 payment12=new TypeValueInfo2(type1.type.name(), type1.value);
                payment1.add(payment12);
            }



            List<TypeValueInfo2> preference = new ArrayList<TypeValueInfo2>();
            Iterator iterator2= updateMemberRequest.getPreferences().iterator();

            while (iterator2.hasNext())
            {
                PreferenceDetailV2 type2 = (PreferenceDetailV2) iterator2.next();
                TypeValueInfo2 prefer12=new TypeValueInfo2(type2.type.name(), type2.value);
                preference.add(prefer12);
            }

            List<FamilyInfo2> familyObj = new ArrayList<FamilyInfo2>();
            Iterator iterator3= updateMemberRequest.getFamilyDetails().iterator();

            while (iterator3.hasNext())
            {
                FamilyDetailV2 type3 = (FamilyDetailV2) iterator3.next();
                FamilyInfo2 family12=new FamilyInfo2(type3.relationship.name(), type3.name);
                familyObj.add(family12);
            }




            MemberV2 existingMember = memberRepository.findById(updateMemberRequest.getMemberId()).get();
            MemberV2 updateMember= new MemberV2
                    (
                    existingMember.getId(),
                    existingMember.getContactNumber(),
                    existingMember.getFirstName(),
                    existingMember.getLastName(),
                    updateMemberRequest.getEmailAddress(),
                    updateMemberRequest.getUnit(),
                    true,
                            updateMemberRequest.getMarried(),
                    payment1,
                            preference,
                            familyObj
                    );
            /*if (updateMemberRequest.getPaymentOptions() != null && !updateMemberRequest.getPaymentOptions().isEmpty())
            {
                updateMember = updateMember.updatePaymentOptions(updateMemberRequest.getPaymentOptions());
            }*/
            memberRepository.save(updateMember);

            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }

  /*  public boolean update(UpdateMemberRequest updateMemberRequest) {
        try {
            Member existingMember = memberRepository.findById(updateMemberRequest.getId());
            Member updatedMember = existingMember.copy(
                    existingMember.getId(),
                    existingMember.getContactNumber(),
                    existingMember.getFirstName(),
                    existingMember.getLastName(),
                    updateMemberRequest.getEmailAddress(),
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
    }*/
    public boolean delete(String id) {
        try {
            // hard delete
            memberRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
  public boolean inactive(String id) {
        try {
            //LocalDateTime now = LocalDateTime.now();
            MemberV2 activeMember = memberRepository.findById(id).get();
            // set active=false during copy
            MemberV2 inactiveMember= new MemberV2(
                    activeMember.getId(),
                    activeMember.getContactNumber(),
                    activeMember.getFirstName(),
                    activeMember.getLastName(),
                    activeMember.getEmailAddress(),
                    activeMember.getUnit(),
                   // activeMember.getJoiningDate(),
                    false,
                    activeMember.isMarried(),

                    activeMember.getPaymentOptions(),
                    activeMember.getPreferences(),
                    activeMember.getFamily()/*,
                    activeMember.getAuditData()*/);

            // audit data
           /*inactiveMember.getAuditData().setInactivatedBy("test");
            inactiveMember.getAuditData().setInactivatedDate(LocalDateTime.now());*/

            memberRepository.save(inactiveMember);
            return true;
        } catch (Exception e) {
            return false;
        }
    }




}
