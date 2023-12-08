package com.usersapi.usersapi.service;

import com.usersapi.usersapi.Models.User;
import com.usersapi.usersapi.StuctureResponse.UserResponse;
import com.usersapi.usersapi.repository.UsersRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class UsersService {

    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public ResponseEntity<String> updateOldUser(Integer id, User newUser) {
        Optional<User> user = usersRepository.findById(id);
        if(user.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        user.get().setName(newUser.getName());
        user.get().setAge(newUser.getAge());
        user.get().setEmail(newUser.getEmail());
        usersRepository.save(user.get());


            return new ResponseEntity<>("User has been created", new HttpHeaders(), HttpStatus.CREATED);
    }


    public HashMap<String, List<User>> getAllUsers() {

         Iterable<User> Users = usersRepository.findAll();

        List<User> listOfUsers = new ArrayList<>();
        Users.forEach(listOfUsers::add);

        return UserResponse.formateUserResponse(listOfUsers);

    }

    public HashMap<String, User> getUser(Integer id) {
        User user = usersRepository.findById(id).orElse(null);
        if(user == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        return UserResponse.formateOneUserResponse(user);
    }

    public String removeUser(Integer id) {
        usersRepository.deleteById(id);
        return "The user had been deleted";
    }

    public void addUser(int id, String name, int age, String email) {
        LocalDate createdDate= LocalDate.now();
        Date date = Date.valueOf(createdDate);

        LocalDateTime createdAt = LocalDateTime.now();
        Timestamp timestampToDB = Timestamp.valueOf(createdAt);

        usersRepository.saveUser(id, name, age, date, timestampToDB, email);
    }


}
