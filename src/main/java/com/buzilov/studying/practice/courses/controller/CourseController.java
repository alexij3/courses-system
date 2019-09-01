package com.buzilov.studying.practice.courses.controller;

import com.buzilov.studying.practice.courses.model.Course;
import com.buzilov.studying.practice.courses.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courses")
@CrossOrigin(origins = "*")
public class CourseController {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @GetMapping("/recent")
    public Iterable<Course> getAllCourses() {
        PageRequest page = PageRequest.of(0, 10, Sort.by("startDateTime").descending());
        return courseRepository.findAll(page).getContent();
    }

}
