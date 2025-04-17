package com.example.ToDoA.controller;

import com.example.ToDoA.exceptions.GroupNotFoundException;
import com.example.ToDoA.models.Group;
import com.example.ToDoA.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/groups")
public class GroupController {

    private final GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping
    public List<Group> getAllGroups(){
        return groupService.findAllGroups();
    }

    @GetMapping("/{id}")
    public Group getByIdGroup(@PathVariable int id){
        return groupService.findByIdGroup(id);
    }
    @ExceptionHandler(GroupNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handleGroupNotFound(GroupNotFoundException ex){
        return Map.of("massage", ex.getMessage());
    }

    @PostMapping
    public Group createGroup(@RequestBody Group group){
        return groupService.createGroup(group.getTitle());
    }

    @PutMapping("/{id}")
    public Group updateGroup(@PathVariable int id, @RequestBody Group group){
        return groupService.updateGroup(id, group);
    }

    @DeleteMapping("/{id}")
    public void deleteGroup(@PathVariable int id){
        groupService.deleteGroup(id);
    }
}
