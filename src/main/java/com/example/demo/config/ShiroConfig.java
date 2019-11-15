/*


package com.example.demo.config;



import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.mgt.RememberMeManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.AbstractShiroFilter;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.MethodInvokingFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.LinkedHashMap;
import java.util.Map;


@Configuration
public class ShiroConfig {
    @Bean("hashedCredentialsMatcher")
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher credentialsMatcher =
                new HashedCredentialsMatcher();
        //指定加密方式为MD5
       credentialsMatcher.setHashAlgorithmName("MD5");
        //加密次数
        credentialsMatcher.setHashIterations(1024);
        credentialsMatcher.setStoredCredentialsHexEncoded(true);
        return credentialsMatcher;
    }

    @Bean("userRealm")
    public ShiroRealm userRealm(@Qualifier("hashedCredentialsMatcher")
                                       HashedCredentialsMatcher matcher) {

        ShiroRealm userRealm = new ShiroRealm();
        userRealm.setCredentialsMatcher(matcher);
        userRealm.setName("AUTH");
        userRealm.setCachingEnabled(true);



        userRealm.setAuthenticationCachingEnabled(true);
        userRealm.setAuthenticationCacheName("authenticationCache");

        //启用授权缓存，即缓存AuthorizationInfo信息，默认false
        userRealm.setAuthorizationCachingEnabled(true);
        //缓存AuthorizationInfo信息的缓存名称  在ehcache-shiro.xml中有对应缓存的配置
        userRealm.setAuthorizationCacheName("authorizationCache");

        return userRealm;
    }

    @Bean
    public ShiroFilterFactoryBean shirFilter(@Qualifier("securityManager")  DefaultWebSecurityManager securityManager) {

        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        // 设置 SecurityManager
        bean.setSecurityManager(securityManager);
        // 设置登录成功跳转Url
        bean.setSuccessUrl("/bs/mainpod");
        // 设置登录跳转Url
        bean.setLoginUrl("/bs/login");
        // 设置未授权提示Url
       // bean.setUnauthorizedUrl("/bs/error");




        Map<String, String> filterMap = new LinkedHashMap<>();
        filterMap.put("/login","anon");
        filterMap.put("/bs/mainpod","authc");

        filterMap.put("/bs/Verification","anon");
        filterMap.put("/bs/toLogin","anon");

        filterMap.put("/static/**","anon");
        filterMap.put("/css/**","anon");
        filterMap.put("/js/**","anon");
        filterMap.put("/dist/**","anon");
        filterMap.put("/fonts/**","anon");
        filterMap.put("/img/**","anon");
        filterMap.put("/mainpod/**","anon");

        filterMap.put("/logout", "logout");

        bean.setFilterChainDefinitionMap(filterMap);
        return bean;
    }



 @Bean(name="securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(
            HashedCredentialsMatcher hashedCredentialsMatcher) {

        DefaultWebSecurityManager securityManager =
                new DefaultWebSecurityManager();
        // 关联realm.
        securityManager.setRealm(userRealm(hashedCredentialsMatcher));
        securityManager.setCacheManager(ehCacheManager());


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
        authorizationAttributeSourceAdvisor.setSecurityManager(getDefaultWebSecurityManager(hashedCredentialsMatcher()));
        return authorizationAttributeSourceAdvisor;
    }
 @Bean(name="securityManager")
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm(hashedCredentialsMatcher()));
        // 注入记住我管理器;
        securityManager.setCacheManager(ehCacheManager());
        return securityManager;

    }


  @Bean
    public EhCacheManager ehCacheManager(){
        EhCacheManager cacheManager = new EhCacheManager();
        cacheManager.setCacheManagerConfigFile("classpath:ehcache.xml");
        return cacheManager;
    }

}
*/


