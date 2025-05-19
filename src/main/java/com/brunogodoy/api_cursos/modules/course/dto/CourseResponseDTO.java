package com.brunogodoy.api_cursos.modules.course.dto;

import java.util.UUID;

import com.brunogodoy.api_cursos.modules.course.CourseEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseResponseDTO {

  private UUID id;
  private String name;
  private String category;
  private boolean active;

  public static CourseResponseDTO fromEntity(CourseEntity course) {
    return CourseResponseDTO.builder()
        .id(course.getId())
        .name(course.getName())
        .category(course.getCategory())
        .active(course.isActive())
        .build();
  }
}
