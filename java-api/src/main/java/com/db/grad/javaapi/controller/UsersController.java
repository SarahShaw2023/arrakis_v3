package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.model.User;
import com.db.grad.javaapi.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins= "http://localhost:3000") //"http://localhost:8080"
@CrossOrigin
public class UsersController {
    @Autowired
    UsersService usersService;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return usersService.getAllUsers();
    }

    @PostMapping("/createAcc")
    public boolean createAccount(@RequestParam("email") String email,
                                 @RequestParam("username") String username,
                                 @RequestParam("password") String password,
                                 @RequestParam("role") String role) {
        //Ensure all valid values in params
        if(email == null || username == null || password == null || role == null) {
            return false;
        }
        //Check if no other account was made under their email
        List<User> users = usersService.findUserByEmail(email);

        //Only make a new account if the email is not already in use
        if(users == null || users.size() == 0) {
            User u = new User(username, password, email, role);
            usersService.addNewUser(u);

            //Verify it was added
            users = usersService.findUserByEmail(email);
            if(users != null && users.size() == 1) {
                return true;
            }
        }

        //Account could not be created
        return false;
    }
    @PutMapping("/updateUser")
    public int updateUser(@RequestParam("email") String email,
                         @RequestParam("username") String username,
                         @RequestParam("password") String password) {
        int id = usersService.findUserId(email, username);
        boolean isUpdated = false;

        //Only update the account of a matching email AND username
        if(id > 0) {
            isUpdated = usersService.updateUserPwd(password, id);
        }

        //Successful update: return id
        //Invalid input: 0 or -1
        //Failed update (w/ valid id > 0): -2
        return (isUpdated || (id <= 0))? id : -2;
    }


}
