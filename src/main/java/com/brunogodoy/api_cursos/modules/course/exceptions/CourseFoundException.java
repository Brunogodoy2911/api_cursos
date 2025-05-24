package com.brunogodoy.api_cursos.modules.course.exceptions;

public class CourseFoundException extends RuntimeException {
  private static final long serialVersionUID = 1L;

  public CourseFoundException(String message) {
    super(message);
  }

  public CourseFoundException(String message, Throwable cause) {
    super(message, cause);
  }

  public CourseFoundException(Throwable cause) {
    super(cause);
  }
}
