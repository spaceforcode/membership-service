package com.experimental.product.community.membershipservice.repository;

import com.experimental.product.community.membershipservice.entity.CommunityV2;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CommunityRepositoryV2 extends MongoRepository<CommunityV2, String> {
    Optional<CommunityV2> findById(String id);

}
