package com.brunogodoy.api_cursos.modules.course.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brunogodoy.api_cursos.modules.course.model.Course;

public interface CourseRepository extends JpaRepository<Course, UUID> {

  List<Course> findByCategoryContainingIgnoreCase(String category);

  List<Course> findByNameContainingIgnoreCase(String name);

  List<Course> findByNameContainingIgnoreCaseAndCategoryContainingIgnoreCase(String name, String category);

  Optional<Course> findByNameIgnoreCase(String name);
}
