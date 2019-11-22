package kz.ivc.sendertest.controller;

import kz.ivc.sendertest.jms.Sender;
import kz.ivc.sendertest.model.Person;
import kz.ivc.sendertest.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Message;

@RestController
@RequestMapping("/test")
public class JmsTestController {

    private final Sender sender;
    private final PersonRepository personRepository;

    @Autowired
    public JmsTestController(Sender sender, PersonRepository personRepository) {
        this.sender = sender;
        this.personRepository = personRepository;
    }

    @GetMapping("/sendMessage/{id}")
    public void sender(@PathVariable(name = "id") int id){

        sender.send("kz.ivc.jms.test", session -> {

            Person person = personRepository.getPerson(id);

            Message message = session.createMessage();
            message.setIntProperty("id", person.getId());
            message.setIntProperty("age", person.getAge());
            message.setStringProperty("name", person.getName());
            message.setStringProperty("surname", person.getSurname());
            message.setStringProperty("gender", person.getGender());
            return message;
        });
    }
}
