package com.experimental.product.community.membershipservice.service

import com.experimental.product.community.membershipservice.client.request.CreateCommunityRequest
import com.experimental.product.community.membershipservice.entity.Community
import com.experimental.product.community.membershipservice.repository.CommunityRepository
import org.springframework.stereotype.Service

@Service
class CommunityAdminService(
    val communityRepository: CommunityRepository
) {
    fun save(
        createCommunityRequest: CreateCommunityRequest
    ): Boolean {
        return try {
            communityRepository.save(Community.toCommunity(createCommunityRequest))
            true
        } catch (e: Exception) {
            false
        }
    }
}