package com.study.room.Dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.study.room.model.User;

import java.util.List;

@Dao
public interface UserDao {

    @Query("SELECT * FROM Users")
    List<User> getUsers();

    @Insert
    void insertAll(User... users);

    @Delete
    void delete(User user);

    @Query("DELETE FROM Users")
    void deleteAll();

}
