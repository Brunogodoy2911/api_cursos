package com.brunogodoy.api_cursos.modules.course.useCases;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brunogodoy.api_cursos.modules.course.CourseRepository;
import com.brunogodoy.api_cursos.modules.course.dto.CourseResponseDTO;

@Service
public class GetAllCoursesUseCase {

  @Autowired
  private CourseRepository courseRepository;

  public List<CourseResponseDTO> execute() {
    var courses = courseRepository.findAll();

    return courses.stream().map(course -> CourseResponseDTO.builder()
        .id(course.getId())
        .name(course.getName())
        .category(course.getCategory())
        .active(course.isActive())
        .build()).collect(Collectors.toList());
  }
}
