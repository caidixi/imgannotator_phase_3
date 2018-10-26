package wnderful.imgannotator.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import wnderful.imgannotator.exception.RechargeException;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class JwtHelper {
    private final String login_secret = "secret";
    private final String credit_secret = "recharge";

    public String createToken(String username) throws UnsupportedEncodingException {
        Map<String, Object> map = new HashMap<>();
        map.put("alg", "HS256");
        map.put("typ", "JWT");
        return JWT.create()
                .withHeader(map)//header
                .withClaim("username", username)
                .sign(Algorithm.HMAC256(login_secret));

    }

    public String verifyToken(String token) throws Exception {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(login_secret))
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
                .withClaim("time", calendar.getTime())
                .sign(Algorithm.HMAC256(credit_secret));

    }

    public int verifyCode(String token) throws RechargeException {
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(credit_secret))
                    .build();
            DecodedJWT jwt = verifier.verify(token);
            Map<String, Claim> claims = jwt.getClaims();
            return claims.get("points").asInt();
        } catch (UnsupportedEncodingException ex) {
            throw new RechargeException();
        }
    }
}
