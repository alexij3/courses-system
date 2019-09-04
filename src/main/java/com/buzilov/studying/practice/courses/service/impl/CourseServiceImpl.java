package com.buzilov.studying.practice.courses.service.impl;

import com.buzilov.studying.practice.courses.dto.CourseDTO;
import com.buzilov.studying.practice.courses.model.Course;
import com.buzilov.studying.practice.courses.repository.CourseRepository;
import com.buzilov.studying.practice.courses.service.CourseService;
import com.buzilov.studying.practice.courses.util.PriceAdapter;
import com.buzilov.studying.practice.courses.util.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<CourseDTO> findAllRecent(Locale locale) {
        PageRequest page = PageRequest.of(0, 10, Sort.by("startDateTime").descending());
        Iterable<Course> courses = courseRepository.findAll(page).getContent();
        return ((List<Course>) courses).stream()
                .map(CourseMapper::mapToDto)
                .forEach(courseDTO -> courseDTO.setPrice());
    }
}
