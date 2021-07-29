package com.vroong.album.api.error;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class FieldError implements Serializable {

  private static final long serialVersionUID = 1L;

  private final String objectName;
  private final String field;
  private final String message;

  public FieldError(String dto, String field, String message) {
    this.objectName = dto;
    this.field = field;
    this.message = message;
  }
}