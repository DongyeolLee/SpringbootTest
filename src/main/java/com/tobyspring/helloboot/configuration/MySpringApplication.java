package com.tobyspring.helloboot.configuration;

import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class MySpringApplication {
    public static void run(Class<?> hellobootApplication, String... args) {
        final AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext() {
            @Override
            protected void onRefresh() {
                super.onRefresh();

                final ServletWebServerFactory webServerFactory = getBean(ServletWebServerFactory.class);
                final DispatcherServlet dispatcherServlet = getBean(DispatcherServlet.class);

                final WebServer
                    webServer = webServerFactory.getWebServer(servletContext -> servletContext.addServlet("dispatcherServlet",
                                                                                                          dispatcherServlet)
                                                                                              .addMapping("/*"));
                webServer.start();
            }
        };

        applicationContext.register(hellobootApplication);
        applicationContext.refresh();
    }
}
