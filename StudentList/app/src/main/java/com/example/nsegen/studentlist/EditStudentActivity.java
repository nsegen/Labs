package com.example.nsegen.studentlist;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.nsegen.studentlist.models.Student;
import com.example.nsegen.studentlist.models.StudentList;

public class EditStudentActivity extends AppCompatActivity {

    int studentIndex;
    Student student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_student);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final Context ctx = this;

        Button save = (Button) findViewById(R.id.saveButton);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Data saved", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                student.setFirstName(((EditText)findViewById(R.id.firstNameEdit)).getText().toString());
                student.setSecondName(((EditText)findViewById(R.id.secondNameEdit)).getText().toString());
                student.setPhoneNumber(((EditText)findViewById(R.id.phoneNumberEdit)).getText().toString());
                student.setEmail(((EditText)findViewById(R.id.emailEdit)).getText().toString());
                if(studentIndex == -1) {
                    StudentList.getInstance(ctx).add(student);
                } else {
                    StudentList.getInstance(ctx).set(studentIndex, student);
                }
                Intent intent = new Intent(ctx, ListOfStudent.class);
                startActivity(intent);
            }
        });

        Button delete = (Button) findViewById(R.id.deleteButton);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Data deleted", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                if(studentIndex != -1) {
                    StudentList.getInstance(ctx).delete(studentIndex);
                }
                Intent intent = new Intent(ctx, ListOfStudent.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        studentIndex = getIntent().getIntExtra("studentIndex", 0);
        student = (studentIndex == -1) ? new Student() : StudentList.getInstance(this).get(studentIndex);
        ((EditText)findViewById(R.id.firstNameEdit)).setText(student.getFirstName());
        ((EditText)findViewById(R.id.secondNameEdit)).setText(student.getSecondName());
        ((EditText)findViewById(R.id.phoneNumberEdit)).setText(student.getPhoneNumber());
        ((EditText)findViewById(R.id.emailEdit)).setText(student.getEmail());

    }

}
