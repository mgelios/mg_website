package mg.security;

import com.vladsch.flexmark.util.collection.MapEntry;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import mg.profile.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/token")
public class TokenLoginController {

    //TODO : make secure shared class with uuid as secret key to parse requests
    private final String secretKeyRaw = UUID.randomUUID().toString();

    @PostMapping("/login")
    public Object login(@RequestParam("username") String username, @RequestParam("password") String password) {
        String token = getJWTToken(username);
        User user = new User();
        user.setUsername(username);
        return new MapEntry<Object, Object>(user, token);
    }

    private String getJWTToken(String username) {
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("USER");

        SecretKey secretKey = Keys.hmacShaKeyFor(secretKeyRaw.getBytes());

        String token = Jwts.builder()
                .setId("mgJWT")
                .setSubject(username)
                .claim("authorities", grantedAuthorities.stream()
                        .map(GrantedAuthority::getAuthority)
                        .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(secretKey)
                .compact();

        return "Bearer " + token;
    }
}
