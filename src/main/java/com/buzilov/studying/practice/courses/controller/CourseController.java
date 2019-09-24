package com.buzilov.studying.practice.courses.controller;

import com.buzilov.studying.practice.courses.dto.CourseDTO;
import com.buzilov.studying.practice.courses.dto.CoursePartDTO;
import com.buzilov.studying.practice.courses.service.CoursePartService;
import com.buzilov.studying.practice.courses.service.CourseService;
import com.buzilov.studying.practice.courses.util.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;
    private final CoursePartService coursePartService;

    @Autowired
    public CourseController(CourseService courseService, CoursePartService coursePartService) {
        this.courseService = courseService;
        this.coursePartService = coursePartService;
    }

    @GetMapping("/recent")
    public Iterable<CourseDTO> getRecentCourses(HttpServletRequest request) {
        return courseService.findAllRecent(request.getLocale());
    }

    @GetMapping("/{id}")
    public CourseDTO getCourse(@PathVariable("id") Long id) {
        return courseService.findById(id);
    }

    @GetMapping("/{courseId}/parts")
    public List<CoursePartDTO> getCourseParts(@PathVariable("courseId") Long courseId) {
        return coursePartService.getCoursePartsByCourseId(courseId);
    }

    @PostMapping("/create")
    public void createCourse(@Valid @RequestBody CourseDTO courseDTO, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
        this.courseService.create(CourseMapper.mapToEntity(courseDTO));
    }

}
