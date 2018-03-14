package com.example.tiagoalexbastos.cmmvvmintro.model.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by tiagoalexbastos on 14-03-2018.
 */

@Entity
public class Student {

    @PrimaryKey
    private int mec;
    private String name;
    private int age;


    public Student(int mec, String name, int age) {
        this.mec = mec;
        this.name = name;
        this.age = age;
    }

    public int getMec() {
        return mec;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}