package com.experimental.product.community.membershipservice.service

import com.experimental.product.community.membershipservice.entity.Member
import com.experimental.product.community.membershipservice.repository.MemberRepository
import org.apache.commons.logging.Log
import org.apache.commons.logging.LogFactory
import org.springframework.data.repository.config.RepositoryConfigurationDelegate
import org.springframework.stereotype.Service

@Service
class MemberSearchService(
    val memberRepository: MemberRepository
) {
    val logger: Log = LogFactory.getLog(
        RepositoryConfigurationDelegate::class.java
    )

    fun getAll(): List<Member> {
        return try {
            memberRepository.findAll()
        } catch (e: Exception) {
            logger.error(e.message)
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

    fun getByEmailAddress(
        emailAddress: String
    ): Member? {
        return try {
            memberRepository.findOneByEmailAddress(emailAddress)
        } catch (e: Exception) {
            null
        }
    }
}