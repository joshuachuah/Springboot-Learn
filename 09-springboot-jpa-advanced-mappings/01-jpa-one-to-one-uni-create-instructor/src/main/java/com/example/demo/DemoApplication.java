package com.example.demo;

import com.example.demo.dao.AppDAO;
import com.example.demo.entity.Instructor;
import com.example.demo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDAO appDAO) {

        return runner ->
                createInstructor(appDAO);
    }

    private void createInstructor(AppDAO appDAO) {

        // create the instructor
        Instructor tempInstructor =
                new Instructor("Joshua", "Chuah", "joshuachuah@hello.com");

        // create instructor detail
        InstructorDetail tempInstructorDetail =
                new InstructorDetail(
                        "http://www.lesserafim.com/youtube",
                        "Learning new technologies");

        // associate the objects
        tempInstructor.setInstructorDetail(tempInstructorDetail);

        // save the instructor
        //
        // NOTE: this will also save the details object
        // because of CascadeType.ALL
        //
        System.out.println("Saving instructor:" + tempInstructor);
        appDAO.save(tempInstructor);

        System.out.println("DONE");
    }
}
