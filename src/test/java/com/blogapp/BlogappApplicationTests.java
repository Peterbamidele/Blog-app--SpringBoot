package com.blogapp;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

import static org.assertj.core.api.Assertions.*;


@SpringBootTest
@Slf4j
class BlogappApplicationTests {
    @Autowired
    DataSource dataSource;

   @Test
    void testIfApplicationDataBaseIsConnectedTest(){
       assertThat(dataSource).isNotNull();
       log.info("Database object is created");

       try (Connection connection = dataSource.getConnection()){
           assertThat(connection).isNotNull();
           assertThat(connection.getCatalog()).isEqualTo("blogdb");
           log.info("Connected db --> {}", connection.getCatalog());


       }catch (SQLException throwables){
           log.info("Connection occur while connecting to database --> {}", throwables.getMessage());

       }

   }
//   @Test
//    void contextLoads(){
//
//   }

}
