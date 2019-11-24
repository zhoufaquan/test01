package com.example.demo.service;

import com.example.demo.entity.Authority;
import com.example.demo.entity.Menu;
import com.example.demo.mapper.AuthorityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorityService {
    @Autowired
    private AuthorityMapper authorityMapper;
    @Cacheable(value = "users",key = "#limited")
    public  List<Menu> getMenu(int limited){
        //已经获取所有根节点还是所有菜单
        List<Authority> authorities=authorityMapper.selectByRole(limited);
      //  System.out.println(authorities);
      // 获取所有根节点
        List<Menu> menu=new ArrayList<>(3);
        for(int i=0;i<authorities.size();i++){
            if(authorities.get(i).getPid()==null){
                menu.add(authorities.get(i));
            }
        }
        for (Menu menus:menu){
            /* 获取根节点下的所有子节点 使用getChild方法*/
            menus.setChildMenus(getChild(menus.getJId(),authorities));
        }
        return menu;
    }
    public List<Menu> getChild(int id,List<Authority> authorities){
        List<Menu> childList = new ArrayList<>();
        for (Menu menu : authorities) {
            // 遍历所有节点，将父菜单id与传过来的所有菜单id比较
            if (menu.getPid()!=null) {
                if (menu.getPid()==id) {
                    childList.add(menu);
                }
            }
        }
      //  System.out.println(childList);
        // 把子菜单的子菜单再循环一遍
        for (Menu menu : childList) {// 没有url子菜单还有子菜单
          if (childList.size() != 0) {
                // 递归
                menu.setChildMenus(getChild(menu.getJId(), authorities));
            } else {
              return null;
          }
        } // 如果节点下没有子节点，返回一个空List（递归退出）

        return childList;
    }


}
