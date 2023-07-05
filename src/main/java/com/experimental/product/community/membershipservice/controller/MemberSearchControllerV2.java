package com.experimental.product.community.membershipservice.controller;


import com.experimental.product.community.membershipservice.client.response.MemberResponseV2;
import com.experimental.product.community.membershipservice.service.MemberSearchServiceV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v2/members")
public class MemberSearchControllerV2 {
    @Autowired
    private MemberSearchServiceV2 memberSearchService;

    @GetMapping()
    public ResponseEntity<List<MemberResponseV2>> getAll()
    {
        return ResponseEntity.ok(memberSearchService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberResponseV2> getById(@PathVariable String id)
    {
        return ResponseEntity.ok(memberSearchService.get(id));
    }
    @GetMapping("/email/{emailAddress}")
    public ResponseEntity<MemberResponseV2> getByEmailAddress(@PathVariable String emailAddress)
    {
        return ResponseEntity.ok(memberSearchService.getByEmailAddress(emailAddress));
    }

}
