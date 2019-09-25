package com.buzilov.studying.practice.courses.service;

import com.buzilov.studying.practice.courses.dto.CourseDTO;
import com.buzilov.studying.practice.courses.model.Course;

import java.util.List;

public interface CourseService {

    List<CourseDTO> findAllRecent();

    void create(Course course);

    CourseDTO findById(Long id);

    void deleteById(Long id);

    void update(Course course);
}
