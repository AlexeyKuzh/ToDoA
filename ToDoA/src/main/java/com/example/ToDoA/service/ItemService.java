package com.example.ToDoA.service;

import com.example.ToDoA.models.Group;
import com.example.ToDoA.models.Item;
import com.example.ToDoA.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    private final ItemRepository itemRepository;
    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> findAllItems(){
        return itemRepository.findAll();
    }
    public Optional<Item> findByIdItem(int id){
        return itemRepository.findById(id);
    }

    public Item createItem(String title){
        Item item = new Item();
        item.setTitle(title);
        item.setCreated_at(LocalDateTime.now());
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
    //
    public Optional<Item> findByIdItemsGroup(Group group){
        return itemRepository.findById(group.getId());
    }
}
