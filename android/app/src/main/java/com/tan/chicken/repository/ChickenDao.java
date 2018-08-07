package com.tan.chicken.repository;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Transaction;
import android.arch.persistence.room.Update;

import com.tan.chicken.domain.Chicken;
import com.tan.chicken.domain.User;

import java.util.List;
@Dao
public interface ChickenDao {

    @Transaction
    @Query("SELECT * FROM Chicken")
    LiveData<List<Chicken>> getAllChickens();

    @Query("SELECT * FROM chicken WHERE id IS (:id)")
    Chicken loadByChickenId(int id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Chicken chicken);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(Chicken... chickens);

    @Delete
    void delete(Chicken chicken);

    @Query("DELETE FROM chicken WHERE id IS (:id)")
    @Delete
    void deleteByChickenId(int id);

    @Update
    Chicken update(Chicken chicken);
}

