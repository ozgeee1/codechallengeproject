package com.javachallange.error;

import org.springframework.boot.web.servlet.error.ErrorController;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@RestController
public class ErrorHandler  implements ErrorController {

    @Autowired
    private ErrorAttributes errorAttributes;


    @RequestMapping("/error")
    public ApiError handleError(WebRequest webRequest){
        Map<String,Object> attributes = this.errorAttributes.getErrorAttributes(webRequest, ErrorAttributeOptions.of(ErrorAttributeOptions.Include.BINDING_ERRORS,ErrorAttributeOptions.Include.MESSAGE));
        String message = (String) attributes.get("message");
        String path = (String) attributes.get("path");
        Integer  status = (Integer) attributes.get("status");
        ApiError error = new ApiError(status,message,path);
        return error;
    }



    @Override
    public String getErrorPath() {
        return "/error";
    }
    
}
