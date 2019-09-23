package com.buzilov.studying.practice.courses.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
public class CourseDTO {

    @Min(value = 1, message = "Name of the course must have at least 1 character.")
    @NotNull(message = "Name of the course cannot be null.")
    private String name;

    @Min(value = 1, message = "Short description must have at least 1 character.")
    @Max(value = 100, message = "Short description must not exceed 100 characters.")
    @NotNull(message = "Short description of the course cannot be null.")
    private String shortDescription;

    @Min(value = 1, message = "Description must have at least 1 character.")
    @NotNull(message = "Description of the course cannot be null.")
    private String description;

    @Min(value = 0, message = "Price of the course should be 0 (free) or more.")
    @NotNull(message = "Price of the course can be 0, but not null.")
    private Double price;

    @NotNull(message = "Start date and time of the course cannot be null.")
    private LocalDateTime startDateTime;

    @NotNull(message = "End date and time of the course cannot be null.")
    private LocalDateTime endDateTime;

    private String imageUrl;

}
