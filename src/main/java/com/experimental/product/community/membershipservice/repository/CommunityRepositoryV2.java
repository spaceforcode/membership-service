package com.experimental.product.community.membershipservice.repository;

import com.experimental.product.community.membershipservice.entity.Community;
import com.experimental.product.community.membershipservice.entity.Member;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CommunityRepositoryV2 extends MongoRepository<Community, String> {


    Optional<Community> findById(String id);


    Community findOneByName(String name);

}
