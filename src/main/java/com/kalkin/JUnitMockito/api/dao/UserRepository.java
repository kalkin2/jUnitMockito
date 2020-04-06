package com.kalkin.JUnitMockito.api.dao;

import com.kalkin.JUnitMockito.api.service.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User,Integer> {
    List<User> findByAddress(String address);



}
