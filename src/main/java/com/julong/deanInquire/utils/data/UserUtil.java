package com.julong.deanInquire.utils.data;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.julong.deanInquire.dto.entity.item.Menu;
import com.julong.deanInquire.dto.entity.item.MenuList;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class UserUtil {
    /**
     * 根据用户权限查询菜单，并遍历改成前端所需的数据格式
     * @param moidList
     * @param menuList
     * @return
     */
    public static JSONArray showMenuByUser(List<MenuList> moidList, List<Menu> menuList){

        List lists = new ArrayList<>();


       // System.out.println("模块："+moidList);
       // System.out.println("菜单："+menuList);
        //外循环根据模块数遍历
        for(int i=0; i<moidList.size(); i++){
            MenuList menuList1 = new MenuList();
            List list = new ArrayList<>();

            long moid = moidList.get(i).getMOID();
            menuList1.setMOID(moid);
            menuList1.setMONAME(moidList.get(i).getMONAME());
            //内循环，根据该模块的显示功能数
            for(int j=0; j<menuList.size(); j++) {
                if(menuList.get(j).getMOID()==moid){
                    list.add(menuList.get(j));
                }
            }

           String listStr = JSON.toJSONString(list);
            JSONArray jsonArray = JSON.parseArray(listStr);
            menuList1.setList(jsonArray);
            //添加到前端所需数据格式的list
            lists.add(menuList1);
        }
        //System.out.println(lists.toString());
        String listStr = JSON.toJSONString(lists);
        JSONArray jsonArray = JSON.parseArray(listStr);
        System.out.println(jsonArray.toString());
        return  jsonArray;

    }
}
