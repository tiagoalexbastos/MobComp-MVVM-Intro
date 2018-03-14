package com.example.tiagoalexbastos.cmmvvmintro.model.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.tiagoalexbastos.cmmvvmintro.model.entity.Student;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

/**
 * Created by tiagoalexbastos on 14-03-2018.
 */


@Dao
public interface StudentDao {

    @Query("select * from Student")
    LiveData<List<Student>> getAllStudents();

    @Insert(onConflict = REPLACE)
    void addStudent(Student student);

}
