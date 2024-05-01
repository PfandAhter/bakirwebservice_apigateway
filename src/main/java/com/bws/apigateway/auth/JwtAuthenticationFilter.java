package com.bws.apigateway.auth;

import com.bws.apigateway.model.constants.PropertyConstants;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;

@Component
@RequiredArgsConstructor
@WebFilter(filterName = "RequestCachingFilter", urlPatterns = "/notlocked/*")
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;

    //https://www.baeldung.com/spring-exclude-filter
    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        String path = request.getRequestURI();

        ArrayList<String> pathList = new ArrayList<>();
        pathList.add("/auth/login");
        pathList.add("/auth/register");
        pathList.add("/user/activate");
        pathList.add("/stock/category/list");
        pathList.add("/stock/product/list");
        boolean check = false;

        for(int i = 0; i <pathList.size(); i++){
            check = path.startsWith(pathList.get(i));
            if(check){
                break;
            }
        }
        if(path.startsWith("/stock/product/add") || path.startsWith("/stock/category/add")){
            check = false;
        }

        return check;
    }

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain
    ) throws ServletException, IOException {
        final String authHeader = request.getHeader("Authorization");
        String jwt = "";

        final String username;
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            response.getStatus();
            filterChain.doFilter(request, response);
            return;
        }
        jwt = authHeader.split(" ")[1];
        jwt = jwtService.decryptJwt(jwt);

        try {
            username = jwtService.extractUsername(jwt);
        } catch (ExpiredJwtException e) {
            logger.error("Jwt expired");
            filterChain.doFilter(request, response);
            return;
        }
        response.getStatus();

        //fetch :almak , gidip getirmek

        // if the user already connected we dont want to do all proccess of securityContext
        // when the authentication is null means that the user is not yet authenticated./ The user not connected yet
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);

            if (jwtService.isTokenValid(jwt, userDetails)) {
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request)); // i want to build the details out of our requests out of our HTTP request
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }

        filterChain.doFilter(request, response);
    }
}
