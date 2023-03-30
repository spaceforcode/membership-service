package com.experimental.product.community.membershipservice.graphql.controller

import com.experimental.product.community.membershipservice.graphql.util.GraphQlUtil
import graphql.GraphQL
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import javax.annotation.PostConstruct

@RestController
class GraphQLController {
    private lateinit var graphQL: GraphQL

    @Autowired
    private lateinit var graphQlUtil: GraphQlUtil

    @PostConstruct
    fun init() {
        graphQL = graphQlUtil.graphQl()
    }

    @PostMapping("/query")
    fun query(
        @RequestBody query: String
    ): ResponseEntity<Any> {
        val result = graphQL.execute(query)
        return ResponseEntity.ok(result.getData())
    }
}