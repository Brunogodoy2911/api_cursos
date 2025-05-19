package com.brunogodoy.api_cursos.modules.course.useCases;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brunogodoy.api_cursos.modules.course.CourseRepository;
import com.brunogodoy.api_cursos.modules.course.dto.CourseResponseDTO;

@Service
public class GetAllCoursesByNameAndCategory {

  @Autowired
  private CourseRepository courseRepository;

  public List<CourseResponseDTO> execute(String name, String category) {
    var courses = courseRepository.findAll();

    return courses.stream()
        .filter(course -> (name == null || course.getName().equalsIgnoreCase(name))
            && (category == null || course.getCategory().equalsIgnoreCase(category)))
        .map(CourseResponseDTO::fromEntity)
        .collect(Collectors.toList());
  }
}
