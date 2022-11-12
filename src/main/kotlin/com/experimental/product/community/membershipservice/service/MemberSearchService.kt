package com.experimental.product.community.membershipservice.service

import com.experimental.product.community.membershipservice.entity.Member
import com.experimental.product.community.membershipservice.repository.MemberRepository
import org.springframework.stereotype.Service

@Service
class MemberSearchService(
    val memberRepository: MemberRepository
) {
    fun getAll(): List<Member> {
        return try {
            memberRepository.findAll()
        } catch (e: Exception) {
            emptyList()
        }
    }

    fun get(
        id: String
    ): Member? {
        return try {
            memberRepository.findOneById(id)
        } catch (e: Exception) {
            null
        }
    }

    fun getByContactNumber(
        contactNumber: String
    ): Member? {
        return try {
            memberRepository.findOneByContactNumber(contactNumber)
        } catch (e: Exception) {
            null
        }
    }
}