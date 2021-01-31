package mg.security.token;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import mg.security.token.dto.JWTLoginRequest;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class JWTService {

    public String getJWTToken(JWTLoginRequest loginRequest) {
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList(JWTCommon.ROLE_PREFIX + "USER");

        SecretKey secretKey = Keys.hmacShaKeyFor(JWTCommon.SIGNING_KEY.getBytes());

        String token = Jwts.builder()
                .setId("mgJWT")
                .setSubject(loginRequest.getUsername())
                .claim(JWTCommon.AUTHORITIES_CLAIM_NAME, grantedAuthorities.stream()
                        .map(GrantedAuthority::getAuthority)
                        .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(secretKey)
                .compact();

        return JWTCommon.AUTH_HTTP_HEADER_CONTENT_PREFIX + token;
    }
}
