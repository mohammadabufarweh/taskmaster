package com.example.taskmaster;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
@Dao
public interface TaskDao {
    @Query("SELECT * FROM task")
    List<Task> getAll();
//    @Query("SELECT * FROM task WHERE tid IN (:taskIds)")
//    List<Task> loadAllByIds(int[] taskIds);
//    @Query("SELECT * FROM task WHERE title LIKE :title AND " +
//            "body LIKE :body AND "+"state LIKE :state ")
//    Task findByName(String title, String body ,String state);

    @Insert
    void insertAll(Task... tasks);
    @Delete
    void delete(Task task);



}
