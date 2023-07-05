package com.experimental.product.community.membershipservice.repository;

import com.experimental.product.community.membershipservice.entity.MemberV2;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepositoryV2 extends MongoRepository<MemberV2,String> {

    MemberV2 findOneByContactNumber(String contactNumber);
    MemberV2 findOneByEmailAddress(String emailAddress);

}
