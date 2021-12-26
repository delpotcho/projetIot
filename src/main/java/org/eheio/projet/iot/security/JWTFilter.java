package org.eheio.projet.iot.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import org.eheio.projet.iot.dto.response.ResponseMessage;
import org.eheio.projet.iot.exception.AuthenticationException;
import org.eheio.projet.iot.exception.TokenExpiredException;
import org.eheio.projet.iot.exception.TokenNotValidException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JWTFilter extends OncePerRequestFilter {
    private JWTProvider jwtProvider;
    private final ObjectMapper mapper = new ObjectMapper();

    public JWTFilter(JWTProvider jwtProvider) {
        this.jwtProvider = jwtProvider;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws TokenExpiredException, TokenNotValidException, ServletException, IOException {

        if (!request.getRequestURI().equals("/login") && !request.getRequestURI().equals("/register")) {
            System.out.println(request.getRequestURI());
            Cookie cookies[] = request.getCookies();
            String token = null;
            if(cookies!=null){
                for (Cookie cookie : cookies) {
                    if ("auth".equals(cookie.getName())) {
                        token = cookie.getValue();
                    }
                }
            }

            if (token != null) {
                //get information from token
                Claims claims = jwtProvider.getClaimsFromToken(token);
                if (claims != null && !claims.getExpiration().before(new Date())) {
                    Authentication authentication = jwtProvider.getAuthentication(claims.getSubject());
                    if (authentication.isAuthenticated()) {
                        SecurityContextHolder.getContext().setAuthentication(authentication);
                    } else {
                        response.reset();
                        response.getWriter().write("not connected. " + HttpServletResponse.SC_UNAUTHORIZED);
                    }

                } else {
                    System.out.println("hrmm");
                    SecurityContextHolder.clearContext();
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    response.getOutputStream().write("token expired".getBytes());

                    return;
                }
            }
        }
        filterChain.doFilter(request, response);

    }

}
