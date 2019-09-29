package com.buzilov.studying.practice.courses.controller;

import com.buzilov.studying.practice.courses.dto.CourseDTO;
import com.buzilov.studying.practice.courses.service.CourseService;
import com.buzilov.studying.practice.courses.util.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequestMapping("/courses")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.DELETE, RequestMethod.POST, RequestMethod.PUT, RequestMethod.OPTIONS})
public class CourseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/recent")
    public Iterable<CourseDTO> getRecentCourses(HttpServletRequest request) {
        return courseService.findAllRecent();
    }

    @GetMapping("/{id}")
    public CourseDTO getCourse(@PathVariable("id") Long id) {
        return courseService.findById(id);
    }

    @PostMapping("/create")
    public void createCourse(@Valid @RequestBody CourseDTO courseDTO) {
        this.courseService.create(CourseMapper.mapToEntity(courseDTO));
    }

    @DeleteMapping("/{id}/delete")
    public void deleteCourse(@PathVariable("id") Long id) {
        this.courseService.deleteById(id);
    }

    @PutMapping("/update")
    public void updateCourse(@Valid @RequestBody CourseDTO courseDTO, HttpServletResponse response) {
        this.courseService.update(CourseMapper.mapToEntity(courseDTO));
    }

}
