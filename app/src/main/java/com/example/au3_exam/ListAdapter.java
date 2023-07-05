package com.example.au3_exam;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<Student> {

    // Constructor to initialize the adapter with context and the data source.
    public ListAdapter(Context context, ArrayList<Student> userArrayList){
        super(context, R.layout.list_item, userArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // Get the student object from the data source at the specified position.
        Student student = getItem(position);

        // Inflate the layout for the list item if it is not already created.
        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        // Find the views within the layout.
        TextView first_name = convertView.findViewById(R.id.firstName);
        TextView last_name = convertView.findViewById(R.id.lastName);
        TextView number_of_notes = convertView.findViewById(R.id.number_of_notes);

        // Set the values of the views with the corresponding data from the student object.
        first_name.setText(student.first_name);
        last_name.setText(student.last_name);

        // Get the number of grades for the student object.
        int size = student.grades.size();

        // Set the number of grades as the text for the corresponding view.
        number_of_notes.setText(String.valueOf(size));

        return convertView;
    }
}
