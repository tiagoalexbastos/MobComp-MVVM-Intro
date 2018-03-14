package com.example.tiagoalexbastos.cmmvvmintro;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.tiagoalexbastos.cmmvvmintro.model.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private MainActivityViewModel viewModel;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private FloatingActionButton addStudentFab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerViewAdapter = new RecyclerViewAdapter(new ArrayList<Student>());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(recyclerViewAdapter);

        addStudentFab = (FloatingActionButton) findViewById(R.id.floatingActionButton);

        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);

        subscribeViewModel();

        addStudentFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.addStudent();
            }
        });

    }

    private void subscribeViewModel() {
        viewModel.getmObservableStudents().observe(this, new Observer<List<Student>>() {
            @Override
            public void onChanged(@Nullable List<Student> studentList) {
                recyclerViewAdapter.addItems(studentList);
            }
        });
    }
}
