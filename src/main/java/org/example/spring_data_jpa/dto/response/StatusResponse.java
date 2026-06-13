package org.example.spring_data_jpa.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import org.example.spring_data_jpa.constant.message.ResponseMessageConstant;

import java.io.Serializable;

public class StatusResponse implements Serializable {

  @Schema(example = "200")
  public int code;

  @Schema(example = "Success")
  public String message;

  public StatusResponse(int code, String message) {
    this.code = code;
    this.message = message != null ? message : ResponseMessageConstant.FAILED;
  }
}