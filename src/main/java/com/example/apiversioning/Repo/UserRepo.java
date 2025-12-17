package com.example.apiversioning.Repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.apiversioning.models.User;

import jakarta.annotation.PostConstruct;
@Repository
public class UserRepo {
            private final List<User>users=new ArrayList<>();

            public List<User>findAll(){
                return users;
            }

            public User findById(Integer id){
                return users.stream().filter( u->u.id().equals(id)).findFirst().orElse(null);
            }

            @PostConstruct
            public void init(){
                users.add(new User(1, "kaung htet", "zawk@gmail.com","www.kaunghtet.com"));
            }
    
}
