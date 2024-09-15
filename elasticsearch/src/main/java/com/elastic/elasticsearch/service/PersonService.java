package com.elastic.elasticsearch.service;

import com.elastic.elasticsearch.document.Person;
import com.elastic.elasticsearch.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    private final PersonRepository repository;
    @Autowired
    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public void save(final Person person) {
        this.repository.save(person);
    }

    public Person findById(final String id) {
        return this.repository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Non person indentification"));
    }
}