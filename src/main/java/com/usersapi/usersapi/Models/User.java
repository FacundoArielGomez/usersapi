package com.usersapi.usersapi.Models;

import jakarta.validation.constraints.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Table("USERS")
public class User {

    @Id
    private Integer id;

    @NotEmpty(message = "name field must not be empty")
    @NotBlank(message ="Invalid name: Empty name")
    @NotNull(message ="Invalid name: Name is NULL")
    @Size(min = 2, max = 100, message = "Name Field must be between 2 and 100 characters")
    private String name;

    @Min(value = 18, message = "You must be greater than 18 years old")
    @Max(value= 130, message= "Wow you are so old, sorry but in this page we don't want such old people")
    private int age;

    @Past(message = "You can only introduce a past date")
    private LocalDate createdDate;

    private LocalDateTime createdAt;

    @Email(regexp = "[a-zA-Z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}", message="The email is invalid")
    private String email;
    public User(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

