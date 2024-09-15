package com.elastic.elasticsearch.controller;

import com.elastic.elasticsearch.document.Person;
import com.elastic.elasticsearch.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/person")
public class PersonController {
    private final PersonService service;

    @Autowired
    public PersonController(PersonService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public void save(@RequestBody final Person person) {
        this.service.save(person);
    }

    @GetMapping("/{id}")
    public Person findById(@PathVariable final String id) {
        return this.service.findById(id);
    }
}