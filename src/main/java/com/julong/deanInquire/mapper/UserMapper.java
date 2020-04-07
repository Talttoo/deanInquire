package com.julong.deanInquire.mapper;

import com.julong.deanInquire.dto.entity.item.Menu;
import com.julong.deanInquire.dto.entity.item.MenuList;
import com.julong.deanInquire.dto.entity.item.User;
import com.julong.deanInquire.provider.UserProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

@Mapper
public interface UserMapper {

    /*
     * 查找用户
     * */
    @Select("SELECT USERID as Id," +
            "USERNAME," +
            "\"PASSWORD\"" +
            " FROM WX_USER" +
            " WHERE Id=#{userId} ")
    public User findUserById(String userId);



    /*
     * 登录查找
     * */
    @SelectProvider(method = "findByUsername",type = UserProvider.class)
    public  User findByUsername(String username);

    @SelectProvider(method = "findByUserCode",type = UserProvider.class)
    public  User findByUserCode(String usercode);

    /**
     * 根据用户权限查找显示菜单
     * @param usercode
     * @return
     */
    @SelectProvider(method = "findMoidByUser",type = UserProvider.class)
    public List<MenuList> findMoidByUser(String usercode);

    /**
     * 根据用户权限查找显示菜单
     * @param usercode
     * @return
     */
    @SelectProvider(method = "showMenuByUser",type = UserProvider.class)
    public List<Menu> showMenuByUser(String usercode);


}
