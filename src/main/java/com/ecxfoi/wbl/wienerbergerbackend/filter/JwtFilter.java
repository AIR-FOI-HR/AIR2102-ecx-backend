package com.ecxfoi.wbl.wienerbergerbackend.filter;

import com.ecxfoi.wbl.wienerbergerbackend.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter
{
    @Autowired
    private JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(final HttpServletRequest request,
                                    final HttpServletResponse response,
                                    final FilterChain filterChain) throws ServletException, IOException
    {
        if (request.getMethod().equalsIgnoreCase("OPTIONS"))
        {
            response.setStatus(HttpStatus.OK.value());
        }
        else
        {
            SecurityContextHolder.clearContext();
            final String requestToken = request.getHeader("Authorization");

            Long id = null;
            String jwt = null;

            if (requestToken != null && requestToken.startsWith("Bearer "))
            {
                jwt = requestToken.substring(7);
                id = jwtUtil.validateAndExtractID(jwt);
            }

            if (id != null && SecurityContextHolder.getContext().getAuthentication() == null)
            {
                if (jwtUtil.validateToken(jwt))
                {
                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                            id, null, null);
                    usernamePasswordAuthenticationToken
                            .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                }
            }
        }
        filterChain.doFilter(request, response);
    }
}