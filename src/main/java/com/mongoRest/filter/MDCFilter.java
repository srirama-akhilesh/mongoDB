package com.mongoRest.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.mongoRest.impl.StoreImpl;

@Component
public class MDCFilter implements Filter{

	public static void main(String[] args) {
			// TODO Auto-generated method stub

		
		final Logger LOGGER = (Logger) LoggerFactory.getLogger(MDCFilter.class);
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		try {
		if(request instanceof ServletRequest) {
			HttpServletRequest httpServletRequest = (HttpServletRequest) request;
			
			MDC.put("correlationID", httpServletRequest.getHeader("x-correlation-id"));
		
			chain.doFilter(request, response);
		}
		}
		finally {
			MDC.clear();
		}
		
		
	    
	}

}
