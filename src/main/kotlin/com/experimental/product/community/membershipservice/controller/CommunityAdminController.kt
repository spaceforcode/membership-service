package com.experimental.product.community.membershipservice.controller

import com.experimental.product.community.membershipservice.client.request.CreateCommunityRequest
import com.experimental.product.community.membershipservice.service.CommunityAdminService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("v1/communities")
class CommunityAdminController(
    val communityAdminService: CommunityAdminService
) {
    @PostMapping
    fun create(
        @RequestBody createCommunityRequest: CreateCommunityRequest
    ): ResponseEntity<String> {
        // TODO add validation
        return if (communityAdminService.save(createCommunityRequest))
            ResponseEntity.ok("inserted")
        else
            ResponseEntity.ok("not inserted")
    }
}