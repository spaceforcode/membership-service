package com.experimental.product.community.membershipservice.repository;

import com.experimental.product.community.membershipservice.entity.Community;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommunityRepositoryV2 extends MongoRepository<Community, String> {


}
