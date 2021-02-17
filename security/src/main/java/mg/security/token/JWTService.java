package mg.security.token;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.AllArgsConstructor;
import mg.profile.dto.UserDto;
import mg.profile.entity.User;
import mg.profile.mapper.UserMapper;
import mg.profile.service.UserService;
import mg.security.token.dto.JWTLoginRequest;
import mg.security.token.dto.JWTLoginResponse;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
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
    private static final int TOKEN_EXPIRATION_TIME_MILLIS = 6000000;

    private final UserService userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserMapper userMapper;

    public JWTLoginResponse generateLoginResponse(JWTLoginRequest loginRequest) {
        String token = generateJWTToken(loginRequest);
        if (token != null) {
            return JWTLoginResponse.builder()
                    .token(token)
                    .profile(userMapper.mapToResponseDto(userService.findUserByUsername(loginRequest.getUsername())))
                    .build();
        } else {
            return null;
        }
    }

    public String generateJWTToken(JWTLoginRequest loginRequest) {
        List<GrantedAuthority> grantedAuthorities = getGrantedAuthorities(loginRequest);
        if (grantedAuthorities != null) {
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
        } else {
            return null;
        }
    }

    private List<GrantedAuthority> getGrantedAuthorities(JWTLoginRequest loginRequest) {
        User user = userService.findUserByUsername(loginRequest.getUsername());
        if (user != null && bCryptPasswordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            return AuthorityUtils.commaSeparatedStringToAuthorityList(
                    JWTCommon.ROLE_PREFIX + user.getRole().toString());
        }
        return null;
    }
}
