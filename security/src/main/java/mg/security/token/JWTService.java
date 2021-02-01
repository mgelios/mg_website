package mg.security.token;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import mg.profile.entity.User;
import mg.profile.service.BasicUserDetailsService;
import mg.profile.service.UserService;
import mg.security.token.dto.JWTLoginRequest;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class JWTService {

    private static final String JWT_ID = "mg_jwt_id";
    private static final int TOKEN_EXPIRATION_TIME_MILLIS = 600000;

    private final UserService userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public String generateJWTToken(JWTLoginRequest loginRequest) {
        List<GrantedAuthority> grantedAuthorities = getGrantedAuthorities(loginRequest);
        SecretKey secretKey = Keys.hmacShaKeyFor(JWTCommon.SIGNING_KEY.getBytes());

        String token = Jwts.builder()
                .setId(JWT_ID)
                .setSubject(loginRequest.getUsername())
                .claim(JWTCommon.AUTHORITIES_CLAIM_NAME, grantedAuthorities.stream()
                        .map(GrantedAuthority::getAuthority)
                        .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + TOKEN_EXPIRATION_TIME_MILLIS))
                .signWith(secretKey)
                .compact();

        return JWTCommon.AUTH_HTTP_HEADER_CONTENT_PREFIX + token;
    }

    private List<GrantedAuthority> getGrantedAuthorities(JWTLoginRequest loginRequest) {
        User user = userService.findUserByUsername(loginRequest.getUsername());
        if (user != null && bCryptPasswordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            return AuthorityUtils.commaSeparatedStringToAuthorityList(
                    JWTCommon.ROLE_PREFIX + user.getRole().toString());
        }
        return AuthorityUtils.commaSeparatedStringToAuthorityList("");
    }
}
