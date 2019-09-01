package com.buzilov.studying.practice.courses.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.Currency;

@Data
@RequiredArgsConstructor
public class CourseDTO {

    private String name;
    private String description;
    private Double price;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private String imageUrl;
    private Currency currency;

}
