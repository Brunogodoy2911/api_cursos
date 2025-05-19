package com.brunogodoy.api_cursos.modules.course;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<CourseEntity, UUID> {

  Optional<CourseEntity> findByNameAndCategory(String name, String category);

  Optional<CourseEntity> findByName(String name);
}
