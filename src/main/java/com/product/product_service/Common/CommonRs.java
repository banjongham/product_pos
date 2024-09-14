package com.product.product_service.Common;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class CommonRs<T> implements Serializable {

    private T data;
    private String code = "0000";
    private String message = "Successful";
}
