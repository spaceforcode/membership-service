package com.experimental.product.community.membershipservice.graphql.fetcher

import com.experimental.product.community.membershipservice.entity.Member
import com.experimental.product.community.membershipservice.repository.MemberRepository
import graphql.schema.DataFetcher
import graphql.schema.DataFetchingEnvironment
import org.springframework.stereotype.Component

@Component
class MemberDataFetcher(
    val memberRepository: MemberRepository
) : DataFetcher<Member> {
    override fun get(
        environment: DataFetchingEnvironment?
    ): Member {
        val args = environment?.arguments;
        return memberRepository.findOneById(args?.get("id").toString())
    }

}