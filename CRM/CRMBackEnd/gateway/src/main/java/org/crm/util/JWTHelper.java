package org.crm.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.time.DateUtils;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;

public class JWTHelper {
    //签名
    private static final String  SECRET = "session_secret";
    //发行人
    private static final String  ISSUER = "admin_chen";

    //map-->token
    public static String genToken(Map<String, String> claims){

        Algorithm algorithm = null;
        try {
            //HMAC256对称加密算法，也可以换成RSA256非对称加密，ISSUER为加密数字签名的密钥
            algorithm = Algorithm.HMAC256(SECRET);
            //设置发行人及过期时间
            JWTCreator.Builder builder = JWT.create().withIssuer(ISSUER).withExpiresAt(DateUtils.addDays(new Date(), 1));
            //java8的lambda表达式的写法，遍历map中所有key-value对，并发放入到builder里


            claims.forEach((k,v) -> builder.withClaim(k, v));
            //claims.forEach(builder::withClaim);
            //签名后返回
            return builder.sign(algorithm).toString();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;

    }
    //将token-->map
    public static Map<String, String> verifyToken(String token)  {
        Algorithm algorithm = null;
        try {
            //创建算法
            algorithm = Algorithm.HMAC256(SECRET);
        } catch (IllegalArgumentException | UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        //创建验证者为验证者设置发行人
        JWTVerifier verifier = JWT.require(algorithm).withIssuer(ISSUER).build();
        //解析token
        DecodedJWT jwt =  verifier.verify(token);
        //获得所有的claims
        Map<String, Claim> map = jwt.getClaims();
        //创建map
        Map<String, String> resultMap = Maps.newHashMap();

        //放入map
        map.forEach((k,v) -> resultMap.put(k, v.asString()));

        return resultMap;
    }
}
