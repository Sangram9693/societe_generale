package com.sg.societe_generale.CORS;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
/**
 * @author Sangram Badi
 * @since  18-06-2019
 */
@Component
public class CROSFilter implements Filter{

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filter)
			throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) req;
	    HttpServletResponse response = (HttpServletResponse) resp;

	    response.setHeader("Access-Control-Allow-Origin", "*");
	    response.setHeader("Access-Control-Allow-Credentials", "true");
	    response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE, HEAD");
	    response.setHeader("Access-Control-Expose-Headers", "Content-Type, Accept, X-Requested-With");
	    response.setHeader("Access-Control-Allow-Headers", "Origin, Content-Type, Accept, X-Requested-With");

	    filter.doFilter(req, resp);		
	}

}