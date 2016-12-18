package com.example.nsegen.studentlist.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.nsegen.studentlist.R;
import com.example.nsegen.studentlist.models.Student;

import java.util.List;

/**
 * Created by nsegen on 14.11.16.
 */

public class StudentsAdapter extends BaseAdapter {

    private Context ctx;
    private LayoutInflater lInflater;
    private List<Student> students;

    public StudentsAdapter(Context context, List<Student> students) {
        ctx = context;
        this.students = students;
        lInflater = (LayoutInflater) ctx
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return students.size();
    }

    @Override
    public Object getItem(int position) {
        return students.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;
        if (view == null) {
            view = lInflater.inflate(R.layout.student_list_item, parent, false);
        }


        Student student = getStudent(position);

        ((TextView) view.findViewById(R.id.fullName)).setText(student.getFullName());
        ((TextView) view.findViewById(R.id.phoneNumber)).setText(student.getPhoneNumber());
        return view;
    }

    private Student getStudent(int position) {
        return (Student) getItem(position);
    }
}
