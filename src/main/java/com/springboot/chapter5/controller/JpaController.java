package com.springboot.chapter5.controller;

import com.springboot.chapter5.dao.JpaUserRepository;
import com.springboot.chapter5.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/jpa")
public class JpaController {
    @Autowired
    private JpaUserRepository jpaUserRepository;
    @RequestMapping("/getUser")
    @ResponseBody
    public User getUser(Long id){
        //使用jpa接口查询对象
        User user = jpaUserRepository.findById(id).get();
        return user;
    }
    @RequestMapping("/getUserById")
    @ResponseBody
    public User getUserById(Long id){
        //使用jpa接口查询对象
        User user = jpaUserRepository.getUserById(id);
        return user;
    }
    @RequestMapping("/findByUserNameLike")
    @ResponseBody
    public List<User> findByUserNameLike(String userName){
        //使用jpa接口查询对象
        List<User> userList = jpaUserRepository.findByUserNameLike("%" + userName + "%");
        return userList;
    }
    @RequestMapping("/findByUserNameLikeOrNoteLike")
    @ResponseBody
    public List<User> findByUserNameLikeOrNoteLike(String userName,String note){
        //使用jpa接口查询对象
        List<User> userList = jpaUserRepository.findByUserNameLikeOrNoteLike(userName, note);
        return userList;
    }
}
