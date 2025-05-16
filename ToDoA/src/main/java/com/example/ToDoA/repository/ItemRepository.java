package com.example.ToDoA.repository;

import com.example.ToDoA.models.Group;
import com.example.ToDoA.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
    //этот метод достает итемы по группе
    List<Item> findByGroup (Group group);
}
