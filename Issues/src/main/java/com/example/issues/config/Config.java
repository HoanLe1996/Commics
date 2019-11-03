package com.example.issues.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

@Configuration
@EnableWebMvc
public class Config implements  WebMvcConfigurer {

		// Tạo view
		@Bean
	    @Description("Thymeleaf template resolver serving HTML 5")
	    public ClassLoaderTemplateResolver templateResolver() {

			ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver(); // Load template trong đường dẫn lớp

	        templateResolver.setPrefix("templates/issues/"); // đặt thư mục trong templates nên ko cần có tiền tố "/"
	        templateResolver.setCacheable(false);
	        templateResolver.setSuffix(".html"); // file trong view-templates
	        templateResolver.setTemplateMode("HTML5"); // định dạng templates theo cấu trúc HTML5
	        templateResolver.setCharacterEncoding("UTF-8"); // Sét UTF-8

	        return templateResolver;
	    }
		
		// Tạo static resource
		
		 @Override
		   public void addResourceHandlers(ResourceHandlerRegistry registry) {
		    
		       // Css resource.
		       registry.addResourceHandler("/styles/**") //
		                 .addResourceLocations("/static/css/").setCachePeriod(31556926);
		        
		   }
		 
		    
		   @Override
		   public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		       configurer.enable();
		   }
	/*
	 * @Bean
	 * 
	 * @Description("Thymeleaf template engine with Spring integration") public
	 * SpringTemplateEngine templateEngine() {
	 * 
	 * SpringTemplateEngine templateEngine = new SpringTemplateEngine();
	 * templateEngine.setTemplateResolver(templateResolver());
	 * 
	 * return templateEngine; }
	 * 
	 * @Bean
	 * 
	 * @Description("Thymeleaf view resolver") public ViewResolver viewResolver() {
	 * 
	 * ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
	 * 
	 * viewResolver.setTemplateEngine(templateEngine());
	 * viewResolver.setCharacterEncoding("UTF-8");
	 * 
	 * return viewResolver; }
	 */

	/*
	 * @Override public void addViewControllers(ViewControllerRegistry registry) {
	 * registry.addViewController("/").setViewName("issuereport_form"); }
	 */
}
