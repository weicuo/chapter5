package com.springboot.chapter5.dao;

import com.springboot.chapter5.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JpaUserRepository extends JpaRepository<User,Long> {
    @Query("from user where user_name like concat('%',?1,'%') and note like concat('%',?2 ,'%') ")
    public List<User> findUsers(String userName,String note);
    //按用户名称模糊查询
    List<User> findByUserNameLike(String userName);
    //根据主键查询
    User getUserById(Long id);
    //根据用户名或者备注进行模糊查询
    List<User> findByUserNameLikeOrNoteLike(String userName,String note);
}
