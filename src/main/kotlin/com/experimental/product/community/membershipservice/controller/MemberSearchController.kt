package com.experimental.product.community.membershipservice.controller

import com.experimental.product.community.membershipservice.entity.Member
import com.experimental.product.community.membershipservice.service.MemberSearchService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("v1/members")
class MemberSearchController(
    val memberSearchService: MemberSearchService
) {
    @GetMapping
    fun getAll(): ResponseEntity<List<Member>> {
        return ResponseEntity.ok(memberSearchService.getAll())
    }

    @GetMapping("/{id}")
    fun get(
        @PathVariable id: String
    ): ResponseEntity<Member> {
        return ResponseEntity.ok(memberSearchService.get(id))
    }

    @GetMapping("/contact/{contactNumber}")
    fun getByContactNumber(
        @PathVariable contactNumber: String
    ): ResponseEntity<Member> {
        return ResponseEntity.ok(memberSearchService.getByContactNumber(contactNumber))
    }

    @GetMapping("/email/{emailAddress}")
    fun getByEmailAddress(
        @PathVariable emailAddress: String
    ): ResponseEntity<Member> {
        return ResponseEntity.ok(memberSearchService.getByEmailAddress(emailAddress))
    }
}