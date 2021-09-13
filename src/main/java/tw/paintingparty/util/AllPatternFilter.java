package tw.paintingparty.util;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

public class AllPatternFilter implements Filter {

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

	public AllPatternFilter() {
    	
    }

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("=============Passed AllPatternFilter!!===============");
		HttpServletRequest req = (HttpServletRequest)request;  
		req.getSession().setAttribute("session_member_id", 5); //DEMO用，模擬1號會員登入中，沒登入就註解
		
		chain.doFilter(request, response);
	
	}
	
	public void destroy() {
		
	}



}
