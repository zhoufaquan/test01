

package com.example.demo.config;



import com.example.demo.entity.Admin;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;

import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;


@Configuration
public class Shiro {

/*加密*/

    @Bean("hashedCredentialsMatcher")
    public HashedCredentialsMatcher hashedCredentialsMatcher() { HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        credentialsMatcher.setHashAlgorithmName("MD5");
        credentialsMatcher.setHashIterations(1024);

        credentialsMatcher.setStoredCredentialsHexEncoded(true);
        return credentialsMatcher;
    }

    @Bean("userRealm")
    public ShiroRealm userRealm(@Qualifier("hashedCredentialsMatcher") HashedCredentialsMatcher matcher) {
        ShiroRealm userRealm = new ShiroRealm();
        userRealm.setCredentialsMatcher(matcher);
        return userRealm;
    }

    @Bean
    public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {

        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        // 设置 SecurityManager
        bean.setSecurityManager(securityManager);
        // 设置登录成功跳转Url
        bean.setSuccessUrl("/bs/mainpod");
        // 设置登录跳转Url
        bean.setLoginUrl("/bs/login");
        //自定义拦截器

         Map<String, Filter> filtersMap = new LinkedHashMap<String, Filter>();
        //限制同一帐号同时在线的个数。
        filtersMap.put("kickout", kickoutSessionControlFilter());
        bean.setFilters(filtersMap);



        Map<String, String> filterMap = new LinkedHashMap<String, String>();
        filterMap.put("/bs/login","anon");
        filterMap.put("/bs/mainpod","authc");

        filterMap.put("/bs/logout", "anon");
        filterMap.put("/bs/Verification","anon");
        filterMap.put("/bs/toLogin","anon");

        filterMap.put("/static/**","anon");
        filterMap.put("/css/**","anon");
        filterMap.put("/js/**","anon");
        filterMap.put("/dist/**","anon");
        filterMap.put("/fonts/**","anon");
        filterMap.put("/img/**","anon");
        filterMap.put("/mainpod/**","anon");
        filterMap.put("/bs/300", "anon");
        filterMap.put("/bs/**", "authc,kickout");



        bean.setFilterChainDefinitionMap(filterMap);
        return bean;
    }

    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 设置realm.
        securityManager.setRealm(userRealm(hashedCredentialsMatcher()));
        // 自定义缓存实现 使用redis
        securityManager.setCacheManager(cacheManager());

        // 自定义session管理 使用redis
        securityManager.setSessionManager(sessionManager());
        return securityManager;
    }



    @Bean
    LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }
    @Bean
    @DependsOn({"lifecycleBeanPostProcessor"})
    public  DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator(){
        DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        advisorAutoProxyCreator.setProxyTargetClass(true);
        return advisorAutoProxyCreator;
    }
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(){
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager());
        return authorizationAttributeSourceAdvisor;
    }



/**
     * cacheManager 缓存 redis实现
     * 使用的是shiro-redis开源插件
     *
     * @return
     */

    public CacheManager cacheManager() {
        RedisCacheManager redisCacheManager = new RedisCacheManager();
        redisCacheManager.setRedisManager(redisManager());

        return redisCacheManager;
    }


/**
     * 配置shiro redisManager
     * 使用的是shiro-redis开源插件
     *
     * @return
     */

    public RedisManager redisManager() {
        RedisManager redisManager = new RedisManager();
        redisManager.setHost("localhost");
        redisManager.setPort(6379);
        redisManager.setExpire(1800);// 配置缓存过期时间
        redisManager.setTimeout(0);
        // redisManager.setPassword(password);
        return redisManager;
    }


/**
     * Session Manager
     * 使用的是shiro-redis开源插件
     */

   @Bean
    public DefaultWebSessionManager sessionManager() {
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        sessionManager.setSessionDAO(redisSessionDAO());
        return sessionManager;
    }


/**
     * RedisSessionDAO shiro sessionDao层的实现 通过redis
     * 使用的是shiro-redis开源插件
     */

    @Bean
    public RedisSessionDAO redisSessionDAO() {
        RedisSessionDAO redisSessionDAO = new RedisSessionDAO();
        redisSessionDAO.setRedisManager(redisManager());
        return redisSessionDAO;
    }


/**
     * 限制同一账号登录同时登录人数控制
     *
     * @return
     */
   @Bean
    public KickoutSessionControlFilter kickoutSessionControlFilter() {
        KickoutSessionControlFilter kickoutSessionControlFilter = new KickoutSessionControlFilter();
        kickoutSessionControlFilter.setCacheManager(cacheManager());
        kickoutSessionControlFilter.setSessionManager(sessionManager());
        kickoutSessionControlFilter.setKickoutAfter(false);
        kickoutSessionControlFilter.setMaxSession(1);
        kickoutSessionControlFilter.setKickoutUrl("/bs/300");
        return kickoutSessionControlFilter;
    }


}


