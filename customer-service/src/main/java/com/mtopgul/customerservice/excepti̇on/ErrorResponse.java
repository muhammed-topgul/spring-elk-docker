package com.mtopgul.customerservice.excepti̇on;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Map;

/**
 * @author muhammed-topgul
 * @since 17/11/2023 12:48
 */
@Getter
@Setter
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ErrorResponse {
    private String apiPath;
    private int statusCode;
    private String statusMessage;
    private Date errorTime;
    private String exceptionClass;
    private Map<String, String> errors;

    private ErrorResponse(String apiPath, int statusCode, String statusMessage, Date errorTime) {
        this.apiPath = apiPath;
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
        this.errorTime = errorTime;
    }

    public static ErrorResponse newError(String apiPath, int statusCode, String statusMessage, Date errorTime) {
        return new ErrorResponse(apiPath, statusCode, statusMessage, errorTime);
    }
}
