package data;

public class School {
    public static class Person {
        String name, gender;
        int age;

        public Person(String name, int age, String gender) {
            this.name = name;
            this.age = age;
            this.gender = gender;
        }

        void displayInfo() {
            System.out.println("---------- Thông tin cá nhân ----------");
            System.out.printf("Tên: %s\n", name);
            System.out.printf("Tuổi: %s\n", age);
            System.out.printf("Giới tính: %s\n", gender);
        }
    }

    public static class Student extends Person {
        String studentId;
        int grade;

        public Student(String name, int age, String gender, String studentId, int grade) {
            super(name, age, gender);
            this.studentId = studentId;
            this.grade = grade;
        }

        public void displayInfo() {
            System.out.printf("---------- Thông tin học sinh mã \"%s\" ----------\n", studentId);
            System.out.printf("Tên: %s\n", name);
            System.out.printf("Tuổi: %s\n", age);
            System.out.printf("Giới tính: %s\n", gender);
            System.out.printf("Mã sinh viên: %s\n", studentId);
            System.out.printf("Lớp: %s\n", grade);
        }
    }

    public static class Teacher extends Person {
        String employeeId, subject;

        public Teacher(String name, int age, String gender, String employeeId, String subject) {
            super(name, age, gender);
            this.employeeId = employeeId;
            this.subject = subject;
        }

        public void displayInfo() {
            System.out.printf("---------- Thông tin giảng viên mã \"%s\" ----------\n", employeeId);
            System.out.printf("Tên: %s\n", name);
            System.out.printf("Tuổi: %s\n", age);
            System.out.printf("Giới tính: %s\n", gender);
            System.out.printf("Mã giảng viên: %s\n", employeeId);
            System.out.printf("Giảng viên môn: %s\n", subject);
        }
    }
}
