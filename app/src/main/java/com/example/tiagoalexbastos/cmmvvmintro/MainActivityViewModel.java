package com.example.tiagoalexbastos.cmmvvmintro;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.example.tiagoalexbastos.cmmvvmintro.model.config.AppDatabase;
import com.example.tiagoalexbastos.cmmvvmintro.model.entity.Student;

import java.util.List;
import java.util.Random;

/**
 * Created by tiagoalexbastos on 14-03-2018.
 */

public class MainActivityViewModel extends AndroidViewModel {

    private LiveData<List<Student>> mObservableStudents;
    private AppDatabase db;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);

        db = AppDatabase.getDatabase(this.getApplication());
        mObservableStudents = db.studentDao().getAllStudents();
    }

    public LiveData<List<Student>> getmObservableStudents() {
        return mObservableStudents;
    }

    public void addStudent() {
        int nMec = new Random().nextInt(100 - 1 + 1) + 1;
        String name = "Aluno " + String.valueOf(nMec);
        int idade = new Random().nextInt(25 - 18 + 1) + 18;

        Student toInsert = new Student(nMec, name, idade);

        new addAsyncTask(db).execute(toInsert);
    }

    private static class addAsyncTask extends AsyncTask<Student, Void, Void> {

        private AppDatabase db;

        addAsyncTask(AppDatabase appDatabase) {
            db = appDatabase;
        }



        @Override
        protected Void doInBackground(Student... students) {
            db.studentDao().addStudent(students[0]);
            return null;
        }
    }
}
