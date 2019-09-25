package com.example.myapplication.data.local;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.myapplication.model.User;

import java.util.List;

@Dao
public interface UserDAO {
    @Insert
    void insert(User user);


    @Query("Select * from User")
    List<User> getUsers();

    @Delete
    void delete(User user);


    @Update
    void update(User user);

    @Insert
    void insertAll(List<User> userList);

    @Delete
    void deleteAll(List<User> users);

    @Query("Select * from User where first_name like :name ")
    LiveData<List<User>> searchName(String name);











}
