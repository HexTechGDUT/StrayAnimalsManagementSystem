package com.HexTechGDUT.security;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 权限配置类
 * @author HexTechGDUT
 */
@Configuration
public class ShiroConfig {

    @Bean(name = "shiroFilterFactoryBean")
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //设置安全管理器
        bean.setSecurityManager(defaultWebSecurityManager);
        //添加Shiro内置过滤器
        Map<String, Filter> filter = new LinkedHashMap<>();
//        filter.put("loginFilter", getLoginFilter());
        bean.setFilters(filter);
        //拦截
        Map<String, String> filterMap = new LinkedHashMap<>();
//        filterMap.put("/index", "anon");
//        filterMap.put("/user/register", "anon");
//        filterMap.put("/user/login", "anon");
//        filterMap.put("/user/*", "authc");
        bean.setFilterChainDefinitionMap(filterMap);
        //设置登录的请求
        bean.setLoginUrl("/user/login");
        //未授权请求
        bean.setUnauthorizedUrl("/user/login");
        bean.setSuccessUrl("/index");
        return bean;
    }

    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    @Bean("loginFilter")
    public LoginFilter getLoginFilter(){
        return new LoginFilter();
    }

    @Bean(name = "userRealm")
    public UserRealm userRealm(){
        return new UserRealm();
    }

}
