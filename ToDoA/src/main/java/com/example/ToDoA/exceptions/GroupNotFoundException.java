package com.example.ToDoA.exceptions;

public class GroupNotFoundException extends RuntimeException{
    public GroupNotFoundException(String message){
        super(message);
    }
}
