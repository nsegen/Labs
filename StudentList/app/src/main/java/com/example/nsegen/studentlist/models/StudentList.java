package com.example.nsegen.studentlist.models;

import android.content.Context;

import com.example.nsegen.studentlist.DAO.DBHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nsegen on 5.12.16.
 */

public class StudentList {

    private static StudentList studentList;

    private List<Student> students;

    private DBHelper dbHelper;

    private StudentList(Context ctx) {

        dbHelper = new DBHelper(ctx);
        students = dbHelper.getStudents();

    }

    public static StudentList getInstance(Context ctx) {

        if(studentList == null) studentList = new StudentList(ctx);
        return studentList;

    }

    public Student get(Integer i) {

        return students.get(i);

    }

    public StudentList add(Student student) {

        Long id = dbHelper.addStudent(student);
        if(id != -1) {
            student.setStudentId(id);
        }
        students.add(student);
        return this;

    }

    public StudentList set(Integer i, Student student) {

        dbHelper.updateStudent(student);
        students.set(i, student);
        return this;

    }

    public List<Student> getList() {

        return students;

    }

    public StudentList delete(int index) {
        dbHelper.deleteStudent(students.get(index).getStudentId());
        students.remove(index);
        return this;
    }

    public Integer size() {

        return students.size();

    }

}
