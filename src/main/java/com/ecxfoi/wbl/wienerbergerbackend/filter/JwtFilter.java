package com.ecxfoi.wbl.wienerbergerbackend.filter;

import com.ecxfoi.wbl.wienerbergerbackend.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
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
    private final JwtUtil jwtUtil;

    public JwtFilter(@Autowired JwtUtil jwtUtil)
    {
        this.jwtUtil = jwtUtil;
    }

    @Override
    protected void doFilterInternal(final HttpServletRequest request,
                                    final HttpServletResponse response,
                                    final FilterChain filterChain) throws ServletException, IOException
    {
        SecurityContextHolder.clearContext();
        final String requestToken = request.getHeader("Authorization");

        Long id;
        String jwt;

        if (requestToken != null && requestToken.startsWith("Bearer "))
        {
            String[] token = requestToken.split(" ");
            jwt = token[1];
            try
            {
                id = jwtUtil.validateAndExtractID(jwt);
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
            catch (Exception ex)
            {
                ex.printStackTrace();
                logger.error(ex.toString());
            }
        }
        filterChain.doFilter(request, response);
    }
}