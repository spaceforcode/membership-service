package com.experimental.product.community.membershipservice.controller;


import com.experimental.product.community.membershipservice.client.response.MemberResponse;
import com.experimental.product.community.membershipservice.service.MemberSearchService;
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
    private MemberSearchService memberSearchService;

    @GetMapping()
    public ResponseEntity<List<MemberResponse>> getAll()
    {
        return ResponseEntity.ok(memberSearchService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberResponse> getById(@PathVariable String id)
    {
        return ResponseEntity.ok(memberSearchService.get(id));
    }
    @GetMapping("/email/{emailAddress}")
    public ResponseEntity<MemberResponse> getByEmailAddress(@PathVariable String emailAddress)
    {
        return ResponseEntity.ok(memberSearchService.getByEmailAddress(emailAddress));
    }

}
