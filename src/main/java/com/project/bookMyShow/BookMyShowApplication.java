package com.project.bookMyShow;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import com.project.bookMyShow.model.User;
import com.project.bookMyShow.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookMyShowApplication {
	@Autowired
	private UserRepository repository;

	// @PostConstruct
	// public void initUsers() {
	// List<User> users = Stream
	// .of(new User(101, "javatechie",
	// "$2y$12$6s04dzrRp09qbRXgavnlu.o1XeBxMJH5Hvi2XEcm3G5tUcklS0Fn6",
	// "javatechie@gmail.com"), new User(102, "user1", "pwd1", "user1@gmail.com"),
	// new User(103, "user2", "pwd2", "user2@gmail.com"),
	// new User(104, "user3", "pwd3", "user3@gmail.com"))
	// .collect(Collectors.toList());
	// repository.saveAll(users);
	// }

	public static void main(String[] args) {
		SpringApplication.run(BookMyShowApplication.class, args);
	}

}
