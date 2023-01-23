package com.tobyspring.helloboot;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.tobyspring.helloboot.configuration.SimpleConfiguration;

public class HellobootApplication {

    public static void main(String[] args) {
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext() {
            @Override
            protected void onRefresh() {
                super.onRefresh();

                TomcatServletWebServerFactory webServerFactory = new TomcatServletWebServerFactory();
                WebServer webServer = webServerFactory.getWebServer(servletContext -> servletContext.addServlet("dispatcherServlet",
                                                                                                                new DispatcherServlet(this))
                                                                                                    .addMapping("/*"));
                webServer.start();
            }
        };

        applicationContext.register(SimpleConfiguration.class);
        applicationContext.refresh();
    }
}
