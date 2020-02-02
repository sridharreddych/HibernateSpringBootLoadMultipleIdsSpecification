package com.bookstore;

import com.bookstore.service.BookstoreService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainApplication {

    private final BookstoreService bookstoreService;

    public MainApplication(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {

            System.out.println("\nFetching multiple ids (findAllById()):");
            bookstoreService.fetchByMultipleIdsFindAllById();
            
            System.out.println("\nFetching multiple ids (JPQL):");
            bookstoreService.fetchByMultipleIdsJpql();
            
            System.out.println("\nFetching multiple ids (Specification):");
            bookstoreService.fetchByMultipleIdsSpec();
        };
    }
}
/*
 * 
 * 
 * 
 * 
 * How To Load Multiple Entities By Id Via Specification

Description: This is a SpringBoot application that loads multiple entities by id via a @Query based on the IN operator and via Specification.

Key points:

for using the IN operator in a @Query simply add the query in the proper repository
for using a Specification rely on javax.persistence.criteria.Root.in()

 * 
 */
