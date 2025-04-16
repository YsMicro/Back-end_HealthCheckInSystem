package edu.vojago.backend_healthcheckinsystem;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTest {

    @Test
    public void testGen() {

        Map<String, Object> claims = new HashMap<>();
        claims.put("id", 1);
        claims.put("username", "张三");

        //生成JWT代码
        String Token = JWT.create()
                .withClaim("username", claims)  //添加载荷
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60))   //添加过期时间
                .sign(Algorithm.HMAC256("vojago"));  //指定算法，配置密钥

        System.out.println(Token);
    }

/*    @Test
    public void testParse() {
        //定义字符串，模拟用户传递token
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6eyJpZCI6MSwidXNlcm5hbWUiOiLlvKDkuIkifSwiZXhwIjoxNzQ0MzAxMzU0fQ.RDCHAiHAbddpKvzLD_YenXMfVi0fMkYh8A3J9v6dBnM";
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("vojago")).build();
        DecodedJWT decodedJWT = jwtVerifier.verify(token);  //验证token，生成解析厚的JWT对象
        Map<String, Claim> claims = decodedJWT.getClaims();
        System.out.println(claims.get("username"));

        //若篡改头部及载荷，
        //或密钥不正确，
        //或token过期，则验证失败
    }*/
}
