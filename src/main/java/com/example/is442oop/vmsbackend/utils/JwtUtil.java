package com.example.is442oop.vmsbackend.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;

@Component
public class JwtUtil {

  private static final String secret = "asdfSFS34wfsdfsdfSDSD32dfsddDDerQSNCK34SOWEK5354fdgdf4";

  public static String jwtBuilder(Long id, String email, String name){
      Key key = new SecretKeySpec(Base64.getDecoder().decode(secret),
              SignatureAlgorithm.HS256.getJcaName());

      Instant now = Instant.now();
    return Jwts.builder()
              .claim("id", id)
              .claim("email", email)
              .setSubject(name)
              .setId(UUID.randomUUID().toString())
              .setIssuedAt(Date.from(now))
              .setExpiration(Date.from(now.plus(60l, ChronoUnit.MINUTES)))
              .signWith(SignatureAlgorithm.HS256, key)
              .compact();

  }

  public static Claims verifyToken(String token){
    Key hmacKey = new SecretKeySpec(Base64.getDecoder().decode(secret),
            SignatureAlgorithm.HS256.getJcaName());

    return Jwts.parser()
            .setSigningKey(hmacKey)
            .parseClaimsJws(token)
            .getBody();
  }
}
