package com.example.demo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class PollAppApplication {
	public static void main(String[] args) {
		SpringApplication.run(PollAppApplication.class, args);
	}
}

/*
Step 2: Domain Model

Implement the first draft of the PollApp domain model,
shown in the diagram above, in Java. For the time being,
the domain classes can be simple Java Beans, i.e. classes with
little internal logic, public getters- and setters for all properties,
as well as a parameterless public constructor. Moreover, you should create
a PollManager-class, which will manage all domain objects in memory,
e.g. by holding Polls and Users in a HashMap. The DomainManager
should be annotated with the @Component annotation, which will allow
to inject it into the controller classes.

*/