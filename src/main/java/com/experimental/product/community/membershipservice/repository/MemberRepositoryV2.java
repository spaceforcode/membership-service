package com.experimental.product.community.membershipservice.repository;

import com.experimental.product.community.membershipservice.entity.Member;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepositoryV2 extends MongoRepository<Member,Integer> {

    Member findById(String id);
    Member findOneByContactNumber(String contactNumber);
    Member findOneByEmailAddress(String emailAddress);

}
