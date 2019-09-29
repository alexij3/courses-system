package com.buzilov.studying.practice.courses.security.jwt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthEntryPoint implements AuthenticationEntryPoint {

    private static final Logger logger = LoggerFactory.getLogger(JwtAuthEntryPoint.class);

    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException e)
            throws IOException, ServletException {

        if (e instanceof BadCredentialsException) {
            logger.error("Bad credentials. {}", e);
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Username or password is wrong.");
        } else {
            logger.error("Unauthorized error. Message - {}", e.getMessage());
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Error -> Unauthorized");
        }
    }

}
