package com.clem.cruddemo;

import com.clem.cruddemo.dao.StudentDAO;
import com.clem.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
//            createStudent(studentDAO);
            createMultipleStudents(studentDAO);
//            readStudent(studentDAO);
//            readAllStudents(studentDAO);
//            getStudentsByLastName(studentDAO);
//            updateStudent(studentDAO);
//            deleteStudent(studentDAO);
//            deleteAllStudents(studentDAO);
        };
    }

    private void deleteAllStudents(StudentDAO studentDAO) {
        System.out.println("Deleting all students...");
        int count = studentDAO.deleteAll();
        System.out.println("Total students deleted: " + count);
    }

    private void deleteStudent(StudentDAO studentDAO) {
        System.out.println("Deleting student...");
        studentDAO.deleteById(5);
        System.out.println("Student deleted with ID 1");
    }

    private void updateStudent(StudentDAO studentDAO) {
        System.out.println("Updating student...");
        Student student = studentDAO.findById(1);
        student.setFirstName("Jones");
        studentDAO.update(student);
        System.out.println("Student updated. ");
        System.out.println(student);
    }

    private void getStudentsByLastName(StudentDAO studentDAO) {
        System.out.println("Students by last name 'John':");
        for (Student student : studentDAO.findByLastName("John")) {
            System.out.println(student);
        }
    }


    private void readAllStudents(StudentDAO studentDAO) {
        System.out.println("All students:");
        for (Student student : studentDAO.findAll()) {
            System.out.println(student);
        }
    }

    private void readStudent(StudentDAO studentDAO) {
        System.out.println("Fetching student by ID:");
        Student student = new Student("New", "John", "new@gmail.com");
        studentDAO.save(student);
        System.out.println(studentDAO.findById(student.getId()));
//        studentDAO.findById(student.getId());
    }

    private void createMultipleStudents(StudentDAO studentDAO) {
        studentDAO.save(new Student("John", "Doe", "john@gmail.com"));
        studentDAO.save(new Student("Jane", "Smith", "jane@gmail.com"));
        studentDAO.save(new Student("Bob", "Johnson", "bob@gmail.com"));
    }

    private void createStudent(StudentDAO studentDAO) {
        System.out.println("Creating a new student object...");
        Student student = new Student("Paul", "John", "john@gmail.com");

        System.out.println("Saving the student...");
        studentDAO.save(student);

        System.out.println("Saved student. Generated id: " + student.getId());
    }


}
