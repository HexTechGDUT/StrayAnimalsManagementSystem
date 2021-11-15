package com.HexTechGDUT.security;

import com.HexTechGDUT.po.user.User;
import com.HexTechGDUT.service.impl.UserServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author HexTechGDUT
 */
@Component("UserRealm")

public class UserRealm extends AuthorizingRealm {

    @Autowired
    UserServiceImpl userService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //拿到当前登录的对象
        Subject subject = SecurityUtils.getSubject();
        //拿到User对象
        User currentUser = (User) subject.getPrincipal();
        System.out.println(currentUser.toString());
        //设置权限
        info.addStringPermission(currentUser.getAuth().getAuthStr());
        return info;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken userToken = (UsernamePasswordToken) token;
        //连接真实的数据库
        User user = userService.queryUserByUid(userToken.getUsername());
        if(user == null){
            return null;
        }
        //密码加密
        //密码认证
        return new SimpleAuthenticationInfo(user, user.getPwd(),"UserRealm");
    }
}
