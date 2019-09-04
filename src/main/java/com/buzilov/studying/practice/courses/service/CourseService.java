package com.buzilov.studying.practice.courses.service;

import com.buzilov.studying.practice.courses.dto.CourseDTO;

import java.util.List;
import java.util.Locale;

public interface CourseService {

    List<CourseDTO> findAllRecent(Locale locale);

}
