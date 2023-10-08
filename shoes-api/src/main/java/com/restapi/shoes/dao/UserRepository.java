package com.restapi.shoes.dao;

import com.restapi.shoes.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer>{
	User findByUsername(String username);

	User findById(String id);
}
