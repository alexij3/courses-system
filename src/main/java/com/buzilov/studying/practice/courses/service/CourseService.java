package com.buzilov.studying.practice.courses.service;

import com.buzilov.studying.practice.courses.dto.CourseDTO;
import com.buzilov.studying.practice.courses.model.Course;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Locale;

public interface CourseService {

    List<CourseDTO> findAllRecent(Locale locale);

    void create(Course course);
}
