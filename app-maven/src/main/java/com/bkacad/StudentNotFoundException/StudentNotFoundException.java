package com.bkacad.StudentNotFoundException;

public class StudentNotFoundException extends Exception {
    Integer studentId;

    public StudentNotFoundException(Integer id) {
        super("Không tìm thấy thông tin của sinh viên " + id);
        this.studentId = id;
    }
}
