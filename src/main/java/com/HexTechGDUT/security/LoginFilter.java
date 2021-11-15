package com.HexTechGDUT.security;

import com.HexTechGDUT.result.Result;
import com.HexTechGDUT.utils.ResultUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * @author DukeMetatron
 */
public class LoginFilter extends AccessControlFilter {

    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) {
        Subject subject = SecurityUtils.getSubject();
        if(subject != null){
            if(subject.isRemembered()){
                return true;
            }
            return subject.isAuthenticated();
        }
        return false;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) {
        Result<ServletRequest> result = ResultUtils.noPermitWithInfo(null, "请先登录");
        ResultUtils.sendResult((HttpServletResponse) servletResponse, result);
        return false;
    }
}
