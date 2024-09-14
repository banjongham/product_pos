package com.product.product_service.Response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductCommonResponse {

    @JsonProperty("returnCode")
    private String returnCode;

    @JsonProperty("returnMessage")
    private String returnMessage;

}
