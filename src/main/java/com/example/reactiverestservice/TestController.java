package com.example.reactiverestservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class TestController {

  private final PersonService personService;

  public TestController(PersonService personService) {
    this.personService = personService;
  }

  @GetMapping("/test")
  public Mono<Person> test(@RequestParam("name") String name) {
    var person = new Person();
    person.setName(name);
    return personService.save(person);
  }
}
