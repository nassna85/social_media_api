package com.socialmedia.common;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GenericResponse {

    private String message;

    public GenericResponse(String message) {
        this.message = message;
    }
}
