package org.example.spring_data_jpa.utils;

import lombok.NoArgsConstructor;
import org.example.spring_data_jpa.constant.message.ResponseMessageConstant;
import org.example.spring_data_jpa.dto.response.StatusResponse;
import org.springframework.http.HttpStatusCode;

@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class StatusResponseUtils {
  public static StatusResponse createStatusResponse(HttpStatusCode status, String message) {
    return new StatusResponse(
        (short) status.value(), message != null ? message : ResponseMessageConstant.FAILED);
  }
}