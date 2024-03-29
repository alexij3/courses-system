package com.buzilov.studying.practice.courses.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@RequiredArgsConstructor
public class CoursePartDTO {

    private Long id;

    private CourseDTO course;

    @Size(min = 1, max = 100, message = "Title of the course part must have from 1 to 100 characters.")
    @NotNull(message = "Title of the course part cannot be null.")
    private String title;

    @Size(min = 1, message = "Content of the course part must have at least 1 character.")
    @NotNull(message = "Content of the course cannot be null.")
    private String content;

}
