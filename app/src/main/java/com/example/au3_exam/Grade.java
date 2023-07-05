package com.example.au3_exam;

public class Grade {

    // Declare two private variables of type String to store course name and grade
    String course_name,course_grade;

    // Constructor for creating an instance of the Grade class with a given course name and grade
    public Grade(String course_name, String course_grade) {
        // Set the values of the course name and grade variables
        this.course_name = course_name;
        this.course_grade = course_grade;
    }

    // Getter method to retrieve the course name
    public String getCourse_name() {
        return course_name;
    }

    // Setter method to set the course name
    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    // Getter method to retrieve the course grade
    public String getCourse_grade() {
        return course_grade;
    }

    // Setter method to set the course grade
    public void setCourse_grade(String course_grade) {
        this.course_grade = course_grade;
    }
}

