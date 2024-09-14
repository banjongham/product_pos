package com.product.product_service.Controller;

import com.product.product_service.Common.CommonRs;
import com.product.product_service.Request.Categories.CategoriesRequest;
import com.product.product_service.Request.ProductRequest;
import com.product.product_service.Response.ProductCommonResponse;
import com.product.product_service.Response.categories.CategoriesCommonResponse;
import com.product.product_service.Response.categories.CategoriesResponse;
import com.product.product_service.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "v1/categories")
public class CategoriesController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/all")
    public ResponseEntity<CommonRs<List<CategoriesResponse>>> getCategoryAll() {
        CommonRs<List<CategoriesResponse>> categoryResponse = new CommonRs<>();
        categoryResponse.setData(categoryService.getCategoryAll());
        return ResponseEntity.ok(categoryResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommonRs<List<CategoriesResponse>>> getCategoryById(@RequestParam Integer category_id){
        CommonRs<List<CategoriesResponse>> categoryResponse = new CommonRs<>();
        categoryResponse.setData(categoryService.getCategoryById(category_id));
        return ResponseEntity.ok(categoryResponse);
    }

    @PostMapping("/save")
    public CategoriesCommonResponse saveCategories(@RequestBody CategoriesRequest request){
        return categoryService.saveCategories(request);
    }

    @PostMapping("/update")
    public CategoriesCommonResponse updateCategories(@RequestBody CategoriesRequest request){
        return categoryService.updateCategories(request);
    }

    @PostMapping("/delete")
    public CategoriesCommonResponse deleteCategories(@RequestBody CategoriesRequest request){
        return categoryService.deleteCategories(request);
    }
}
