package mg.security.token;

import io.jsonwebtoken.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class JWTAuthorizationFilter extends OncePerRequestFilter {



    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        try {
            if (isJWTTokenPresent(request, response)) {
                Claims claims = validateToken(request);
                if (claims.get(JWTCommon.AUTHORITIES_CLAIM_NAME) != null) {
                    setUpSpringAuthentication(claims);
                } else {
                    SecurityContextHolder.clearContext();
                }
            } else {
                SecurityContextHolder.clearContext();
            }
            filterChain.doFilter(request, response);
        } catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException | SignatureException e) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            ((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage());
        }
    }

    private Claims validateToken(HttpServletRequest request) {
        String jwtToken = request
                .getHeader(JWTCommon.AUTH_HTTP_HEADER_NAME)
                .replace(JWTCommon.AUTH_HTTP_HEADER_CONTENT_PREFIX, "");
        return Jwts.parserBuilder()
                .setSigningKey(JWTCommon.SIGNING_KEY.getBytes())
                .build()
                .parseClaimsJws(jwtToken).getBody();
    }

    private void setUpSpringAuthentication(Claims claims) {
        @SuppressWarnings("unchecked")
        List<String> authoritiesStrings = claims.get(JWTCommon.AUTHORITIES_CLAIM_NAME, List.class);
        List<SimpleGrantedAuthority> authorities = authoritiesStrings.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(claims.getSubject(), null, authorities);

        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
    }

    private boolean isJWTTokenPresent(HttpServletRequest request, HttpServletResponse response) {
        String authenticationHeader = request.getHeader(JWTCommon.AUTH_HTTP_HEADER_NAME);
        return authenticationHeader != null && authenticationHeader.startsWith(JWTCommon.AUTH_HTTP_HEADER_CONTENT_PREFIX);
    }
}
