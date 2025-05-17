package com.example.ToDoA.controller;

import com.example.ToDoA.models.Group;
import com.example.ToDoA.models.Item;
import com.example.ToDoA.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/groups/{groupId}/items")//изменил из items на groups так как items стоит на groups
public class ItemController {
    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }
    //Обычние CRUD методы
    @GetMapping
    public List<Item> getAllItems(){
        return itemService.findAllItems();
    }
    // я думаю он не нужен
    @GetMapping("/items/{id}")
    public Optional<Item> getByIdItem(@PathVariable int id){
        return itemService.findByIdItem(id);
    }
    //метод для создания итемов с группы
    @PostMapping
    public Item createItem(@RequestBody Item item, @PathVariable int groupId){
        return itemService.createItemInGroup(item,groupId);
    }
    @PutMapping("/{id}")
    public Item updateItem(@PathVariable int id,@RequestBody Item item){
        return itemService.updateItem(id,item);
    }
    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable int id){
       itemService.deleteItem(id);
    }
    // получение итемов по группе
    @GetMapping
    public List<Item> getItemsByGroup(@PathVariable int groupId){
        Group group = new Group();
        group.setId(groupId);
        return itemService.findItemsByGroup(group);
    }
}
