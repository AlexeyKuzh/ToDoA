package com.example.ToDoA.controller;

import com.example.ToDoA.service.ItemService;
import org.springframework.stereotype.Controller;

@Controller
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

}
