package com.buzilov.studying.practice.courses.repository;

import com.buzilov.studying.practice.courses.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
