package com.example.demo;

import com.example.demo.model.CatPost;
import com.example.demo.model.CatUser;
import com.example.demo.storage.catpost.InMemoryPostStorage;
import com.example.demo.storage.catuser.InMemoryUserStorage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

import java.util.List;

@SpringBootApplication
//@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class CatsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatsApplication.class, args);
	}
}
