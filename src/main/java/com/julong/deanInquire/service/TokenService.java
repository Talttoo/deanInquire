package com.julong.deanInquire.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.julong.deanInquire.dto.entity.item.User;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

    public String getToken(User user) {
        String token="";
        token= JWT.create().withAudience(user.getId())
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }

}
