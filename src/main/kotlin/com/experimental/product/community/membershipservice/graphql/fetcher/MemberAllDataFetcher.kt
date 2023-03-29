package com.experimental.product.community.membershipservice.graphql.fetcher

import com.experimental.product.community.membershipservice.entity.Member
import com.experimental.product.community.membershipservice.repository.MemberRepository
import com.experimental.product.community.membershipservice.service.MemberSearchService
import graphql.schema.DataFetcher
import graphql.schema.DataFetchingEnvironment
import org.springframework.stereotype.Component

@Component
class MemberAllDataFetcher(
    val memberSearchService: MemberSearchService,
    val memberRepository: MemberRepository
) : DataFetcher<List<Member>> {
    override fun get(
        environment: DataFetchingEnvironment?
    ): List<Member> {
        val allMembers = memberRepository.findAll()
        return allMembers
    }

}