package com.procode.demospringboot.service;

import com.procode.demospringboot.dao.PersonDao;
import com.procode.demospringboot.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class PersonService {

    private final PersonDao persondao;

    @Autowired
    public PersonService(@Qualifier("postgres") PersonDao personDao){
        this.persondao = personDao;
    }

    public int addPerson(Person person) {
        return persondao.insertPerson(person);
    }

    public List<Person> getAllPeople() {
        return persondao.selectAllPeople();
    }

    public Optional<Person> getPersonById(UUID id) {
        return persondao.selectPersonById(id);
    }

    public int deletePerson(UUID id) {
        return persondao.deletePersonById(id);
    }

    public int upodatePerson(UUID id, Person newPerson) {
        return persondao.updatePersonById(id, newPerson);
    }


}
