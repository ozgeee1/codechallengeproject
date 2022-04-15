package com.javachallange.error;

import feign.Response;
import feign.RetryableException;
import feign.codec.ErrorDecoder;

public class FeignClientDecoder  implements ErrorDecoder {

    private final ErrorDecoder defaultErrorDecoder = new Default();

    
    @Override
    public Exception decode(String s, Response response) {
        Exception exception = defaultErrorDecoder.decode(s, response);

        if(exception instanceof RetryableException){
            return exception;
        }

            if (429 == response.status()) {
                System.out.println("Retrying status 429");
            return new RetryableException(429, response.reason(), response.request().httpMethod(), null, response.request());
        }
 

        return exception;
    }
}
