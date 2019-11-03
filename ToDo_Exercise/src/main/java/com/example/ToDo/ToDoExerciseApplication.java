package com.example.ToDo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.ToDo.di.IToDo;
import com.example.ToDo.di.config.Config;

@SpringBootApplication
public class ToDoExerciseApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToDoExerciseApplication.class, args);
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        IToDo todo = (IToDo) context.getBean(IToDo.class);
        System.out.println(todo);
        context.close();

	}

}
