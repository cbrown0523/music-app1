package com.christine.music.app1.repositories;

import com.christine.music.app1.models.Listener;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ListenerRepository extends JpaRepository<Listener, Long> {

    //custom method that jpa will autogenerate a sequel query
    List<Listener> findAllByAge(Integer age);
    //running sql queries
    //@Query("SELECT * FROM listener WHERE name LIKE '%?1%'")
}
