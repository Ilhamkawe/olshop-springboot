package com.olshop.olshop.dto.resbody.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MetaResponse {
    private int code;
    private String status;
    private String message;
}
