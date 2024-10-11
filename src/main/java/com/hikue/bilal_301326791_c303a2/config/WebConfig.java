package com.hikue.bilal_301326791_c303a2.config;

import jakarta.servlet.DispatcherType;
import jakarta.servlet.FilterRegistration;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.EnumSet;

/**
 * This class is responsible for configuring the encoding defacto for the application,
 * and is also responsible for configuring the default servlet handling for the application.
 */
@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurationSupport implements WebApplicationInitializer {
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }


    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        servletContext.setInitParameter("defaultHtmlEscape", "true");
        servletContext.setInitParameter("javax.servlet.jsp.jstl.fmt.localizationContext", "messages");
        EnumSet<DispatcherType> dispatcherTypes = EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD);
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        FilterRegistration.Dynamic characterEncoding = servletContext.addFilter("characterEncoding", characterEncodingFilter);
        characterEncoding.addMappingForUrlPatterns(dispatcherTypes, true, "/*");
    }

    @Bean
    public static MethodValidationPostProcessor methodValidationPostProcessor(LocalValidatorFactoryBean validator) {
        final var methodValidationPostProcessor = new MethodValidationPostProcessor();
        methodValidationPostProcessor.setValidator(validator);
        return methodValidationPostProcessor;
    }

    @Bean
    public static LocalValidatorFactoryBean validator() {
        return new LocalValidatorFactoryBean();
    }
}
