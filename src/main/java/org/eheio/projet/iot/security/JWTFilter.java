package org.eheio.projet.iot.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import org.eheio.projet.iot.exception.AuthenticationException;
import org.eheio.projet.iot.exception.TokenExpiredException;
import org.eheio.projet.iot.exception.TokenNotValidException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;

public class JWTFilter extends OncePerRequestFilter {

    @Autowired
    private JWTProvider jwtProvider;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws TokenExpiredException, TokenNotValidException, ServletException, IOException {

        Cookie cookies[]= request.getCookies();
        String token=null;
        for (Cookie cookie:cookies) {
            if("auth".equals(cookie.getName())){
                token=cookie.getValue();
            }
        }
        if(token!=null){
            //get information from token
            Claims claims= jwtProvider.getClaimsFromToken(token);

            //check validated token
            if(claims==null){
                SecurityContextHolder.clearContext();
                throw new TokenNotValidException("Token Not Valide");
            }
            if(claims.getExpiration().before(new Date())){
                throw new TokenExpiredException("Token Expired");
            }
            // get Authentication object by  subject in token (username)
            String username=claims.getSubject();
            Authentication authentication = jwtProvider.getAuthentication(username);
            if(!authentication.isAuthenticated()){
                throw new AuthenticationException("User Not Connected");
            }
            SecurityContextHolder.getContext().setAuthentication(authentication);
            filterChain.doFilter(request,response);


        }

    }
}
