package com.calpha.hospital.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.AccessDeniedHandler;
//import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
public class HospitalAccessDeniedHandler implements AccessDeniedHandler {

	private static Logger LOGGER = LoggerFactory.getLogger(HospitalAccessDeniedHandler.class);

    /**
    * Custom 403 access denied handler
    */
    //@Component
	public HospitalAccessDeniedHandler() {
		// TODO Auto-generated constructor stub
	}


	    @Override
	    public void handle(HttpServletRequest httpServletRequest,
	                       HttpServletResponse httpServletResponse,
	                       AccessDeniedException e) throws IOException, ServletException {

	        Authentication auth
	                = SecurityContextHolder.getContext().getAuthentication();

	        if (auth != null) {
	        	LOGGER.info(String.format("User '%s' attempted to access the protected URL: %s", auth.getName(), httpServletRequest.getRequestURI()));
	        }

	        httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/403");

	    }
}
