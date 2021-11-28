package com.HexTechGDUT.service.impl;

import com.HexTechGDUT.entity.po.User;
import com.HexTechGDUT.service.TokenService;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author HexTechGDUT
 */
@Service
public class JwtTokenServiceImpl implements TokenService {

    /**
     * 单位：天
     */
    public static final int CALENDAR_FIELD = Calendar.DATE;

    /**
     * token 过期时间: 7天
     */
    public static final int CALENDAR_INTERVAL = 7;

    /**
     * token密钥
     */
    public static final String SECRET = "token secret service";

    /**
     * 生成token
     * @param user user
     * @return String token
     */
    @Override
    public String generate(User user){
        // 获取过期时间
        Calendar nowTime = Calendar.getInstance();
        nowTime.add(CALENDAR_FIELD, CALENDAR_INTERVAL);
        Date expiresDate = nowTime.getTime();

        // 头信息
        Map<String, Object> map = new HashMap<>(2);
        map.put("alg", "HS256");
        map.put("typ", "JWT");

        return JWT.create().withHeader(map)
                //token的签发证明人
                .withIssuer("SERVICE")
                //token的有效持有者
                .withAudience(user.getUserId())
                //token的用户权限
                .withClaim("auth", user.getUserType())
                //token签发的时间
                .withIssuedAt(Calendar.getInstance().getTime())
                //token过期的时间
                .withExpiresAt(expiresDate)
                .sign(Algorithm.HMAC256(SECRET));
    }

    /**
     * 验证Token
     * @param token token
     */
    @Override
    public void verify(String token) {
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
            verifier.verify(token);
        } catch (JWTVerificationException e) {
            throw new RuntimeException("token已失效");
        }
    }

    /**
     * 不验证token,直接获取token中的用户id
     * 通常用于验证完token后验证用户是否存在
     * @param token token
     * @return uid
     */
    public static String getTokenUid(String token){
        if(StringUtils.isEmpty(token)) {
            return "";
        }
        DecodedJWT jwt = JWT.decode(token);
        return jwt.getAudience().get(0);
    }

    /**
     * 用于获取登录用户的权限等级
     * 不验证token,直接获取token中的userType
     * @param token token
     * @return user type ( 0 , 1 )
     */
    public static int getTokenAuth(String token){
        if(StringUtils.isEmpty(token)) {
            return 0;
        }
        DecodedJWT jwt = JWT.decode(token);
        return jwt.getClaims().get("auth").asInt();
    }
}
