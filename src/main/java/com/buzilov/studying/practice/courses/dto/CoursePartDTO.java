package com.buzilov.studying.practice.courses.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class CoursePartDTO {

    @Min(value = 1, message = "Title of the course part must have at least 1 character.")
    @Max(value = 100, message = "Title of the course part must not exceed 100 characters.")
    @NotNull(message = "Title of the course part cannot be null.")
    private String title;

    @Min(value = 1, message = "Content of the course part must have at least 1 character.")
    @NotNull(message = "Content of the course cannot be null.")
    private String content;

}
