package com.xxxxx.myblog.repository;


import com.xxxxx.myblog.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
    User findByLogin(String login);
}
