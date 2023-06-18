package com.experimental.product.community.membershipservice.repository;

import com.experimental.product.community.membershipservice.entity.CommunityV2;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommunityRepositoryV2 extends MongoRepository<CommunityV2, String> {


}
