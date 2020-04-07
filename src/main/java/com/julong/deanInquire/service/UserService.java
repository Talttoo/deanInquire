package com.julong.deanInquire.service;

import com.julong.deanInquire.dto.entity.item.Menu;
import com.julong.deanInquire.dto.entity.item.MenuList;
import com.julong.deanInquire.dto.entity.item.User;
import com.julong.deanInquire.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

//@CacheConfig(cacheNames = "user",cacheManager = "userCacheManager")   //抽取缓存的公共配置
@Service
public class UserService {
    @Autowired
    UserMapper userMapper;


    public User findUserById(String userId){

        User  user  = userMapper.findUserById(userId);

        return  user;
    }

    public User findByUsername(String username){
       // System.out.println("测试缓存-开始查询");
        User  userForBase  = userMapper.findByUsername(username);
       // System.out.println("测试缓存-查询完毕");
        return  userForBase;
    }


    public User findByUserCode(String usercode){
        //System.out.println("测试缓存-开始查询");
        User  userForBase  = userMapper.findByUserCode(usercode);
        //System.out.println("测试缓存-查询完毕");
        return  userForBase;
    }

    public List<MenuList> findMoidByUser(String usercode){

        List<MenuList> list = userMapper.findMoidByUser(usercode);
        return list;
    }

    public List<Menu> showMenuByUser(String usercode){

        List<Menu> menu = userMapper.showMenuByUser(usercode);
        return menu;
    }





}
