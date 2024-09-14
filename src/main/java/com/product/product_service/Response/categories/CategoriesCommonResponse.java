package com.product.product_service.Response.categories;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoriesCommonResponse {

    @JsonProperty("returnCode")
    private String returnCode;

    @JsonProperty("returnMessage")
    private String returnMessage;
}
