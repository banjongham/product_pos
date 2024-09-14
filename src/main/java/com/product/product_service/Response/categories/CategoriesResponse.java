package com.product.product_service.Response.categories;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class CategoriesResponse {

    private String categoryName;
    private String categoryImage;
    private String active;
}
