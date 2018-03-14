package com.example.tiagoalexbastos.cmmvvmintro.model.config;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.tiagoalexbastos.cmmvvmintro.model.dao.StudentDao;
import com.example.tiagoalexbastos.cmmvvmintro.model.entity.Student;

/**
 * Created by tiagoalexbastos on 14-03-2018.
 */

@Database(entities = {Student.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;

    public static AppDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class,
                    "students_db")
                    .build();
        }
        return INSTANCE;
    }

    public abstract StudentDao studentDao();

}
