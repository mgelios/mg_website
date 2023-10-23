package mg.security.token;

import io.jsonwebtoken.Jwts;

import javax.crypto.SecretKey;

public class JWTCommon {

    //public static final String SIGNING_KEY = UUID.randomUUID().toString();
    public static final SecretKey SIGNING_KEY = Jwts.SIG.HS256.key().build();

    public static final String AUTH_HTTP_HEADER_NAME = "Authorization";
    public static final String AUTH_HTTP_HEADER_CONTENT_PREFIX = "Bearer ";

    public static final String AUTHORITIES_CLAIM_NAME = "authorities";

    public static final String ROLE_PREFIX = "ROLE_";
}
