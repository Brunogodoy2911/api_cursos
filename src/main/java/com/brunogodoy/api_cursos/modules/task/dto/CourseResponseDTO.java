package com.brunogodoy.api_cursos.modules.task.dto;

import java.util.UUID;

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
}
