package kz.ivc.sendertest.jms;

import org.apache.activemq.Message;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;

import javax.jms.JMSException;

public class Receiver {
    @Autowired
    Logger logger;

    @JmsListener(destination = "kz.ivc.jms.test")
    private void testReceiver(Message message) {

        try {
            int id = message.getIntProperty("id");
            int age = message.getIntProperty("age");
            String name = message.getStringProperty("name");
            String surname = message.getStringProperty("surname");
            String gender = message.getStringProperty("gender");

            System.err.println("JMS message: " + id + " " + age + " " + name + " " + surname + " " + gender);
        } catch (JMSException e) {
            logger.error("class: Receiver; method: testReceiver; exception:JMSException " + e);
        }
    }
}
