package com.example.ToDoA.service;

import com.example.ToDoA.models.Group;
import com.example.ToDoA.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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

    public Optional<Group> findByIdGroup(int id){
        return groupRepository.findById(id);
    }

    public Group createGroup(String title){
        Group group = new Group();
        group.setTitle(title);
        group.setCreated_at(LocalDateTime.now());
        return groupRepository.save(group);
    }

    public Group updateGroup(int id, Group newGroupUpdate){
        Optional<Group> optionalGroup = groupRepository.findById(id);//Сначала надо найти по айди
        if(optionalGroup.isPresent()){//убидиться что существует
            Group existingGroup = optionalGroup.get();
            existingGroup.setTitle(newGroupUpdate.getTitle());
            return groupRepository.save(existingGroup);
        }else{
            return null;
        }
    }

    public void deleteGroup(int id){
        groupRepository.deleteById(id);
    }
}
