package com.olshop.olshop.dto.params;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionParams {
    private int id;
    private int limit;
    private int userId;
    private String status;
}
