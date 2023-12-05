package com.example.getting_started;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class Controller {

   ArrayList<Message> messageList = new ArrayList<>();

   @DeleteMapping("/messages/{id}")
   public List<Message> deleteFromList(@PathVariable String id) {

       for (Message m : messageList) {
           if (m.id().equals(id)) {
               messageList.remove(m);
               return messageList;
           }
       }
       throw new RuntimeException("Message with id " + id + "not found!");
   }

   @GetMapping("/messages")
   public List<Message> printList() {
       return messageList;
   }

   @PostMapping("/messages")
   public Message addList(@RequestBody Message message) {
       messageList.add(message);
       return message;
   }

    @GetMapping("/hello")
    public String helloWolrd() {
        return "Hello world";
    }

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name) {
        return "Hello, " + name + "!";
    }
}
