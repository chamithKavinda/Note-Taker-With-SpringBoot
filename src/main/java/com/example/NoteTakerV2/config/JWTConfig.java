package com.example.NoteTakerV2.config;

import com.example.NoteTakerV2.service.JWTService;
import com.example.NoteTakerV2.service.UserService;
import io.micrometer.common.util.StringUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

@Configuration
@RequiredArgsConstructor
public class JWTConfig extends OncePerRequestFilter {
    private final JWTService jwtService;
    private final UserService userService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String initToken = request.getHeader("Authorization");
        String userEmail;
        String jwtToken;
        //Initial validation
        if (StringUtils.isEmpty(initToken) || !initToken.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }
        //Token received
        jwtToken = initToken.substring(7);
        userEmail = jwtService.extractUsername(jwtToken);
        //userEmail validation
        if (StringUtils.isNotEmpty(userEmail) &&
                SecurityContextHolder.getContext().getAuthentication() == null) {
            //load user details based on the email
            var loadedUser =
                    userService.userDetailsService().loadUserByUsername(userEmail);
            if (jwtService.isTokenValid(jwtToken, loadedUser)) {
                SecurityContext emptyContext =
                        SecurityContextHolder.createEmptyContext();
                UsernamePasswordAuthenticationToken newContext =
                        new UsernamePasswordAuthenticationToken(loadedUser, null, loadedUser.getAuthorities());
            }
        }
    }
}
