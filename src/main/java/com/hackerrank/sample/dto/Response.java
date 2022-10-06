package com.hackerrank.sample.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@NoArgsConstructor
@Data
public class Response {
    private String message;
    private HttpStatus code;
    private Object data;

    public Response(String message, HttpStatus code, Object data) {
        this.message = message;
        this.code = code;
        this.data = data;
    }

}
