package com.ppl.postgres;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@MapperScan("com.ppl.postgres.mapper")
public class PostgresStart {

    public static void main( String[] args ) {
        SpringApplication.run(PostgresStart.class, args);
    }
}
