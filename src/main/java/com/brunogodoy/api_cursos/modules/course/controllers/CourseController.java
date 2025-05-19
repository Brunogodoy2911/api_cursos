package com.brunogodoy.api_cursos.modules.course.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.brunogodoy.api_cursos.modules.course.CourseEntity;
import com.brunogodoy.api_cursos.modules.course.useCases.CreateCourseUseCase;
import com.brunogodoy.api_cursos.modules.course.useCases.GetAllCoursesByNameAndCategory;
import com.brunogodoy.api_cursos.modules.course.useCases.GetAllCoursesUseCase;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/courses")
public class CourseController {

  @Autowired
  private CreateCourseUseCase createCourseUseCase;

  @Autowired
  private GetAllCoursesUseCase getAllCoursesUseCase;

  @Autowired
  private GetAllCoursesByNameAndCategory getAllCoursesByNameAndCategory;

  @PostMapping
  public ResponseEntity<Object> create(@Valid @RequestBody CourseEntity courseEntity) {
    try {
      var result = this.createCourseUseCase.execute(courseEntity);
      return ResponseEntity.ok().body(result);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }

  @GetMapping
  public ResponseEntity<Object> getAll() {

    try {
      var courses = this.getAllCoursesUseCase.execute();
      return ResponseEntity.ok().body(courses);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }

  }

  @GetMapping("/search")
  public ResponseEntity<Object> getByNameAndCategory(@RequestParam(required = false) String name,
      @RequestParam(required = false) String category) {
    try {
      var courses = this.getAllCoursesByNameAndCategory.execute(name, category);
      return ResponseEntity.ok().body(courses);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }
}
