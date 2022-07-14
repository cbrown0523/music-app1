package com.christine.music.app1.repositories;

import com.christine.music.app1.models.Listener;
import com.christine.music.app1.models.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note , Long> {
    //underscore means inside of the object findAllByListener_id to get id in listener object
    List<Note> findAllByListener_id(Long id);
}
