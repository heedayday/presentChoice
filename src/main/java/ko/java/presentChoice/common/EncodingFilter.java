package ko.java.presentChoice.common;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@Slf4j
@WebFilter("/*")
public class EncodingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("Initializing EncodingFilter");
        System.out.println("Initializing EncodingFilter");
        // 초기화 코드가 필요하면 여기에 작성
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        log.info("Encoding Filter");
        System.out.println("Encoding Filter");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        chain.doFilter(request, response); // 다음 필터 or 서블릿으로 전달
    }

    @Override
    public void destroy() {
        log.info("Destroying EncodingFilter");
        System.out.println("Destroying EncodingFilter");
        // 자원 정리 코드가 필요하면 여기에 작성
    }
}
