package com.experimental.product.community.membershipservice.service

import com.experimental.product.community.membershipservice.client.request.CreateMemberRequest
import com.experimental.product.community.membershipservice.client.request.UpdateMemberRequest
import com.experimental.product.community.membershipservice.entity.Member
import com.experimental.product.community.membershipservice.repository.MemberRepository
import org.springframework.stereotype.Service

@Service
class MemberAdminService(
    val memberRepository: MemberRepository
) {
    fun save(
        memberRequest: CreateMemberRequest
    ): Boolean {
        return try {
            memberRepository.save(Member.toMember(memberRequest))
            true
        } catch (e: Exception) {
            false
        }
    }

    fun update(
        updateMemberRequest: UpdateMemberRequest
    ): Boolean {
        return try {
            val existingMember = memberRepository.findOneById(updateMemberRequest.id)
            var updatedMember = existingMember.copy()
            if (updateMemberRequest.paymentOptions?.isNotEmpty()!!)
                updatedMember = existingMember.updatePaymentOptions(updateMemberRequest.paymentOptions!!)
            if (updateMemberRequest.familyDetails?.isNotEmpty()!!)
                updatedMember = existingMember.updateFamily(updateMemberRequest.familyDetails!!)
            memberRepository.save(updatedMember)
            true
        } catch (e: Exception) {
            false
        }
    }
}