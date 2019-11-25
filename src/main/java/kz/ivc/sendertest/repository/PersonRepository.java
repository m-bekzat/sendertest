package kz.ivc.sendertest.repository;

import kz.ivc.sendertest.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonRepository {

    public Person getPerson(int id) {
        List<Person> people = new ArrayList<>();

        Person person = new Person();
        person.setId(1);
        person.setAge(25);
        person.setName("Bekzat");
        person.setSurname("Minazhatov");
        person.setGender("male");

        Person person2 = new Person();
        person2.setId(2);
        person2.setAge(26);
        person2.setName("Zharkyn");
        person2.setSurname("Karakozhin");
        person2.setGender("male");

        Person person3 = new Person();
        person3.setId(3);
        person3.setAge(27);
        person3.setName("Azamat");
        person3.setSurname("Aitken");
        person3.setGender("male");

        people.add(person);
        people.add(person2);
        people.add(person3);

        return people.get(id - 1);
    }
}
