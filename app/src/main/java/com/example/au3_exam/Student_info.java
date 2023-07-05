package com.example.au3_exam;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class Student_info extends AppCompatActivity {

    // Declare the TextView and RelativeLayout objects
    TextView First_Name,Last_Name,ID,Grade_Avg;
    RelativeLayout Grades_layout;

    // Override the onCreate method
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_info);

        // Initialize the TextView and RelativeLayout objects with their respective views in the layout
        First_Name = findViewById(R.id.first_name);
        Last_Name = findViewById(R.id.last_name);
        ID = findViewById(R.id.id);
        Grade_Avg = findViewById(R.id.grade_avg);
        Grades_layout = findViewById(R.id.grades_layout);

        // Get the intent that started this activity
        Intent intent = this.getIntent();

        // Check if the intent is not null
        if (intent != null){

            // Get the extras from the intent
            String First_name = intent.getStringExtra("firstName");
            String Last_name = intent.getStringExtra("lastName");
            String Id = intent.getStringExtra("Id");
            ArrayList<String> grades = (ArrayList<String>) intent.getSerializableExtra("grades"); // retrieve the ArrayList as Serializable extra
            String grades_avg = intent.getStringExtra("grades_avg");

            // Set the TextViews with the values received from the intent extras
            First_Name.setText(First_name);
            Last_Name.setText(Last_name);
            ID.setText(Id);
            Grade_Avg.setText(grades_avg);

            // Set the OnClickListener for the grades layout
            Grades_layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Create an intent to start the Grades_info activity
                    Intent intent = new Intent(Student_info.this, Grades_info.class);
                    // Add the grades array of the clicked student as extras
                    intent.putExtra("Grades",grades);
                    // Start the activity
                    startActivity(intent);
                }
            });

            // Display a Toast message with the first name received from the intent extras
            // Toast.makeText(Student_info.this, "Data : "+First_name, Toast.LENGTH_SHORT).show();
        }
    }
}
