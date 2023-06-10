package com.experimental.product.community.membershipservice.controller;

import com.experimental.product.community.membershipservice.client.response.CommunityResponse;
import com.experimental.product.community.membershipservice.entity.Community;
import com.experimental.product.community.membershipservice.service.CommunitySearchServiceV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("v2/community")
public class CommunitySearchControllerV2 {

    @Autowired
    private CommunitySearchServiceV2 communitySearchService;


    @GetMapping()
    public ResponseEntity<List<CommunityResponse>> getAll()
    {
        return ResponseEntity.ok(communitySearchService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Stream<Community>> getById(@PathVariable String id)
    {
        return ResponseEntity.ok(communitySearchService.getById(id));
    }
}

