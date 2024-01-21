package com.example.demo.updaters;

import com.example.demo.model.Contact;
import com.example.demo.model.Person;
import com.example.demo.repositories.ContactRepository;
import com.example.demo.repositories.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonUpdater {

    private final IRandomDataClient dataClient;
    private final PersonRepository personRepository;
    private final ContactRepository contactRepository;

    public void updatePeople(int size){
        List<RandomPersonDto> randomPersonDtoList = dataClient.getRandomPeople(size);

        List<Person> people = new ArrayList<>();
        List<Contact> contacts = new ArrayList<>();


        randomPersonDtoList.stream().forEach(r -> {
            Person person = new Person();
            person.setFirstName(r.getFirstName());
            person.setLastName(r.getLastName());

            Contact contact = new Contact();
            contact.setEmail(r.getEmail());
            contact.setPhoneNumber(r.getPhoneNumber());

            person.setContact(contact);

            contactRepository.save(contact);

            personRepository.save(person);

        });


    }

}
