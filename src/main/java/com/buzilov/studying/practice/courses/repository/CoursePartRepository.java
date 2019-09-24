package com.buzilov.studying.practice.courses.repository;

import com.buzilov.studying.practice.courses.model.CoursePart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoursePartRepository extends JpaRepository<CoursePart, Long> {

    List<CoursePart> findAllByCourseId(Long courseId);

}
