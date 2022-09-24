package hack.healthcare.server.filter;

import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletResponse;


/**
 * Servlet Filter implementation class CorsFilter
 */
public class CorsFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletResponse resp = (HttpServletResponse)response;
		resp.addHeader("Access-Control-Allow-Origin", "*");
		resp.addHeader("Access-Control-Allow-Headers", "*");
		resp.addHeader("Access-Control-Allow-Methods", "*");
		chain.doFilter(request, response);
	}

}
