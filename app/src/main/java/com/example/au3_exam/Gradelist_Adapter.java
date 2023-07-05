package com.example.au3_exam;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class Gradelist_Adapter extends ArrayAdapter<Grade> {

    // Constructor for creating an instance of the Gradelist_Adapter class with a context and a list of grades
    public Gradelist_Adapter(Context context, List<Grade> grades) {
        // Call the superclass constructor and pass the context, layout resource ID, and list of grades
        super(context, R.layout.grades_item, grades);
    }

    // Override the getView method to set up the layout for each item in the list view
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the convertView is null, which indicates that we need to inflate the layout for the item
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.grades_item, parent, false);
        }

        // Get the Grade object for the current position in the list
        Grade grade = getItem(position);

        // Get references to the TextViews for the course name and grade
        TextView courseName = convertView.findViewById(R.id.course_name);
        TextView courseGrade = convertView.findViewById(R.id.course_grade);

        // Set the text for the TextViews based on the values of the current Grade object
        courseName.setText(grade.course_name);
        courseGrade.setText(grade.course_grade);

        // Return the convertView, which now contains the layout for the item in the list
        return convertView;
    }
}
