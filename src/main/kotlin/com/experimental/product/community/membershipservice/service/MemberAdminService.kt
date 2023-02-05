package com.experimental.product.community.membershipservice.service

import com.experimental.product.community.membershipservice.client.request.CreateMemberRequest
import com.experimental.product.community.membershipservice.client.request.UpdateMemberRequest
import com.experimental.product.community.membershipservice.entity.Member
import com.experimental.product.community.membershipservice.entity.auxilary.AuditData
import com.experimental.product.community.membershipservice.repository.MemberRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class MemberAdminService(
    val memberRepository: MemberRepository
) {
    fun save(
        memberRequest: CreateMemberRequest
    ): Boolean {
        return try {
            var savingMember = Member.toMember(memberRequest)

            // audit data
            savingMember.auditData = AuditData(
                createdBy = "test",
                createdDate = LocalDateTime.now()
            )
            memberRepository.save(savingMember)
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
                updatedMember = updatedMember.updatePaymentOptions(updateMemberRequest.paymentOptions!!)
            if (updateMemberRequest.familyDetails?.isNotEmpty()!!)
                updatedMember = updatedMember.updateFamily(updateMemberRequest.familyDetails!!)
            if (updateMemberRequest.preferenceDetails?.isNotEmpty()!!)
                updatedMember = updatedMember.updatePreference(updateMemberRequest.preferenceDetails!!)

            // audit data
            updatedMember.auditData?.updatedBy = "test"
            updatedMember.auditData?.updatedDate = LocalDateTime.now()

            memberRepository.save(updatedMember)
            true
        } catch (e: Exception) {
            false
        }
    }

    fun delete(
        id: String
    ): Boolean {
        return try {
            // hard delete
            memberRepository.deleteById(id)
            true
        } catch (e: Exception) {
            false
        }
    }

    fun inactive(
        id: String
    ): Boolean {
        return try {
            val activeMember = memberRepository.findOneById(id)
            // set active=false during copy
            val inactiveMember = activeMember.copy(active = false)

            // audit data
            inactiveMember.auditData?.inactivatedBy = "test"
            inactiveMember.auditData?.inactivatedDate = LocalDateTime.now()

            memberRepository.save(inactiveMember)
            true
        } catch (e: Exception) {
            false
        }
    }

    fun active(
        id: String
    ): Boolean {
        return try {
            val activeMember = memberRepository.findOneById(id)
            // set active=true during copy
            val inactiveMember = activeMember.copy(active = true)
            memberRepository.save(inactiveMember)
            true
        } catch (e: Exception) {
            false
        }
    }
}