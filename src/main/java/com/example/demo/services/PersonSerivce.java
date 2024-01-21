package com.example.demo.services;

import com.example.demo.contracts.ContactDto;
import com.example.demo.contracts.PersonDto;
import com.example.demo.model.Contact;
import com.example.demo.model.Person;
import com.example.demo.repositories.ContactRepository;
import com.example.demo.repositories.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonSerivce {

    private final PersonRepository personRepository;
    private final ContactRepository contactRepository;

    private static ContactDto contactToDto(Contact contact){
        ContactDto contactDto = new ContactDto();
        BeanUtils.copyProperties(contact, contactDto);
        return contactDto;
    }

    private static Contact contactToEntity(ContactDto contactDto){
        Contact contact = new Contact();
        BeanUtils.copyProperties(contactDto, contact);
        return contact;
    }

    private static PersonDto personToDto(Person person){
        PersonDto personDto = new PersonDto();
        BeanUtils.copyProperties(person, personDto);
        return personDto;
    }

    private static Person personToEntity(PersonDto personDto){
        Person person =new Person();
        BeanUtils.copyProperties(personDto, person);
        return person;
    }

    public List<PersonDto> getAll(){
        List<Person> people = personRepository.findAll();
        List<PersonDto> personDtos = new ArrayList<>();
        people.stream().forEach(p -> {
            personDtos.add(personToDto(p));
        });

        return personDtos;

       // return personRepository.findAll()
       //         .stream()
       //         .map(PersonSerivce::personToDto)
        //        .toList();
    }

    public PersonDto getById(Integer id){
        Person person = personRepository.findById(id).get();
        PersonDto personDto = personToDto(person);
        return personDto;


        //return personRepository.findById(id).stream().findFirst().map(PersonSerivce::personToDto).get();
    }

    public void save(PersonDto personDto){
        personRepository.save(personToEntity(personDto));
    }

    public void update(Integer id, PersonDto personDto){
        Person person = personRepository.findById(id).stream().findFirst().get();

        BeanUtils.copyProperties(personDto, person);

        personRepository.save(person);
    }

    public void delete(Integer id){
        personRepository.deleteById(id);
    }

    public void addContact(Integer personId, ContactDto contactDto){
        Person person = personRepository.findById(personId).get();
        Contact contact = contactToEntity(contactDto);

        contactRepository.save(contact);

        person.setContact(contact);

        personRepository.save(person);

    }


    public ContactDto getContact(Integer personId){
        Person person = personRepository.findById(personId).get();

        return contactToDto(person.getContact());

    }




}
