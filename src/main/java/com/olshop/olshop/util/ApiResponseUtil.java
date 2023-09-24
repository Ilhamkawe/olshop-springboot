package com.olshop.olshop.util;

import com.olshop.olshop.dto.resbody.common.BaseResponse;
import com.olshop.olshop.dto.resbody.common.MetaResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ApiResponseUtil {
    public static ResponseEntity<BaseResponse<?>> ErrorHandler(Exception exception, HttpStatus status, String message) {
        return ResponseEntity.status(status)
                .body(BaseResponse.builder()
                        .meta(new MetaResponse(status.value(), status.name(), message))
                        .data(exception)
                        .build());
    }

    public static ResponseEntity<BaseResponse<?>> SuccessHandler(Object data, String message) {
        return ResponseEntity.ok(BaseResponse
                .builder()
                .meta(new MetaResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), message))
                .data(data)
                .build());
    }
}
