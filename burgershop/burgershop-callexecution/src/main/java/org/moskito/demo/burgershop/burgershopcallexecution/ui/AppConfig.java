package org.moskito.demo.burgershop.burgershopcallexecution.ui;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * TODO comment this class
 *
 * @author lrosenberg
 * @since 16.11.13 22:19
 */
@Configuration
public class AppConfig {
	@Bean
	ViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
}
