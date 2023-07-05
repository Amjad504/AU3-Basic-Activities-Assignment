package com.example.au3_exam;

import java.util.ArrayList;

public class Student {

    // Declare instance variables for the Student class
    String id;
    String first_name;
    String last_name;
    String grades_avg;
    ArrayList<String> grades;

    // Constructor for the Student class
    public Student(String id, String first_name, String last_name, String grades_avg, ArrayList<String> grades) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.grades_avg = grades_avg;
        this.grades = grades;
    }

    // Getter method for the ID of the student
    public String getId() {
        return id;
    }

    // Setter method for the ID of the student
    public void setId(String id) {
        this.id = id;
    }

    // Getter method for the first name of the student
    public String getFirst_name() {
        return first_name;
    }

    // Setter method for the first name of the student
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    // Getter method for the last name of the student
    public String getLast_name() {
        return last_name;
    }

    // Setter method for the last name of the student
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    // Getter method for the list of grades for the student
    public ArrayList<String> getGrades() {
        return grades;
    }

    // Setter method for the list of grades for the student
    public void setGrades(ArrayList<String> grades) {
        this.grades = grades;
    }

    // Method to add a grade to the student's list of grades
    public void addGrade(String cours, int note) {
        String gradeString = "course: " + cours + ", grade: " + note;
        grades.add(gradeString);
    }
}
