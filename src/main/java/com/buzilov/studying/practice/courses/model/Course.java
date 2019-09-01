package com.buzilov.studying.practice.courses.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_generator")
    @SequenceGenerator(name = "course_generator", sequenceName = "courses_seq")
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column(name = "start_date_time")
    private LocalDateTime startDateTime;

    @Column(name = "end_date_time")
    private LocalDateTime endDateTime;

    @Column(precision = 2)
    private Double price;

    @Column
    private String imageUrl;

    @OneToMany(mappedBy = "course", cascade = CascadeType.REMOVE)
    private Set<CoursePart> courseParts;

}
