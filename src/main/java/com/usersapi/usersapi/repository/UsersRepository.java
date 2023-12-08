package com.usersapi.usersapi.repository;

import com.usersapi.usersapi.Models.User;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.Timestamp;

@Repository
public interface UsersRepository extends CrudRepository<User, Integer> {
    @Modifying
    @Query(value = "INSERT INTO USERS (ID, NAME, AGE, CREATED_DATE, CREATED_AT, email) VALUES(:ID,:NAME,:AGE, :CREATEDDATE, :CREATED_AT, :email)")
    void saveUser(@Param("ID")int id, @Param("NAME") String NAME, @Param("AGE") int age, @Param("CREATEDDATE") Date createdDate, @Param("CREATED_AT") Timestamp timestamp, @Param("email") String email);

}
