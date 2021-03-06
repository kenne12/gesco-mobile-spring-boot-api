package com.bein.gescoapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@SpringBootApplication
public class GescoApiApplication implements CommandLineRunner {


    public static void main(String[] args) {
        SpringApplication.run(GescoApiApplication.class, args);
    }

    /*@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }*/

    @Bean
    public NoOpPasswordEncoder passwordEncoder2() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
