package com.example.week1assignment;

import com.example.week1assignment.domain.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.example.week1assignment.domain.CourseRepository;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import com.example.week1assignment.domain.CourseRequestedDto;

import java.util.List;

@EnableJpaAuditing
@SpringBootApplication
public class Week1assignmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(Week1assignmentApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(CourseRepository courseRepository, CourseService courseService) {
        return (args) -> {
            courseRepository.save(new Course("프론트엔드의 꽃, 리액트", "임민영"));

            System.out.println("데이터 인쇄");
            List<Course> courseList = courseRepository.findAll();
            for (int i=0; i<courseList.size(); i++) {
                Course course = courseList.get(i);
                System.out.println(course.getId());
                System.out.println(course.getTitle());
                System.out.println(course.getTutor());
            }

            CourseRequestedDto requestedDto = new CourseRequestedDto("웹개발의 봄, Spring", "임민영");
            courseService.update(1L, requestedDto);
            courseList = courseRepository.findAll();
            for (int i=0; i<courseList.size(); i++) {
                Course course = courseList.get(i);
                System.out.println(course.getId());
                System.out.println(course.getTitle());
                System.out.println(course.getTutor());
            }
        };
    }

}