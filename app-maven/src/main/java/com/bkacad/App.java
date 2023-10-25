package com.bkacad;

import com.bkacad.shopData.*;

import com.bkacad.StudentNotFoundException.StudentNotFoundException;
import com.bkacad.data.StudentDAO;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        try {
            ProductManager.addProduct("DRRG5", "Tu", 22, 5000000);

            ArrayList<ProductManager.Product> productsList = ProductManager.getAllProducts();
            for (int i = 0; i < productsList.size(); i++) {
                productsList.get(i).printf();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    public static void main(String[] args) {
//        try {
////            StudentDAO.addStudent(5, "Jay", Date.valueOf(LocalDate.of(1993, 5, 15)));
//            ArrayList<StudentDAO.Student> studentList = StudentDAO.getStudent();
//            for (int i = 0; i < studentList.size(); i++) {
//                studentList.get(i).printf();
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            StudentDAO.getStudentById(3).printf();
//            StudentDAO.getStudentById(7).printf();
//        } catch (StudentNotFoundException e) {
//            System.out.println(e.getMessage());
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
}
