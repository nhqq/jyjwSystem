package cdu.jyjw.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "EncodingFilter",urlPatterns = {"/*"})
public class EncodingFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)servletRequest;
		HttpServletResponse response = (HttpServletResponse)servletResponse;
//		System.out.println("EncodingFilter:requestURI=" + request.getRequestURI());
		if(request.getMethod().equals("GET")){
			request=new EncodingWrapper(request);
		}else {
			request.setCharacterEncoding("utf-8");
		}

		filterChain.doFilter(request, servletResponse);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
