//https://serpapi.com/search.json?engine=google&q=clip art apple&tbm=isch&api_key=a77b7364c5a8c2d239d919857f137f31c02b32f6652f34b54ee2f80f5ac5d28c
package com.christine.music.app1.controllers;

import com.christine.music.app1.models.Listener;
import com.christine.music.app1.models.Note;
import com.christine.music.app1.repositories.ListenerRepository;
import com.christine.music.app1.repositories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/notes")
public class NoteController {
    @Autowired
    private NoteRepository repository;
    @Autowired
    private ListenerRepository lrepository;

    @GetMapping("/test")
    public ResponseEntity<?>testRoute(){
        return new ResponseEntity<>("testing 123" , HttpStatus.OK);
    }
    @PostMapping("/{id}")
    public ResponseEntity<?>createNote(@PathVariable Long id, @RequestBody Note newNote)  {
        Listener listener = lrepository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
        newNote.setListener(listener);
        Note note = repository.save(newNote);
        return new ResponseEntity<>(note , HttpStatus.CREATED);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Note>>getAllNotes(){
        List<Note> notes = repository.findAll();
        return new ResponseEntity<>(notes , HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Note>>getNoteById(@PathVariable Long id){
        Optional<Note> note = repository.findById(id);
        if(note.isEmpty()){
            return new ResponseEntity("Not Found" , HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(note , HttpStatus.FOUND);

    }
    @GetMapping("/listener/{listenerId}")
    public ResponseEntity< List<Note>>getNoteByListenerId(@PathVariable Long listenerId){
        List<Note> note = repository.findAllByListener_id(listenerId);
        return new ResponseEntity<>(note , HttpStatus.OK);

    }
}
