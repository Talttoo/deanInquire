package com.julong.deanInquire.utils.other;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.julong.deanInquire.dto.entity.item.User;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TokenUtil {
    private static final long EXPIRE_TIME = 1*60 * 60 * 1000;
    //private static final long EXPIRE_TIME =  10 * 1000; //过期测试
    private static final String TOKEN_SECRET = "julongtoken123456";

    /**
     * 生成签名，一个小时过期
     * @param **username**
     * @param **password**
     * @return
     */
    public static String createJWT(User user) {
        try {
            // 设置过期时间
            Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            // 私钥和加密算法
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            //System.out.println("私钥: "+algorithm);
            // 设置头部信息
            Map<String, Object> header = new HashMap<>(2);
            header.put("Type", "Jwt");
            header.put("alg", "HS256");
            // 返回token字符串
            return JWT.create()
                    .withHeader(header)
                    .withClaim("userId", user.getId())
                    .withClaim("password", user.getPassword())
                    .withExpiresAt(date)
                    .sign(algorithm);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 检验token是否正确
     * @param **token**
     * @return
     */
    public static boolean parseJWT(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    /**
     * 从token中获取username信息
     * @param **token**
     * @return
     */
    public static String getUserId(String token){
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("userId").asString();
        } catch (JWTDecodeException e){
            e.printStackTrace();
            return null;
        }
    }



}
