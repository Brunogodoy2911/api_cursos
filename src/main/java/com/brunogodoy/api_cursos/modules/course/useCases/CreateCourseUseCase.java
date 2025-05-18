package com.brunogodoy.api_cursos.modules.course.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brunogodoy.api_cursos.modules.course.CourseEntity;
import com.brunogodoy.api_cursos.modules.course.CourseRepository;
import com.brunogodoy.api_cursos.modules.course.exceptions.CourseFoundException;

@Service
public class CreateCourseUseCase {

  @Autowired
  private CourseRepository courseRepository;

  public CourseEntity execute(CourseEntity courseEntity) {
    this.courseRepository.findByName(courseEntity.getName()).ifPresent((course) -> {
      throw new CourseFoundException("Curso já existente!");
    });
    return this.courseRepository.save(courseEntity);
  }
}
