package com.brunogodoy.api_cursos.modules.course.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.brunogodoy.api_cursos.modules.course.dto.CourseUpdateDTO;
import com.brunogodoy.api_cursos.modules.course.model.Course;
import com.brunogodoy.api_cursos.modules.course.repository.CourseRepository;

@Service
public class CourseService {

  @Autowired
  private CourseRepository courseRepository;

  public List<Course> getAll() {
    return courseRepository.findAll();
  }

  public List<Course> getByName(String name) {
    return courseRepository.findByNameContainingIgnoreCase(name);
  }

  public List<Course> getByCategory(String category) {
    return courseRepository.findByCategoryContainingIgnoreCase(category);
  }

  public List<Course> getByNameAndCategory(String name, String category) {
    return courseRepository.findByNameContainingIgnoreCaseAndCategoryContainingIgnoreCase(name, category);
  }

  public Course create(Course course) {
    this.courseRepository.findByNameIgnoreCase(course.getName())
        .ifPresent(existingCourse -> {
          throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Curso com o mesmo nome cadastrado já existe!");
        });

    return courseRepository.save(course);
  }

  public Course update(UUID id, CourseUpdateDTO dto) {
    Course courseFromDB = this.courseRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Curso não encontrado para atualização!"));

    if (dto.getName() != null) {
      this.courseRepository.findByNameIgnoreCase(dto.getName())
          .ifPresent(courseWithSameName -> {
            if (!courseWithSameName.getId().equals(courseFromDB.getId())) {
              throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                  "O nome '" + dto.getName() + "' já está em uso por outro curso.");
            }
          });
      courseFromDB.setName(dto.getName());
    }

    if (dto.getCategory() != null) {
      courseFromDB.setCategory(dto.getCategory());
    }

    return courseRepository.save(courseFromDB);
  }

  public void delete(UUID id) {

    if (!courseRepository.existsById(id))
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Curso não encontrado");

    courseRepository.deleteById(id);
  }

  public Course toggleStatus(UUID id) {
    Course courseFromDB = this.courseRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Curso não encontrado para atualização!"));

    Course.Status newStatus = courseFromDB.getStatus() == Course.Status.ACTIVE
        ? Course.Status.INACTIVE
        : Course.Status.ACTIVE;

    courseFromDB.setStatus(newStatus);

    return this.courseRepository.save(courseFromDB);
  }
}
