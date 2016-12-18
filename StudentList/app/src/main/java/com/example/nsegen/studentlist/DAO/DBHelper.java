package com.example.nsegen.studentlist.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.nsegen.studentlist.models.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nsegen on 17.12.16.
 */

public class DBHelper extends SQLiteOpenHelper {

    private static final String dbName = "studentListDB";
    private static final String tableName = "student_list";
    private static final String firstName = "first_name";
    private static final String lastName = "last_name";
    private static final String phone = "phone";
    private static final String email = "email";

    public DBHelper(Context context) {
        // конструктор суперкласса
        super(context, dbName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // создаем таблицу с полями
        db.execSQL("create table " + tableName + " ("
                + "id integer primary key autoincrement,"
                + firstName + " text,"
                + lastName + " text,"
                + email + " text,"
                + phone + " text" + ");");
    }

    public Long addStudent(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(firstName, student.getFirstName()); // Contact Name
        values.put(lastName, student.getSecondName()); // Contact Name
        values.put(email, student.getEmail()); // Contact Phone Number
        values.put(phone, student.getPhoneNumber()); // Contact Phone Number

        // Inserting Row
        Long id = db.insert(tableName, null, values);
        db.close(); // Closing database connection
        return id;
    }

    public List<Student> getStudents() {
        SQLiteDatabase db = this.getWritableDatabase();
        List<Student> students = new ArrayList<>();
        String query = "select * from " + tableName;
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                Student student = new Student();
                student.setStudentId(Long.parseLong(cursor.getString(0)));
                student.setFirstName(cursor.getString(1));
                student.setSecondName(cursor.getString(2));
                student.setEmail(cursor.getString(4));
                student.setPhoneNumber(cursor.getString(3));
                // Adding contact to list
                students.add(student);
            } while (cursor.moveToNext());
        }
        // Inserting Row
        db.close(); // Closing database connection
        return students;
    }

    public void updateStudent(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(firstName, student.getFirstName());
        values.put(lastName, student.getSecondName());
        values.put(phone, student.getPhoneNumber());
        values.put(email, student.getEmail());

        // updating row
        db.update(tableName, values, "id" + " = ?",
                new String[] { String.valueOf(student.getStudentId()        ) });
    }

    public void deleteStudent(Long id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tableName, "id" + " = ?",
                new String[] { String.valueOf(id)});
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
