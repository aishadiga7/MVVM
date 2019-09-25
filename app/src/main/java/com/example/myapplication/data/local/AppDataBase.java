package com.example.myapplication.data.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.myapplication.model.User;

@Database(version = 1,entities = {User.class})
public abstract class AppDataBase extends RoomDatabase {
}
