package com.socialmedia.error;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.Date;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ApiError {

    // private Long timestamp = new Date().getTime();
    Instant timestamp = Instant.now();

    private int statusCode;

    private String message;

    private String url;

    private Map<String, String> validationErrors;

    public ApiError(int statusCode, String message, String url) {
        this.statusCode = statusCode;
        this.message = message;
        this.url = url;
    }

}
