package com.example.chatdemo.controller;

import com.example.chatdemo.dto.UserMessage;
import com.example.chatdemo.model.Message;
import com.example.chatdemo.model.User;
import com.example.chatdemo.repository.MessageRepository;
import com.example.chatdemo.repository.UserRepository;
import com.example.chatdemo.service.MessageService;
import com.example.chatdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
public class ChatLogController {


    @Autowired
    MessageService messageService;

    @Autowired
    UserService userService;

    @GetMapping("/")
    public String homePage(){
        return "Hi Home";
    }


    @PostMapping(value ="/addChatLog/{user}")
    public ResponseEntity addChatLog(@PathVariable("user") String userName,
                                      @RequestBody UserMessage message){

        User user = new User(userName);
        User userEntity = userService.saveUser(user);

        long userId = userEntity.getUserId();

        System.out.println("Created user with id: "+userId);

        Message userMsg= new Message(user,message.getMessage());

        Message messageEntity = messageService.saveMessage(userMsg);

        return new ResponseEntity(messageEntity.getId(),HttpStatus.OK);
    }


    @PostMapping(value="/chatlogs/{user}")
    public ResponseEntity getChatLogUser(@PathVariable("user") String userName,
                                         @RequestParam(name="limit",required = false)Integer limit,
                                         @RequestParam(name="start",required = false) Integer start){

        List<String> userMessages = new ArrayList<>();

        User user = userService.findUserByName(userName);
        System.out.println("user id for user "+userName+" is "+user.getUserId());

        System.out.println("User name is " + userName);
        System.out.println("Limit is " + limit);
        System.out.println("Start is " + start);
//
//        if(start == null && limit != null){
//            Pageable pageable = PageRequest.of(0,limit, Sort.by(Sort.Direction.DESC,"timestamp"));
//            Page<Message> messages =  messageService.findMessagesWithPaginationForUser(user,pageable);
//            System.out.println("Got "+messages.getSize()+" page size");
//            return new ResponseEntity<>(messages,HttpStatus.OK);
//        }
//        else if( start != null && limit != null){
//            return new ResponseEntity(HttpStatus.OK);
//        }

        Set<Message> messageList = messageService.findByUser(user);

        for (Message msg : messageList) {
            userMessages.add(msg.getMessage());
        }
        System.out.println("Message list is " + userMessages);

        return new ResponseEntity(userMessages, HttpStatus.OK);

    }

    @DeleteMapping(value="/chatlogs/{user}")
    public ResponseEntity deleteUser(@PathVariable("user") String userName){

        System.out.println("Deleting user=> "+userName);
        User user = userService.findUserByName(userName);

        userService.deleteUser(user);
        return new ResponseEntity(HttpStatus.OK);
    }


    @DeleteMapping(value="/chatlogs/{user}/{messageId}")
    public ResponseEntity deleteUserAndMessage(@PathVariable("user") String userName,
                                               @PathVariable("messageId") Long messageId){
        System.out.println("Deleting user=> "+userName+" and message =>"+messageId);

        User user = userService.findUserByName(userName);
        Message userMsg = messageService.findMessageForUserAndMessage(user,messageId);

        messageService.deleteMessage(userMsg);
        return new ResponseEntity(HttpStatus.OK);
    }

}
