package com.example.ToDoA.service;

import com.example.ToDoA.models.Group;
import com.example.ToDoA.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class GroupService {

    private final GroupRepository groupRepository;
    @Autowired
    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public List<Group> findAllGroups(){
        return groupRepository.findAll();
    }

    public Group findByIdGroup(int id){
        Group by = groupRepository.findBy(id);
        return by;
    }
}
