package com.experimental.product.community.membershipservice.repository

import com.experimental.product.community.membershipservice.entity.Member
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository

interface MemberRepository: MongoRepository<Member, String> {
    fun findOneById(id: String): Member
    fun findOneByContactNumber(contactNumber: String): Member
}