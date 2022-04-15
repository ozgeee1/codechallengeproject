package com.javachallange.error;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiError {

    private int status;
    private String message;
    private String path;


    public ApiError(int status,String message,String path){
        this.status = status;
        this.message = message;
        this.path = path;
    }
}
