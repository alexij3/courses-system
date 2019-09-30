package com.buzilov.studying.practice.courses.service.impl;

import com.buzilov.studying.practice.courses.dto.CourseDTO;
import com.buzilov.studying.practice.courses.model.Course;
import com.buzilov.studying.practice.courses.repository.CourseRepository;
import com.buzilov.studying.practice.courses.service.CourseService;
import com.buzilov.studying.practice.courses.util.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<CourseDTO> findAllRecent() {
        PageRequest page = PageRequest.of(0, 10, Sort.by("startDateTime").ascending());
        List<Course> courses = courseRepository.findAll(page).getContent();
        return courses.stream()
                .map(CourseMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    @PreAuthorize("hasRole('ROLE_CM')")
    public void create(Course course) {
        this.courseRepository.save(course);
    }

    @Override
    public CourseDTO findById(Long id) {
        return CourseMapper.mapToDto(courseRepository.findById(id).orElse(null));
    }

    @Override
    @PreAuthorize("hasRole('ROLE_CM')")
    public void deleteById(Long id) {
        courseRepository.deleteById(id);
    }

    @Override
    @PreAuthorize("hasRole('ROLE_CM')")
    public void update(Course course) {
        courseRepository.save(course);
    }
}
