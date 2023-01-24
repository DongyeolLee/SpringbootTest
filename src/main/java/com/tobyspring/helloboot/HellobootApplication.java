package com.tobyspring.helloboot;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@ComponentScan
public class HellobootApplication {

    @Bean
    public ServletWebServerFactory servletWebServerFactory() {
        return new TomcatServletWebServerFactory();
    }

    @Bean
    public DispatcherServlet dispatcherServlet() {
        return new DispatcherServlet();
    }

    public static void main(String[] args) {
        final AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext() {
            @Override
            protected void onRefresh() {
                super.onRefresh();

                final ServletWebServerFactory webServerFactory = getBean(ServletWebServerFactory.class);
                final DispatcherServlet dispatcherServlet = getBean(DispatcherServlet.class);

                final WebServer webServer = webServerFactory.getWebServer(servletContext -> servletContext.addServlet("dispatcherServlet",
                                                                                                                      dispatcherServlet)
                                                                                                          .addMapping("/*"));
                webServer.start();
            }
        };

        applicationContext.register(HellobootApplication.class);
        applicationContext.refresh();
    }
}
