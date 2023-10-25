package com.bkacad.data;

import com.bkacad.StudentNotFoundException.StudentNotFoundException;

import java.sql.*;
import java.util.ArrayList;

public class StudentDAO {
    static final String TABLE_NAME = "students";
    static final String DB_URL = "jdbc:mysql://localhost:3306/bkacadTestMaven?autoReconnect=true&useSSL=false";
    static final String USER = "root";
    static final String PASS = "long200801";

    static public class Student {
        int id;
        String name;
        Date dob;

        Student(int id, String name, Date dob) {
            this.id = id;
            this.name = name;
            this.dob = dob;
        }

        public void printf() {
            System.out.printf("Id: %s, Name: %s, DoB: %s\n", id, name, dob);
        }
    }

    static public ArrayList<Student> getStudent() throws SQLException {
        final String QUERY = "select * from " + TABLE_NAME;
        ArrayList<Student> studentList = new ArrayList<>();

        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(QUERY);

        while (rs.next()) {
            studentList.add(new Student(rs.getInt("id"), rs.getString("name"), rs.getDate("dob")));
        }
        return studentList;
    }

    static public void addStudent(int id, String name, Date dob) throws SQLException {
        Student newStudent = new Student(id, name, dob);
        final String QUERY = "insert into " + TABLE_NAME + " (id,name,dob) values (" + newStudent.id + ",'" + newStudent.name + "','" + newStudent.dob + "')";

        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(QUERY);
    }

    static public Student getStudentById(int id) throws SQLException, StudentNotFoundException {
        final String QUERY = "select * from " + TABLE_NAME + " where id=" + id;

        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(QUERY);

        if (rs.next()) {
            return new Student(rs.getInt("id"), rs.getString("name"), rs.getDate("dob"));
        } else {
            throw new StudentNotFoundException(id);
        }
    }
}
