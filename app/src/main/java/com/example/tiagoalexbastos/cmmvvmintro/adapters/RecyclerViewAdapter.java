package com.example.tiagoalexbastos.cmmvvmintro.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tiagoalexbastos.cmmvvmintro.databinding.RecyclerItemStudentBinding;
import com.example.tiagoalexbastos.cmmvvmintro.db.entity.Student;

import java.util.List;

/**
 * Created by tiagoalexbastos on 14-03-2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {

    private List<Student> studentList;

    public RecyclerViewAdapter(List<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerItemStudentBinding recyclerBinding = RecyclerItemStudentBinding
                .inflate(LayoutInflater.from(parent.getContext()), parent, false);

        return new RecyclerViewHolder(recyclerBinding.getRoot(), recyclerBinding);
    }

    @Override
    public void onBindViewHolder(final RecyclerViewHolder holder, int position) {
        Student student = studentList.get(position);
        holder.bind(student);
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public void addItems(List<Student> studentList) {
        this.studentList = studentList;
        notifyDataSetChanged();
    }

    static class RecyclerViewHolder extends RecyclerView.ViewHolder {
        private View view;
        private RecyclerItemStudentBinding studentBinding;

        RecyclerViewHolder(View view, RecyclerItemStudentBinding studentBinding) {
            super(view);
            this.view = view;
            this.studentBinding = studentBinding;
        }

        void bind(Student student) {
            this.studentBinding.setStudent(student);
        }
    }
}