package com.poscodx.mysite.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.thymeleaf.spring5.ISpringTemplateEngine;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

import com.poscodx.mysite.event.ApplicationContextEventListener;
import com.poscodx.mysite.interceptor.SiteInterceptor;

@SpringBootConfiguration
public class MvcConfig implements WebMvcConfigurer {
	// Locale Resolver
	@Bean
	public LocaleResolver localeResolver() {
		CookieLocaleResolver localeResolver = new CookieLocaleResolver();
		localeResolver.setCookieName("lang");
		localeResolver.setCookieHttpOnly(false);
		
		return localeResolver;
	}
	
	// Site Interceptor
	@Bean
	public HandlerInterceptor siteInterceptor() {
		return new SiteInterceptor();
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry
			.addInterceptor(siteInterceptor())
			.addPathPatterns("/**")
			.excludePathPatterns("/assets/**");
	}

	// ApplicationContext Event Listener
	@Bean
	public ApplicationContextEventListener applicationContextEventListener() {
		return new ApplicationContextEventListener();
	}
}
