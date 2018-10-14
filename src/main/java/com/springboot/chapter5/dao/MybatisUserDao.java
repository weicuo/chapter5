package com.springboot.chapter5.dao;

import com.springboot.chapter5.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface MybatisUserDao {
    public User getUser(Long id);
}
