package com.digix.desafio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class StarterApplication {

    private static ApplicationContext context;

    public static void main(String[] args) {

        context = SpringApplication.run(StarterApplication.class, args);

        //SpringApplication.run(StarterApplication.class, args);
    }

    // pegando contexto da aplicacao
    public static ApplicationContext getContext() {
        return context;
    }

}
