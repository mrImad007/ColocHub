package com.project.colochub.Exceptions.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiError {
    private String errorMessage;
    private String errorCode;
}
