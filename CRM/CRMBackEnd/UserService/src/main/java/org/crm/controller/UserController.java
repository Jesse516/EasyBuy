package org.crm.controller;
import com.google.common.collect.ImmutableMap;
import org.crm.domain.SysUser;
import org.crm.service.UserService;
import org.crm.util.JWTHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.*;
import java.util.concurrent.TimeUnit;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value="/userlogin/{username}/{password}",produces = "application/json;charset=utf-8")
    public SysUser login(@PathVariable("username") String username, @PathVariable("password")String password){
       SysUser user = userService.findByNameAndPwd(username,password);
       if(user!=null){
           return user;
       }
        return null;
    }

    @GetMapping(value="/findAllUser",produces = "application/json;charset=utf-8")
    public List<SysUser> findAllSysUser(){
        return userService.findAllSysUser();
    }

    @GetMapping(value="/logOut/{token}")
    public void logOut(@PathVariable("token") String token){
        userService.logOut(token);
    }

}
