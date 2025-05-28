package org.scoula.servletlifecycle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(value="/life-cycle")
public class LifeCycleTest extends HttpServlet {
    private int initCount = 1;
    private int serviceCount = 1;
    private int destoryCount = 1;

    // 서블릿 컨테이너가 종료될 때 호출되는 메서드
    @Override
    public void destroy() {
        System.out.println("destory() 메서드 호출 : " + destoryCount++);
    }

    // 최초 서블릿 요청시 호출되는 메서드
    @Override
    public void init() throws ServletException {
        System.out.println("init() 메서드 호출 : " + initCount++);
    }

    // 서블릿 컨테이너에 의해 호출되며, 최초 요청시에는 init() 다음으로 동작
    @Override
    public void service(ServletRequest req, ServletResponse res)
        throws ServletException, IOException {

        System.out.println("service() 메서드 호출 : " + serviceCount++);
    }
}
