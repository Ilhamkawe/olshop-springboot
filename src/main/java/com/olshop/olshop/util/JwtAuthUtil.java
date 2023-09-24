package com.olshop.olshop.util;

import com.olshop.olshop.entity.UserEntity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class JwtAuthUtil {
    private final static String secretKey = "2D4A614E645267556B58703273357638792F423F4428472B4B6250655368566D";
    // extract email dari token
    public static String ExtractEmail(String token){
        return ExtractClaim(token, Claims::getSubject);
    }
    //    parse semua claim jwt
    private static Claims ExtractAllClaims(String token){
        return Jwts.parserBuilder()
                .setSigningKey(GetSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
    //    parse secretkey menjadi key
    private static Key GetSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }
    //    extract claim token
    private static <T> T ExtractClaim(String token, Function<Claims, T> claimResolver){
        final Claims claims = ExtractAllClaims(token);
        return claimResolver.apply(claims);
    }
    //    generate token
    public static String GenerateToken(Map<String, Object> extraClaims, UserEntity user){
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(user.getEmail())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 *24))
                .signWith(GetSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }
    //    generate token berdasarkan user details
    public static String GenerateToken(UserEntity user){
        return GenerateToken(new HashMap<>(), user);
    }
    //    generate refresh token
    public static String GenerateRefreshToken(UserEntity user){
        return GenerateToken(new HashMap<>(),user);
    }
    //    validasi jwttoken
    public static boolean IsTokenValid(String token, UserEntity user){
        String email = ExtractEmail(token);
        return (email.equals(user.getEmail())) && !IsTokenExpired(token);
    }
    //    extract data expire dari token
    public static Date ExtractExpiration(String token){
        return ExtractClaim(token, Claims::getExpiration);
    }
    //    validasi pakah token expire
    public static boolean IsTokenExpired(String token){
        return ExtractExpiration(token).before(new Date());
    }
}
