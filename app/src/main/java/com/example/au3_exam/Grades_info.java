package com.example.au3_exam;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class Grades_info extends AppCompatActivity {

    ListView list_grade;
    ArrayList<Grade> gradelist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grades_info);

        // Find the ListView in the layout and assign it to the list_grade variable
        list_grade = findViewById(R.id.list_grades);

        // Get the intent that started this activity
        Intent intent = this.getIntent();

        if (intent != null) {
            // Retrieve the ArrayList of grades from the intent as a Serializable extra
            List<String> grades = (ArrayList<String>) intent.getSerializableExtra("Grades");

            // Loop through the grades ArrayList and extract the course and grade values for each one
            for (int i = 0; i < grades.size(); i++) {
                String gradestring = grades.get(i);

                // Find the index of the comma that separates the course and grade values
                int commaIndex = gradestring.indexOf(",");

                // Extract the course value from the string using the substring method
                String course = gradestring.substring(8, commaIndex).trim();

                // Extract the grade value from the string using the substring method
                String grade_value = gradestring.substring(commaIndex + 8).trim();

                // Create a new Grade object with the course and grade values and add it to the gradelist ArrayList
                Grade grade = new Grade(course, grade_value);
                gradelist.add(grade);
            }

            // Create a new Gradelist_Adapter with the context and gradelist, and set it as the adapter for the ListView
            Gradelist_Adapter listAdapter = new Gradelist_Adapter(Grades_info.this, gradelist);
            list_grade.setAdapter(listAdapter);
            list_grade.setClickable(true);
        }
    }
}
