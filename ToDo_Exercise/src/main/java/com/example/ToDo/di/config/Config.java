package com.example.ToDo.di.config;

import java.util.Date;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.example.ToDo.di.IToDo;
import com.example.ToDo.di.Todo;

@Configuration
@ComponentScan(basePackages = "com.example.ToDo.di")
public class Config {

	/*
	 * @Bean // Bắn ra lỗi NoUniqueBeanDefinitionException
	 * 
	 * @Primary public IToDo getToDo() { // Lỗi khi tạo bean TODO bởi sự mơ hồ không
	 * biết lấy bean được khai báo trong @ Bean và contructor trong lớp TODO // Cách
	 * sữa lỗi là phải thêm thuộc tính @Primary cho bean nào được chọn Todo td = new
	 * Todo(0,"Lê Văn Hoan"); td.setDone(true); td.setDueDate(new Date()); return
	 * td; }
	 */

	@Bean
	public Long getId() {
		return Long.valueOf(0);
	}

	@Bean
	public String getSummary() {
		return "Spring DI";
	}

	@Bean
	public Boolean isDone() {
		return Boolean.FALSE;
	}

	@Bean
	public Date getDueDate() {
		return new Date();
	}

}
