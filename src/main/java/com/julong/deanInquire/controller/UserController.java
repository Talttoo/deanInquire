package com.julong.deanInquire.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.julong.deanInquire.dto.entity.item.Menu;
import com.julong.deanInquire.dto.entity.item.MenuList;
import com.julong.deanInquire.dto.entity.item.User;
import com.julong.deanInquire.service.UserService;
import com.julong.deanInquire.utils.data.UserUtil;
import com.julong.deanInquire.utils.other.Base64CodecUtil;
import com.julong.deanInquire.utils.other.TokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    //登录
    @PostMapping("/login")
    public Object login(@RequestParam(name = "usercode")String usercode, @RequestParam(name = "password")String password){
      // System.out.println("user:"+usercode+"password:"+password);

        JSONObject jsonObject=new JSONObject();
        User userForBase=userService.findByUserCode(usercode);
        if(userForBase==null){
            jsonObject.put("code","500");
            jsonObject.put("message","登录失败,用户不存在");
            log.error("登录失败,用户不存在");
            return jsonObject;
        }else {
            String pwd = (String)userForBase.getPassword();
            if(pwd == null){
                pwd = new String("");
            }
            else{   //加密密码解密
                pwd = Base64CodecUtil.decode(pwd);
            }
            if (pwd.compareTo(password) != 0){
                jsonObject.put("code","400");
                jsonObject.put("message","登录失败,密码错误");
                log.info("登录失败,密码错误");
                return jsonObject;
            }else {
                //根据用户权限返回显示菜单
                List<MenuList> moidList = new ArrayList<>();
                List<Menu> menuList = new ArrayList<>();
                try {
                   moidList = userService.findMoidByUser(usercode);
                   menuList = userService.showMenuByUser(usercode);
                }catch (Exception e){
                    log.error("根据用户权限查询显示菜单出错"+e.toString());
                }

                JSONArray menuStr = UserUtil.showMenuByUser(moidList,menuList);

                String token = TokenUtil.createJWT(userForBase);
                log.info("登录成功");
                jsonObject.put("code","200");
                jsonObject.put("message","登录成功");
                jsonObject.put("token", token);
                jsonObject.put("user", userForBase);
                jsonObject.put("components",menuStr);
                System.out.println("菜单："+menuStr);
                return jsonObject;
            }
        }
    }

    //退出
    @PostMapping("/logout")
    public Object loginout(){

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("code","200");
        jsonObject.put("message","退出登录登录成功");
        return jsonObject;

    }



}
