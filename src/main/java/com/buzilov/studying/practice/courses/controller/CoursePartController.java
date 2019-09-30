package com.buzilov.studying.practice.courses.controller;

import com.buzilov.studying.practice.courses.dto.CoursePartDTO;
import com.buzilov.studying.practice.courses.model.CoursePart;
import com.buzilov.studying.practice.courses.service.CoursePartService;
import com.buzilov.studying.practice.courses.util.mapper.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.DELETE, RequestMethod.POST, RequestMethod.PUT, RequestMethod.OPTIONS})
public class CoursePartController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CoursePartController.class);

    private final CoursePartService coursePartService;

    @Autowired
    public CoursePartController(CoursePartService coursePartService) {
        this.coursePartService = coursePartService;
    }

    @PostMapping("/courses/parts/create")
    public void createCoursePart(@Valid @RequestBody CoursePartDTO coursePartDTO) {
        this.coursePartService.create(ObjectMapper.map(coursePartDTO, CoursePart.class));
    }

    @GetMapping("/courses/{courseId}/parts")
    public List<CoursePartDTO> getCourseParts(@PathVariable("courseId") Long courseId) {
        long currentTime = System.currentTimeMillis();
        List<CoursePartDTO> list = coursePartService.getCoursePartsByCourseId(courseId);
        LOGGER.info("Getting course parts took: {}s.", (System.currentTimeMillis() - currentTime / 1000.0));
        return list;
    }

    @PutMapping("/courses/parts/update")
    public void updateCoursePart(@Valid @RequestBody CoursePartDTO coursePartDTO) {
        coursePartService.update(ObjectMapper.map(coursePartDTO, CoursePart.class));
    }

    @DeleteMapping("/courses/parts/{partId}/delete")
    public void deleteCoursePart(@PathVariable("partId") Long partId) {
        this.coursePartService.deleteById(partId);
    }
}
