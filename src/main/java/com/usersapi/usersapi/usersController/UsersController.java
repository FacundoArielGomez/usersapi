package com.usersapi.usersapi.usersController;

import com.usersapi.usersapi.Models.User;
import com.usersapi.usersapi.service.UsersService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.io.FileNotFoundException;
import java.util.*;

@RestController
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/users")
    public HashMap<String, List<User>> getAllUsers(){
        return usersService.getAllUsers();
    }

    @GetMapping("users/{id}")
    public ResponseEntity<HashMap<String, User>> getUser(@PathVariable Integer id){
        HashMap<String, User> user = usersService.getUser(id);
        if(user == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable Integer id){
        return usersService.removeUser(id);
    }

    @PostMapping("/users")
    public ResponseEntity<String> addUser(@RequestBody @Valid User user){
        Random random = new Random();
        usersService.addUser(random.nextInt(1,500),user.getName(),user.getAge(), user.getEmail());
        return new ResponseEntity<>("User has been created", HttpStatus.CREATED);
    }

    @PutMapping("users/{id}")
    public ResponseEntity<String> updateUser(@RequestBody User user, @PathVariable Integer id){
        return usersService.updateOldUser(id, user);
    }

}