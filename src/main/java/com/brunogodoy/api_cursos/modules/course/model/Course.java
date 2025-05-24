package com.brunogodoy.api_cursos.modules.course.model;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "course")
public class Course {

  public enum Status {
    ACTIVE("Ativo"),
    INACTIVE("Inativo");

    private String description;

    Status(String description) {
      this.description = description;
    }

    public String getDescription() {
      return description;
    }
  }

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @NotBlank(message = "O nome do curso é obrigatório")
  @Size(min = 5, max = 100, message = "O atributo nome deve ter no mínimo 5 e no máximo 100 caracteres!")
  private String name;

  @NotBlank(message = "A categoria do curso é obrigatória")
  @Size(min = 5, max = 1000, message = "O atributo categoria deve ter no mínimo 10 e no máximo 1000 caracteres!")
  private String category;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private Status status = Status.ACTIVE;

  @CreationTimestamp
  private LocalDateTime createdAt;

  @UpdateTimestamp
  private LocalDateTime updatedAt;
}
