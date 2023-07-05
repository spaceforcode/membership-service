package com.experimental.product.community.membershipservice.controller;


import com.experimental.product.community.membershipservice.client.request.CreateMemberRequest;
import com.experimental.product.community.membershipservice.client.request.CreateMemberRequestV2;
import com.experimental.product.community.membershipservice.client.request.UpdateMemberRequest;
import com.experimental.product.community.membershipservice.client.request.UpdateMemberRequestV2;
import com.experimental.product.community.membershipservice.service.MemberAdminServiceV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v2/members")
public class MemberAdminControllerV2 {

    @Autowired
    MemberAdminServiceV2 memberAdminService;

    @PostMapping
    public ResponseEntity<String> join(
            @RequestBody CreateMemberRequestV2 memberRequest) {
        // TODO add validation
        return memberAdminService.save(memberRequest)
                ? ResponseEntity.ok("inserted")
                : ResponseEntity.ok("not inserted");
    }

    @PutMapping
    public ResponseEntity<String> update(
            @RequestBody UpdateMemberRequestV2 updateMemberRequest) {
        // TODO add validation of existence
        return memberAdminService.update(updateMemberRequest)
                ? ResponseEntity.ok("updated")
                : ResponseEntity.ok("not updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> unsubscribe(@PathVariable String id) {
        // TODO add validation of existence
        return memberAdminService.delete(id)
                ? ResponseEntity.ok("deleted")
                : ResponseEntity.ok("not deleted");
    }

    @PutMapping("/inactive/{id}")
    public ResponseEntity<String> inactive(@PathVariable String id) {
        // TODO add validation of existence
        return memberAdminService.inactive(id)
                ? ResponseEntity.ok("inactivated")
                : ResponseEntity.ok("not inactivated");
    }

    @PutMapping("/active/{id}")
    public ResponseEntity<String> active(@PathVariable String id) {
        // TODO add validation of existence
        return memberAdminService.inactive(id)
                ? ResponseEntity.ok("activated")
                : ResponseEntity.ok("not activated");
    }
}
