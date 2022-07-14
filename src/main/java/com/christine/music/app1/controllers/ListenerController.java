package com.christine.music.app1.controllers;

import com.christine.music.app1.models.Listener;
import com.christine.music.app1.repositories.ListenerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@CrossOrigin
//listening for requests
@RestController
//set a default url path
@RequestMapping("/api/listener")
public class ListenerController {

    @Autowired
    ListenerRepository repository;

    @GetMapping("/test")
    public ResponseEntity<String> testRoute(){
        return new ResponseEntity<String>("Hello", HttpStatus.OK);
    }
    @PostMapping("/")
    public ResponseEntity<Listener>createListener(@RequestBody Listener newListener){
        //listener will create a new id number
        Listener listener = repository.save(newListener);
        return new ResponseEntity<>(listener , HttpStatus.CREATED);
    }
    @GetMapping("/")
    public ResponseEntity<List<Listener>>getAllListeners(){
        List<Listener> listeners = repository.findAll();
        return new ResponseEntity<>(listeners, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Listener>>getListenerById(@PathVariable Long id){
        Optional<Listener> listener = repository.findById(id);
        if(listener.isEmpty()){
            return new ResponseEntity("Not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(listener , HttpStatus.FOUND);
//        or
//       Listener listener = repository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));


    }
}
