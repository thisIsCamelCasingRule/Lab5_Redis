package com.example.redis;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class managementService {

    private final userRepo repos;


    @Autowired
    public managementService(userRepo r) {

        this.repos = r;
    }

    public User addUser(User user){
            //User user = new User(userid, name,surname,userInstagramName,password, folowersAmount, folowingsAmount);
            repos.save(user);
            return user;
    }



    public List<User> allUser(){
        return (List<User>) repos.findAll();
    }

    public String getUserInstagramId(String username){
        User u = repos.getUserByUserInstagramName(username);
        return u.getUserid();
    }

    public User getUserByName(String username){
        User u = repos.getUserByUserInstagramName(username);
        return u;
    }


    public List<User> getActiveUsers(){
        return (List<User>) repos.findAllActiveUsers();
    }


    public String login(String name, String password){
        User u = getUserByName(name);
        //System.out.println(u);
        if(u != null){
            if(u.getUserPassword().contentEquals(password)){
                return "Logined succesfuly!";
            }
            else{
                return "Incorrect username or passwod!";
            }
        }
        else{
            return "Incorrect username or passwod!";
        }
    }

    public String updateUser(String name, String password, String confirmPassword){
        User u = getUserByName(name);
        if(u != null && password != u.getUserPassword()){
            if(password.contentEquals(confirmPassword)){
                u.setUserPassword(password);
                repos.save(u);
                return "Changes commited!";
            }
            else {
                System.out.println("------------------");
                return "Check if your passwords are right";
            }
        }
        else{
            return "Check if your passwords are right";
        }
    }
}
