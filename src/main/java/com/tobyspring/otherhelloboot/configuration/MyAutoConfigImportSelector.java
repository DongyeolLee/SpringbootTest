package com.tobyspring.otherhelloboot.configuration;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyAutoConfigImportSelector implements DeferredImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[] {
            "com.tobyspring.otherhelloboot.configuration.autoconfig.DispatcherServletConfig",
            "com.tobyspring.otherhelloboot.configuration.autoconfig.TomcatWebServerConfig"
        };
    }
}
