package com.platzi.platzimarket.web.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Component
public class JWTUtil {

    private static final  String KEY = "pl4tz1";

    public String generateToken(UserDetails userDetails){
        return Jwts.builder().setSubject(userDetails.getUsername()).setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + TimeUnit.HOURS.toMillis(10)))
                .signWith(SignatureAlgorithm.HS256, KEY).compact();
    }
}
