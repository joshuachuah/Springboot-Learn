package com.example.cruddemo;

import com.example.cruddemo.dao.StudentDAO;
import com.example.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
           // createStudent(studentDAO);

           //  createMultipleStudents(studentDAO);

          // readStudent(studentDAO);

            // queryForStudents(studentDAO);
            
            // queryForStudentsByLastName(studentDAO);

            updateStudent(studentDAO);

        };
    }

    private void updateStudent(StudentDAO studentDAO) {
        // retrieve student based on the id: primary key
        int studentId = 1;
        System.out.println("Getting student with id: " + studentId);

        Student student = studentDAO.findById(studentId);

        // change first name to "Chad"
        System.out.println("Updating student...");

        student.setFirstName("Chad");
        studentDAO.update(student);

        // display the updated student
        System.out.println("Updated student: " + student);
    }

    private void queryForStudentsByLastName(StudentDAO studentDAO) {

        // get a list of students
        List<Student> students = studentDAO.findByLastName("Doe");

        // display list of students
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private void queryForStudents(StudentDAO studentDAO) {

        // get a list of students
        List<Student> students = studentDAO.findAll();

        // display list of students
        for (Student student : students) {
            System.out.println(student);
        }
    }


    private void readStudent(StudentDAO studentDAO) {

        // create a student object
        System.out.println("Creating new student object...");
        Student tempStudent = new Student("Daffy", "Duck", "daffyduck@gmail.com");

        // save the student object
        System.out.println("Saving the student...");
        studentDAO.save(tempStudent);

        // display id of the saved student
        int theId = tempStudent.getId();
        System.out.println("Saved student. Generated id: " + theId);

        // retrieve student based on the id: primary key
        System.out.println("Retrieving student with id: " + theId);

        Student myStudent = studentDAO.findById(theId);

        System.out.println("Found the student: " + myStudent);
    }

    private void createMultipleStudents(StudentDAO studentDAO) {

        // create multiple students
        System.out.println("Creating 3 student objects...");
        Student tempStudent1 = new Student("John", "Doe", "johndoe@gmail.com");
        Student tempStudent2 = new Student("Jessica", "Well", "jwell@gmail.com");
        Student tempStudent3= new Student("Alastair", "King", "alastairking1@gmail.com");

        // save the student objects
        System.out.println(("Saving the students..."));
        studentDAO.save(tempStudent1);
        studentDAO.save(tempStudent2);
        studentDAO.save(tempStudent3);

    }

    private void createStudent(StudentDAO studentDAO) {

        // create the student object
        System.out.println("Creating new student object...");
        Student tempStudent = new Student("Paul", "Doe", "pauldoe@gmail.com");

        // save the student object
        System.out.println("Saving the student...");
        studentDAO.save(tempStudent);

        // display id of the saved student
        System.out.println("Saved student. Generated id: " + tempStudent.getId());
    }

}
