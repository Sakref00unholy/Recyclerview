package com.hfad.studentrecycleview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class StudentDetailActivity extends AppCompatActivity {
    public static final String STUDENT = "student";
    private static final String LOG_TAG = "STUDENTS";
    private int studentId;
    private EditText nameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_detail);
        Intent intent = getIntent();
        Student student = (Student) intent.getSerializableExtra(STUDENT);
        Log.d(LOG_TAG, student.toString());

        studentId = student.getId();
        TextView textView = findViewById(R.id.studentDetailIdTextView);
        textView.setText(String.format("id: %d",student.getId()));

        TextView emailView = findViewById(R.id.studentDetailEmailTextView);
        emailView.setText("email "+ student.getEmail());

        TextView ageView = findViewById(R.id.studentDetailAgeTextView);
        ageView.setText("age %d"+ student.getName());

        TextView nameView = findViewById(R.id.studentDetailNameTextView);
        nameView.setText(student.getName());

    }
    public void studentDetailUpdateButtonClicked(View view){
        Student student = Students.getStudentById(studentId);
        if (student != null) {
            String newName = nameView.getText().toString();
            student.setName (newName);
        }
    }
    public void studentDetailBackButtonClicked(View view){
        finish();
    }
}
