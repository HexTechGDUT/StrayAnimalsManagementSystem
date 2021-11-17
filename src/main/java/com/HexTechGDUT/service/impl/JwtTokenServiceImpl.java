package com.HexTechGDUT.service.impl;

import com.HexTechGDUT.bo.LoginBo;
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
     * token 过期时间: 10天
     */
    public static final int CALENDAR_INTERVAL = 10;

    /**
     * token密钥
     */
    public static final String SECRET = "...";

    /**
     * 生成token
     * @param loginBo uid & pwd
     * @return String token
     */
    @Override
    public String generate(LoginBo loginBo){
        // 获取过期时间
        Calendar nowTime = Calendar.getInstance();
        nowTime.add(CALENDAR_FIELD, CALENDAR_INTERVAL);
        Date expiresDate = nowTime.getTime();

        // 头信息
        Map<String, Object> map = new HashMap<>(2);
        map.put("alg", "HS256");
        map.put("typ", "JWT");

        return JWT.create().withHeader(map)
                .withIssuer("SERVICE")
                .withAudience(loginBo.getUid())
                .withIssuedAt(nowTime.getTime())
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
     * @param token token
     * @return uid
     */
    public String getTokenUid(String token){
        if(StringUtils.isEmpty(token)) {
            return "";
        }
        DecodedJWT jwt = JWT.decode(token);
        return jwt.getAudience().get(0);
    }
}
