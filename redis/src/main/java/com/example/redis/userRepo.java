package com.example.redis;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface userRepo extends CrudRepository<User, String> {
    User getUserByUserInstagramName(String userInstagramName);

    @Query(value = "SELECT * FROM User WHERE folowers_amount > 20", nativeQuery = true)
    List<User> findAllActiveUsers();
}
