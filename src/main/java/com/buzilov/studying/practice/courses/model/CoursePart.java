package com.buzilov.studying.practice.courses.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "course_parts")
public class CoursePart {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_parts_generator")
    @SequenceGenerator(name = "course_parts_generator", sequenceName = "course_parts_seq")
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Lob
    @Column(nullable = false, columnDefinition = "text")
    private String content;

    @ManyToOne
    private Course course;
}
