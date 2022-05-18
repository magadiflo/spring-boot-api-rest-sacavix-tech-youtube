package com.magadiflo.todoapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodoappApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoappApplication.class, args);
	}

}
/**
 * *****************************************
 * Para ejecutar el proyecto en Intellij Idea
 * Add Configuration
 * Seleccionamos Maven
 * Y en el campo Run: (command lime) escribir
 * spring-boot:run
 * ****************************************
 * Para acceder a la versión gráfica de swagger y ver nuestra API documentada
 * http://localhost:8080/swagger-ui.html
 * *****************************************
 * Acceder a la BD H2 por el navegador
 * Acceder desde la URL:
 * http://localhost:8080/h2-console
 *
 * JDBC URL: jdbc:h2:mem:todoapp
 * username: a
 * password: a
 */