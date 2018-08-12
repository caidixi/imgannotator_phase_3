package wnderful.imgannotator.util.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import javax.xml.crypto.Data;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtHelper {
    public String createToken(String username) throws UnsupportedEncodingException {
        Map<String, Object> map = new HashMap<>();
        map.put("alg", "HS256");
        map.put("typ", "JWT");
        return JWT.create()
                .withHeader(map)//header
                .withClaim("username", username)
                .sign(Algorithm.HMAC256("secret"));

    }

    public String verifyToken(String token,String key) throws Exception{
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(key))
                .build();
        DecodedJWT jwt = verifier.verify(token);
        Map<String, Claim> claims = jwt.getClaims();
        return claims.get("username").asString();
    }

    public String createCode(int points) throws UnsupportedEncodingException {
        Map<String, Object> map = new HashMap<>();
        map.put("alg", "HS256");
        map.put("typ", "JWT");
        Calendar calendar = Calendar.getInstance();
        return JWT.create()
                .withHeader(map)//header
                .withClaim("points", points)
                .withClaim("time",calendar.getTime())
                .sign(Algorithm.HMAC256("recharge"));

    }

    public int verifyCode(String token,String key) throws Exception{
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(key))
                .build();
        DecodedJWT jwt = verifier.verify(token);
        Map<String, Claim> claims = jwt.getClaims();
        return claims.get("points").asInt();
    }
}
