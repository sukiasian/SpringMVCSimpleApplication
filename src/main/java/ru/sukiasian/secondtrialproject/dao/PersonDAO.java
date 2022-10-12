package ru.sukiasian.secondtrialproject.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.sukiasian.secondtrialproject.models.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@Component // чтобы можно было делать autowired
public class PersonDAO {
    private static int PEOPLE_COUNT;

    private List<Person> people;
    private JdbcTemplate jdbcTemplate;

    // == initialization block
    {
        people = new ArrayList<>();

        people.add(new Person( ++PEOPLE_COUNT, "Tom", 23, "a@g.ru"));
        people.add(new Person( ++PEOPLE_COUNT, "Alex", 24, "b@g.ru"));
        people.add(new Person( ++PEOPLE_COUNT, "Max", 27, "c@g.ru"));
        people.add(new Person( ++PEOPLE_COUNT, "John", 19, "d@g.ru"));
    }


    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> index() {
         return jdbcTemplate.query("SELECT * FROM Person", new PersonMapper());
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }
}
