package com.hfad.studentrecycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.View;

import java.util.Arrays;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = "STUDENTS";
    private RecyclerViewSimpleAdapter<Student> adapter;
    private final Student[] allStudents = Students.getAllStudents();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        //want to update adapters data when coming back from the child activity
        RecyclerView recyclerView = findViewById(R.id.mainStudentsRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter =  new RecyclerViewSimpleAdapter<>(Arrays.asList(allStudents));
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new RecyclerViewSimpleAdapter.OnItemClickListener() {

            @Override
            public void onItemClick(View view, int position, Object obj) {
                Student student = (Student) obj;
                Log.d(LOG_TAG, "Clicked " + position + " " + adapter.getItemId(position) + " " + student);
                Intent intent = new Intent(getBaseContext(),StudentDetailActivity.class);
                intent.putExtra(StudentDetailActivity.STUDENT, student);
                startActivity(intent);
            }
        });
    }

    public void orderByNameClicked(View view){
        Arrays.sort(allStudents, new Comparator<Student>() {

            @Override
            public int compare(Student t1, Student t2) {
                return t1.getName().compareToIgnoreCase(t2.getName());
            }
        });
        adapter.notifyDataSetChanged();
    }

    public void orderByEmailClicked(View view) {
        Arrays.sort(allStudents, new Comparator<Student>() {
            @Override
            public int compare(Student t1, Student t2) {
                return t1.getEmail().compareToIgnoreCase(t2.getEmail());
            }
        });
        adapter.notifyDataSetChanged();
    }

    public void orderByAgeClicked (View view) {
        Arrays.sort(allStudents, new Comparator<Student>() {
            @Override
            public int compare(Student t1, Student t2) {
                return t1.getAge() - t2.getAge();
            }
        });
        adapter.notifyDataSetChanged();
    }
}
