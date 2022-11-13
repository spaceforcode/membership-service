package com.experimental.product.community.membershipservice.controller

import com.experimental.product.community.membershipservice.client.request.CreateMemberRequest
import com.experimental.product.community.membershipservice.client.request.UpdateMemberRequest
import com.experimental.product.community.membershipservice.service.MemberAdminService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("v1/members")
class MemberAdminController(
    val memberAdminService: MemberAdminService
) {
    @PostMapping
    fun join(
        @RequestBody memberRequest: CreateMemberRequest
    ): ResponseEntity<String> {
        // TODO add validation
        return if (memberAdminService.save(memberRequest))
            ResponseEntity.ok("inserted")
        else
            ResponseEntity.ok("not inserted")
    }

    @PutMapping
    fun update(
        @RequestBody updateMemberRequest: UpdateMemberRequest
    ): ResponseEntity<String> {
        // TODO add validation of existence
        return if (memberAdminService.update(updateMemberRequest))
            ResponseEntity.ok("updated")
        else
            ResponseEntity.ok("not updated")
    }

    @DeleteMapping("/{id}")
    fun unsubscribe(
        @PathVariable id: String
    ): ResponseEntity<String> {
        // TODO add validation of existence
        return if (memberAdminService.delete(id))
            ResponseEntity.ok("deleted")
        else
            ResponseEntity.ok("not deleted")
    }

    @PutMapping("/inactive/{id}")
    fun inactive(
        @PathVariable id: String
    ): ResponseEntity<String> {
        // TODO add validation of existence
        return if (memberAdminService.inactive(id))
            ResponseEntity.ok("inactivated")
        else
            ResponseEntity.ok("not inactivated")
    }

    @PutMapping("/active/{id}")
    fun active(
        @PathVariable id: String
    ): ResponseEntity<String> {
        // TODO add validation of existence
        return if (memberAdminService.active(id))
            ResponseEntity.ok("activated")
        else
            ResponseEntity.ok("not activated")
    }
}