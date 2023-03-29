package com.experimental.product.community.membershipservice.graphql.util

import com.experimental.product.community.membershipservice.graphql.fetcher.MemberAllDataFetcher
import com.experimental.product.community.membershipservice.graphql.fetcher.MemberDataFetcher
import graphql.GraphQL
import graphql.GraphQL.newGraphQL
import graphql.schema.idl.RuntimeWiring
import graphql.schema.idl.RuntimeWiring.newRuntimeWiring
import graphql.schema.idl.SchemaGenerator
import graphql.schema.idl.SchemaParser
import org.springframework.beans.factory.annotation.Value
import org.springframework.core.io.Resource
import org.springframework.stereotype.Component
import javax.annotation.PostConstruct

@Component
class GraphQlUtil(
    val memberDataFetcher: MemberDataFetcher,
    val memberAllDataFetcher: MemberAllDataFetcher
) {
    @Value("classpath:models.graphqls")
    private lateinit var schemaResource: Resource

    private lateinit var graphQL: GraphQL

    @PostConstruct
    fun graphQl(): GraphQL {
        val schemas = schemaResource.file
        val typeRegistry = SchemaParser().parse(schemas)
        val wiring = buildRuntimeWiring()
        val schema = SchemaGenerator().makeExecutableSchema(typeRegistry, wiring)
        return newGraphQL(schema).build()
    }

    private fun buildRuntimeWiring(
    ): RuntimeWiring {
        return newRuntimeWiring()
            .type("Query") { type ->
                type
                    .dataFetcher("member", memberDataFetcher)
                    .dataFetcher("members", memberAllDataFetcher)
            }
            .type("Member") { type ->
                type
                    .dataFetcher("member", memberDataFetcher)
                    .dataFetcher("members", memberAllDataFetcher)
            }
            .build()
    }
}