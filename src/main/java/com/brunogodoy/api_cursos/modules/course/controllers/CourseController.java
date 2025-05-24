package com.brunogodoy.api_cursos.modules.course.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.brunogodoy.api_cursos.modules.course.dto.CourseUpdateDTO;
import com.brunogodoy.api_cursos.modules.course.model.Course;
import com.brunogodoy.api_cursos.modules.course.service.CourseService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/courses")
public class CourseController {

  @Autowired
  private CourseService courseService;

  @PostMapping
  public ResponseEntity<Course> create(@Valid @RequestBody Course course) {
    Course newCourse = this.courseService.create(course);
    return ResponseEntity.status(HttpStatus.CREATED).body(newCourse);
  }

  @GetMapping
  public ResponseEntity<List<Course>> getAll() {
    return ResponseEntity.ok(courseService.getAll());
  }

  @GetMapping("/search")
  public ResponseEntity<List<Course>> searchCourses(
      @RequestParam(required = false) String name,
      @RequestParam(required = false) String category) {

    if (name != null && category != null) {
      return ResponseEntity.ok(courseService.getByNameAndCategory(name, category));
    } else if (name != null) {
      return ResponseEntity.ok(courseService.getByName(name));
    } else if (category != null) {
      return ResponseEntity.ok(courseService.getByCategory(category));
    } else {
      return ResponseEntity.ok(courseService.getAll());
    }
  }

  @PutMapping("/{id}")
  public ResponseEntity<Course> update(@PathVariable UUID id, @Valid @RequestBody CourseUpdateDTO dto) {
    return ResponseEntity.ok(courseService.update(id, dto));
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable UUID id) {

    courseService.delete(id);
  }

  @PatchMapping("/{id}/toggle-active")
  public ResponseEntity<Course> toggleActive(@PathVariable UUID id) {
    Course updatedCourse = this.courseService.toggleStatus(id);
    return ResponseEntity.ok(updatedCourse);
  }
}
