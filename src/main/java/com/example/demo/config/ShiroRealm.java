
package com.example.demo.config;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.*;
import com.example.demo.service.AdminService;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class ShiroRealm extends AuthorizingRealm {
    @Autowired
    private AdminService adminService;

    /*权限认证*/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("===执行授权===");

        Subject subject = SecurityUtils.getSubject();

        Admin user = (Admin) subject.getPrincipal();
        if (user != null) {
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            // 角色与权限字符串集合
            Collection<String> rolesCollection = new HashSet<>();
            Collection<String> premissionCollection = new HashSet<>();
            // 读取并赋值用户角色与权限
            Set<Role> roles = user.getRoles();

            for (Role role : roles) {
                rolesCollection.add(role.getrRole());
                Set<Authority> permissions = user.getPermissions();
                for (Authority permission : permissions) {
                    premissionCollection.add(String.valueOf(permission.getJId()));
                }
                info.addStringPermissions(premissionCollection);
            }
            info.addRoles(rolesCollection);
            return info;
        }
        return null;


    }



    /*用户认证*/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        /*验证用户*/
        System.out.println("===执行认证===");

        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        Admin bean = adminService.getBean(token.getUsername());

        if (bean == null) {
            throw new UnknownAccountException();
        }
        if(bean.getaState()==false){
            throw new DisabledAccountException();
        }
      //  bean.setaMail(token.getUsername());
        /*	从数据库提取的密码是明文，需要加密*/
        String hashAlgorithName = "MD5";
        String password = bean.getaPassword();
        int hashIterations = 1024;
        ByteSource credentialsSalt = ByteSource.Util.bytes(token.getUsername());
        Object obj = new SimpleHash(hashAlgorithName, password, credentialsSalt, hashIterations);

        return new SimpleAuthenticationInfo(bean, obj, credentialsSalt, getName());
    }


    /**
     * 重写方法,清除当前用户的的 授权缓存
     *
     * @param principals
     */
    @Override
    public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
        super.clearCachedAuthorizationInfo(principals);
    }

    /**
     * 重写方法，清除当前用户的 认证缓存
     *
     * @param principals
     */
    @Override
    public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
        super.clearCachedAuthenticationInfo(principals);
    }

    @Override
    public void clearCache(PrincipalCollection principals) {
        super.clearCache(principals);
    }

    /**
     * 自定义方法：清除所有 授权缓存
     */
    public void clearAllCachedAuthorizationInfo() {
        getAuthorizationCache().clear();
    }

    /**
     * 自定义方法：清除所有 认证缓存
     */
    public void clearAllCachedAuthenticationInfo() {
        getAuthenticationCache().clear();
    }

    /**
     * 自定义方法：清除所有的  认证缓存  和 授权缓存
     */
    public void clearAllCache() {
        clearAllCachedAuthenticationInfo();
        clearAllCachedAuthorizationInfo();
    }

}
