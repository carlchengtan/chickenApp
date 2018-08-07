package com.tan.chicken.repository;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.tan.chicken.domain.Chicken;

@Database(entities = {Chicken.class}, version = 1)
public abstract class ChickenRoomDatabase extends RoomDatabase {

    public abstract ChickenDao chickenDao();

    private static ChickenRoomDatabase INSTANCE;


    static ChickenRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (ChickenRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            ChickenRoomDatabase.class, "word_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}