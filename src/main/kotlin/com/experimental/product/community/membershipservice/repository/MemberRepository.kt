package com.experimental.product.community.membershipservice.repository

import com.experimental.product.community.membershipservice.entity.Member
import org.springframework.data.mongodb.repository.MongoRepository

interface MemberRepository : MongoRepository<Member, String> {
    fun findOneById(id: String): Member
    fun findOneByContactNumber(contactNumber: String): Member
    fun findOneByEmailAddress(emailAddress: String): Member
}