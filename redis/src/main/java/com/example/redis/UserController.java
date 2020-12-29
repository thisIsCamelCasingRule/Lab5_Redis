package com.example.redis;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/instamanagement")
public class UserController {
    @Autowired
    private managementService service;

    @Autowired
    private userRepo repos;


    @GetMapping(path="/getmodels")
    public List<User> getAllUserModel()
    {
        return service.allUser();
    }

    @PostMapping("/add")
    public User add(@RequestParam String name,
                    @RequestParam String surname,
                    @RequestParam String userInstagramName,
                    @RequestParam String userPassword){
        User user= new User("7233451", name,surname,userInstagramName,userPassword,222,22);
        repos.save(user);
        return service.addUser(user);

    }

}
