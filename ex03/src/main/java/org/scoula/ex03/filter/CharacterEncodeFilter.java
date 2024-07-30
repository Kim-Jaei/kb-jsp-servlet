package org.scoula.ex03.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = {"/*"})
public class CharacterEncodeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException{
    }

    @Override
    public void destroy(){
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 전처리
        request.setCharacterEncoding("UTF-8");

        // 다음 필터로 연결
        chain.doFilter(request, response);

        // 후처리 코드가 나올 수 있음
    }
}
