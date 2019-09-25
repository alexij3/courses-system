package com.buzilov.studying.practice.courses.service;

import com.buzilov.studying.practice.courses.dto.CoursePartDTO;
import com.buzilov.studying.practice.courses.model.CoursePart;

import java.util.List;

public interface CoursePartService {

    List<CoursePartDTO> getCoursePartsByCourseId(Long courseId);

    void deleteById(Long partId);

    void create(CoursePart coursePart);

    void update(CoursePart coursePart);
}
