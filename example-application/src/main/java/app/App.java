package app;

import data.School.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private static List addPerson(String type, List list) {
        Scanner scn = new Scanner(System.in);

        if (type == "student") {
            System.out.println("---------- Nhập thông tin học sinh mới ----------");
        } else System.out.println("---------- Nhập thông tin giảng viên mới----------");
        System.out.printf("Nhập tên: ");
        String name = scn.nextLine();
        System.out.printf("Nhập tuổi: ");
        int age = scn.nextInt();
        scn.nextLine();
        System.out.printf("Nhập giới tính: ");
        String gender = scn.nextLine();
        if (type == "student") {
            System.out.printf("Nhập mã học sinh: ");
            String studentId = scn.nextLine();
            System.out.printf("Nhập lớp: ");
            int grade = scn.nextInt();
            Student newStudent = new Student(name, age, gender, studentId, grade);
            list.add(newStudent);
            return list;
        } else {
            System.out.printf("Nhập mã giảng viên: ");
            String employeeId = scn.nextLine();
            System.out.printf("Nhập môn: ");
            String subject = scn.nextLine();
            Teacher newTeacher = new Teacher(name, age, gender, employeeId, subject);
            list.add(newTeacher);
            return list;
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        Student duc = new Student("Đức", 17, "Nam", "JJFU2", 12);
        Student my = new Student("My", 14, "Nữ", "JJF33", 9);
        Teacher trung = new Teacher("Trung", 30, "Nam", "JDY33", "Math");

        List<Student> listStudent = new ArrayList<>();
        List<Teacher> listTeacher = new ArrayList<>();
        listStudent.add(duc);
        listStudent.add(my);
        listTeacher.add(trung);

        System.out.println("1. Thêm học sinh");
        System.out.println("2. Thêm giảng viên");
        System.out.println("3. Xem tất cả các học sinh");
        System.out.println("4. Xem tất cả các giảng viên");
        System.out.println("5. Thoát");
        System.out.printf("Nhập lựa chọn của bạn: ");
        int selectedOption = scn.nextInt();
        scn.nextLine();

        switch (selectedOption) {
            case 1:
                listStudent = addPerson("student", listStudent);
                break;

            case 2:
                listTeacher = addPerson("teacher", listTeacher);
                break;

            case 3:
                for (int i = 0; i < listStudent.size(); i++) {
                    listStudent.get(i).displayInfo();
                }
                break;
            case 4:
                for (int i = 0; i < listTeacher.size(); i++) {
                    listTeacher.get(i).displayInfo();
                }
                break;
            case 5:
                break;
        }
    }
}
