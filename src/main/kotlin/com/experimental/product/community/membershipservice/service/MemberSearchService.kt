package com.experimental.product.community.membershipservice.service

import com.experimental.product.community.membershipservice.client.response.MemberResponse
import com.experimental.product.community.membershipservice.repository.MemberRepository
import org.apache.commons.logging.Log
import org.apache.commons.logging.LogFactory
import org.springframework.stereotype.Service

@Service
class MemberSearchService(
    val memberRepository: MemberRepository
) {
    val logger: Log = LogFactory.getLog(
        MemberSearchService::class.java
    )

    fun getAll(): List<MemberResponse> {
        return try {
            val dbMembers = memberRepository.findAll()
            dbMembers.map { it.toMemberResponse() }.toMutableList()
        } catch (e: Exception) {
            logger.error(e.message)
            emptyList()
        }
    }

    fun get(
        id: String
    ): MemberResponse? {
        return try {
            val dbMember = memberRepository.findOneById(id)
            dbMember.toMemberResponse()
        } catch (e: Exception) {
            null
        }
    }

    fun getByContactNumber(
        contactNumber: String
    ): MemberResponse? {
        return try {
            val dbMember = memberRepository.findOneByContactNumber(contactNumber)
            dbMember.toMemberResponse()
        } catch (e: Exception) {
            null
        }
    }

    fun getByEmailAddress(
        emailAddress: String
    ): MemberResponse? {
        return try {
            val dbMember = memberRepository.findOneByEmailAddress(emailAddress)
            dbMember.toMemberResponse()
        } catch (e: Exception) {
            null
        }
    }
}