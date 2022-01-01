package org.eheio.projet.iot.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class JWTConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    private JWTProvider jwtProvider;
    public JWTConfig(JWTProvider jwtProvider) {
        this.jwtProvider=jwtProvider;
    }
    @Override
    public void configure(HttpSecurity builder) throws Exception {
        builder.addFilterBefore(new JWTFilter(jwtProvider), UsernamePasswordAuthenticationFilter.class);
    }
}
