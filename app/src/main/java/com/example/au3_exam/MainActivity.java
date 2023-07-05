package com.example.au3_exam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ListView listView;
    ArrayList<Student> studentArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set layout for the activity
        setContentView(R.layout.activity_main);

        // Connect ListView with layout
        listView = findViewById(R.id.list);

        // Define grades, calculate average, and create a new student object for student 1
        String[] student1Grades = {"Statistiques", "Introduction aux bases de données", "Développement d'applications mobiles pour Android", "Introduction à la programmation Web client", "Assurance de qualité logicielle", "Programmation orientée objet en C#", "Written Communication: Intermediate Level"};
        int[] student1GradesValues = {16, 17, 7, 13, 15, 18, 12};
        int sum = 0;
        for (int student1GradesValue : student1GradesValues) {
            sum += student1GradesValue;
        }
        double grades1_avg = (double) sum / student1GradesValues.length;
        String formattedAvg1 = String.format("%.2f", grades1_avg);// making result into two decimal places
        Student student1 = new Student("2758780", "Aziz", "Benoît", formattedAvg1, new ArrayList<String>());
        for (int i = 0; i < student1Grades.length; i++) {
            student1.addGrade(student1Grades[i], student1GradesValues[i]);
        }
        studentArrayList.add(student1);

        // Define grades, calculate average, and create a new student object for student 2
        String[] student2Grades = {"Statistiques", "Introduction aux bases de données", "Développement d'applications mobiles pour Android", "Introduction à la programmation Web client", "Assurance de qualité logicielle", "Programmation orientée objet en C#", "Written Communication: Intermediate Level"};
        int[] student2GradesValues = {14, 18, 12, 15, 16, 10, 17};
        int sum2 = 0;
        for (int student2GradesValue : student2GradesValues) {
            sum2 += student2GradesValue;
        }
        double grades2_avg = (double) sum2 / student2GradesValues.length;
        String formattedAvg2 = String.format("%.2f", grades2_avg); // making result into two decimal places
        Student student2 = new Student("6845976", "Jim", "Gordon",formattedAvg2, new ArrayList<String>());
        for (int i = 0; i < student2Grades.length; i++) {
            student2.addGrade(student2Grades[i], student2GradesValues[i]);
        }
        studentArrayList.add(student2);

        // Define grades, calculate average, and create a new student object for student 3
        String[] student3Grades = {"Statistiques", "Introduction aux bases de données", "Développement d'applications mobiles pour Android", "Introduction à la programmation Web client", "Assurance de qualité logicielle", "Programmation orientée objet en C#", "Written Communication: Intermediate Level"};
        int[] student3GradesValues = {19, 15, 11, 16, 14, 20, 9};
        int sum3 = 0;
        for (int student3GradesValue : student3GradesValues) {
            sum3 += student3GradesValue;
        }
        double grades3_avg = (double) sum3 / student3GradesValues.length;
        String formattedAvg3 = String.format("%.2f", grades3_avg);// making result into two decimal places
        Student student3 = new Student("9576248", "Bruse", "wayne", formattedAvg3, new ArrayList<String>());
        for (int i = 0; i < student3Grades.length; i++) {
            student3.addGrade(student3Grades[i], student3GradesValues[i]);
        }
        studentArrayList.add(student3);

        // Define grades, calculate average, and create a new student object for student 4
        String[] student4Grades = {"Statistiques", "Introduction aux bases de données", "Développement d'applications mobiles pour Android", "Introduction à la programmation Web client", "Assurance de qualité logicielle", "Programmation orientée objet en C#", "Written Communication: Intermediate Level"};
        int[] student4GradesValues = {13, 20, 8, 18, 12, 16,11};
        int sum4 = 0;
        for (int student4GradesValue : student4GradesValues) {
            sum4 += student4GradesValue;
        }
        double grades4_avg = (double) sum4 / student4GradesValues.length;
        String formattedAvg4 = String.format("%.2f", grades4_avg);// making result into two decimal places


        Student student4 = new Student("3582961", "Emma", "Martin",formattedAvg4, new ArrayList<String>());
        for (int i = 0; i < student4Grades.length; i++) {
            student4.addGrade(student4Grades[i], student4GradesValues[i]);
        }
        studentArrayList.add(student4);

        ListAdapter listAdapter = new ListAdapter(MainActivity.this,studentArrayList);

        listView.setAdapter(listAdapter);
        listView.setClickable(true);

        // Set up an onItemClickListener to handle clicks on a ListView item.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            // Define the onItemClick method that will be called when an item is clicked.
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // Retrieve the Student object that was clicked from the ArrayList of students.
                Student clickedStudent = studentArrayList.get(position);

                // Create an intent to start the Student_info activity.
                Intent intent = new Intent(MainActivity.this, Student_info.class);

                // Add the ID of the clicked student as an extra to the intent.
                intent.putExtra("Id",clickedStudent.id);

                // Add the first and last name of the clicked student as extras to the intent.
                intent.putExtra("firstName", clickedStudent.first_name);
                intent.putExtra("lastName", clickedStudent.last_name);

                // Add the array of grades of the clicked student as an extra to the intent.
                intent.putExtra("grades", clickedStudent.grades);

                // Add the average of grades of the clicked student as an extra to the intent.
                intent.putExtra("grades_avg", clickedStudent.grades_avg);

                // Start the activity that will display the details of the clicked student.
                startActivity(intent);
            }
        });

    }
}