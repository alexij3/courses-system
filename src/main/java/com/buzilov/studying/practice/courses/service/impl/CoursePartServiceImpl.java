package com.buzilov.studying.practice.courses.service.impl;

import com.buzilov.studying.practice.courses.dto.CoursePartDTO;
import com.buzilov.studying.practice.courses.model.CoursePart;
import com.buzilov.studying.practice.courses.repository.CoursePartRepository;
import com.buzilov.studying.practice.courses.service.CoursePartService;
import com.buzilov.studying.practice.courses.util.mapper.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CoursePartServiceImpl implements CoursePartService {

    private final CoursePartRepository coursePartRepository;

    @Autowired
    public CoursePartServiceImpl(CoursePartRepository coursePartRepository) {
        this.coursePartRepository = coursePartRepository;
    }


    @Override
    public List<CoursePartDTO> getCoursePartsByCourseId(Long courseId) {
        return coursePartRepository.findAllByCourseId(courseId).stream()
                .map(coursePart -> ObjectMapper.map(coursePart, CoursePartDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long partId) {
        coursePartRepository.deleteById(partId);
    }

    @Override
    public void create(CoursePart coursePart) {
        coursePartRepository.save(coursePart);
    }

    @Override
    public void update(CoursePart coursePart) {
        coursePartRepository.save(coursePart);
    }
}
