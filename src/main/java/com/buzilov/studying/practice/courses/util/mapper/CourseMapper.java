package com.buzilov.studying.practice.courses.util.mapper;

import com.buzilov.studying.practice.courses.dto.CourseDTO;
import com.buzilov.studying.practice.courses.model.Course;
import org.modelmapper.ModelMapper;

public class CourseMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    private CourseMapper() {
    }

    public static CourseDTO mapToDto(Course entity) {
        return modelMapper.map(entity, CourseDTO.class);
    }

    public static Course mapToEntity(CourseDTO dto) {
        return modelMapper.map(dto, Course.class);
    }

}
