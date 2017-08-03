package com.thoughtworks.petstore.web.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.petstore.web.exception.FeignClientException;
import com.thoughtworks.petstore.web.dto.vo.ExceptionVo;
import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class UserErrorDecoder implements ErrorDecoder {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Override
    public Exception decode(String methodKey, Response response) {

        ObjectMapper mapper = new ObjectMapper();
        ExceptionVo exceptionVo = null;
        try {
            exceptionVo = mapper.readValue(Util.toString(response.body().asReader()), ExceptionVo.class);
        } catch (IOException e) {
            log.error("Cannot parse response", e);
        }

        if (exceptionVo != null && response.status() >= 400 && response.status() < 500) {
            return new FeignClientException(exceptionVo.getCode(), exceptionVo.getMessage());
        }
        return feign.FeignException.errorStatus(methodKey, response);
    }
}