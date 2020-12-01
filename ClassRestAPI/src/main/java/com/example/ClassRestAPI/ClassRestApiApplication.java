package com.example.ClassRestAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/*
CRUD
Create: Post
Read: Get
Update: Put
Delete: Delete


@PostMapping
@GetMapping
@PutMapping
@DeleteMapping
 */



@SpringBootApplication
@RestController
public class ClassRestApiApplication {
	private HashMap<Integer, String> database = new HashMap<>();
	private int idCounter = 0;


	public static void main(String[] args) {
		SpringApplication.run(ClassRestApiApplication.class, args);
	}

	@PostMapping("/")
	public String postData(@RequestHeader(value = "header", defaultValue = "") String header, @RequestBody String body){
		database.put(idCounter++, body);
		System.out.println(database);
		return body;
	}

	@GetMapping("/{id}")
	public String getData(@PathVariable("id") int id){
		return database.get(id);
	}

	@DeleteMapping("/delete")
	public String deleteData(@RequestParam int id){
		return database.remove(id);
	}

	@PutMapping("/{id}")
	public String updateData(@PathVariable int id, @RequestBody String newData){
		database.put(id,newData);
		return newData;
	}

}
