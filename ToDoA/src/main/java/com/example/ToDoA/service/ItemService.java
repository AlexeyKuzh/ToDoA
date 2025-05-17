package com.example.ToDoA.service;

import com.example.ToDoA.exceptions.GroupNotFoundException;
import com.example.ToDoA.models.Group;
import com.example.ToDoA.models.Item;
import com.example.ToDoA.repository.GroupRepository;
import com.example.ToDoA.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ItemService {
    private final GroupRepository groupRepository;
    private final ItemRepository itemRepository;
    @Autowired
    public ItemService(GroupRepository groupRepository, ItemRepository itemRepository) {
        this.groupRepository = groupRepository;
        this.itemRepository = itemRepository;
    }

    public List<Item> findAllItems(){
        return itemRepository.findAll();
    }
    public Optional<Item> findByIdItem(int id){
        return itemRepository.findById(id);
    }
    //Метод для создания итемс в группе,(я сделал замену обичного метода)
    public Item createItemInGroup(Item item, int groupId){
        // 1. Ищем группу, чтобы привязать к ней Item
        Group group = groupRepository.findById(groupId)
                .orElseThrow(() -> new GroupNotFoundException("Group not found"));
        // 2. Устанавливаем связь item → group
        item.setGroup(group);
        // 3. Устанавливаем дату создания
        item.setCreated_at(LocalDateTime.now());
        // 4. Сохраняем
        return itemRepository.save(item);
    }

    public Item updateItem(int id, Item newItemUpdate){
        Optional<Item> optionalItem = itemRepository.findById(id);
        if(optionalItem.isPresent()){
            Item existingitem = optionalItem.get();
            existingitem.setTitle(newItemUpdate.getTitle());
            return itemRepository.save(existingitem);
        }else {
            return null;
        }
    }

    public void deleteItem(int id){
        itemRepository.deleteById(id);
    }
    //этот метод достает итемы по группе
    public List<Item>findItemsByGroup(Group group){
        return itemRepository.findByGroup(group);
    }
}
