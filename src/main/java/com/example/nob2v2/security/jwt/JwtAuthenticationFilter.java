package com.example.nob2v2.security.jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;

public class JwtAuthenticationFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        String autHeader = request.getHeader("Authorization");
        String token = null;

        if(autHeader != null && autHeader.startsWith("Bearer ")){
            token = autHeader.substring(7);
        }

        if(token != null && JWTUtil.isTokenValid(token)){
            Authentication authentication = new UsernamePasswordAuthenticationToken(
                    JWTUtil.getClaims(token).getSubject(),
                    null,
                    Collections.emptyList()
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);


        }
        filterChain.doFilter(request, response);
    }
}
