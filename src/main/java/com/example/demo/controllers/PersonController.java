package com.example.demo.controllers;

import com.example.demo.contracts.ContactDto;
import com.example.demo.contracts.PersonDto;
import com.example.demo.services.PersonSerivce;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v1/person")
@RequiredArgsConstructor
public class PersonController {
    private final PersonSerivce personSerivce;

    @GetMapping
    public List<PersonDto> getAll(){
        return personSerivce.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody PersonDto personDto){
        personSerivce.save(personDto);
    }

    @GetMapping("/{id}")
    public PersonDto getById(@PathVariable Integer id){
        PersonDto personDto = personSerivce.getById(id);
        if (personDto.equals(null)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return personDto;
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestBody PersonDto personDto){
        PersonDto personDtoo = personSerivce.getById(id);
        if (personDtoo.equals(null)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        personSerivce.update(id, personDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        PersonDto personDtoo = personSerivce.getById(id);
        if (personDtoo.equals(null)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        personSerivce.delete(id);

    }

    @GetMapping("/{id}/contact")
    public ContactDto getContact(@PathVariable Integer id){
        PersonDto personDtoo = personSerivce.getById(id);
        if (personDtoo.equals(null)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return personSerivce.getContact(id);
    }

    @PostMapping("/{id}/contact")
    public void addContact(@PathVariable Integer id, @RequestBody ContactDto contactDto){
        PersonDto personDtoo = personSerivce.getById(id);
        if (personDtoo.equals(null)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        personSerivce.addContact(id, contactDto);

    }

}
