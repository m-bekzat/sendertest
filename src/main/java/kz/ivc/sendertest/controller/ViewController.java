package kz.ivc.sendertest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ViewController {
    @RequestMapping(value = "/")
    public String index() {
        return "works!";
    }
}
