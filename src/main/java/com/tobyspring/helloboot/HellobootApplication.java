package com.tobyspring.helloboot;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import com.tobyspring.helloboot.controller.HelloController;

public class HellobootApplication {

    public static void main(String[] args) {
        TomcatServletWebServerFactory webServerFactory = new TomcatServletWebServerFactory();
        WebServer webServer = webServerFactory.getWebServer(servletContext -> {
            HelloController helloController = new HelloController();
            servletContext.addServlet("hello", new HttpServlet() {
                @Override
                protected void service(HttpServletRequest req, HttpServletResponse resp)
                    throws IOException {
                    System.out.println("<<<<< Servlet >>>>>");
                    // 공통 기능 구현 (인증, 다국어, 로깅 등등)
                    if (req.getRequestURI().equals("/hello") && req.getMethod().equals(HttpMethod.GET.name())) {
                        String name = req.getParameter("name");

                        String ret = helloController.hello(name);

                        resp.setStatus(HttpStatus.OK.value());
                        resp.setContentType(MediaType.TEXT_PLAIN_VALUE);
                        resp.getWriter().print(ret);
                    } else if (req.getRequestURI().equals("/user")) {
                        //
                    } else {
                        resp.setStatus(HttpStatus.NOT_FOUND.value());
                    }
                }
            }).addMapping("/*");
        });
        webServer.start();
    }
}
