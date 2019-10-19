package com.procode.demospringboot.service;

import com.procode.demospringboot.dao.PersonDao;
import com.procode.demospringboot.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PersonService {

    private final PersonDao persondao;

    @Autowired
    public PersonService(@Qualifier("fakeDao") PersonDao personDao){
        this.persondao = personDao;
    }

    public int addPerson(Person person) {
        return persondao.insertPerson(person);
    }

    public List<Person> getAllPeople() {
        return persondao.selectAllPeople();
    }

}
