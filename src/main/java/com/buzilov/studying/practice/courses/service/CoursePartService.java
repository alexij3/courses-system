package com.buzilov.studying.practice.courses.service;

import com.buzilov.studying.practice.courses.dto.CoursePartDTO;

import java.util.List;

public interface CoursePartService {

    List<CoursePartDTO> getCoursePartsByCourseId(Long courseId);

}
