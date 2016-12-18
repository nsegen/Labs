package com.example.nsegen.studentlist;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.nsegen.studentlist.adapters.StudentsAdapter;
import com.example.nsegen.studentlist.models.Student;
import com.example.nsegen.studentlist.models.StudentList;

import java.util.List;

import static android.widget.AdapterView.*;

public class ListOfStudent extends AppCompatActivity {

    List<Student> students;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //StudentList students = StudentList.getInstance(this);


    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onResume() {
        super.onResume();
        setContentView(R.layout.activity_list_of_student);

        students = StudentList.getInstance(this).getList();

        ListView studentList = (ListView)findViewById(R.id.studentList);

        StudentsAdapter adapter = new StudentsAdapter(this, students);

        studentList.setAdapter(adapter);
        final Context ctx = this;

        studentList.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View itemClicked, int position,
                                    long id) {
                Intent intent = new Intent(ctx, EditStudentActivity.class);
                intent.putExtra("studentIndex", position);
                startActivity(intent);
            }
        });
        Button add = (Button) findViewById(R.id.addButton);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ctx, EditStudentActivity.class);
                intent.putExtra("studentIndex", -1);
                startActivity(intent);
            }
        });

    }
}
