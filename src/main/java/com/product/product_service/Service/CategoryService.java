package com.product.product_service.Service;

import com.product.product_service.Common.Common;
import com.product.product_service.Entity.CategoriesEntity;
import com.product.product_service.Entity.ProductEntity;
import com.product.product_service.ExceptionHandler.ApiException;
import com.product.product_service.Model.ErrorCodes;
import com.product.product_service.Repository.CategoriesRepository;
import com.product.product_service.Request.Categories.CategoriesRequest;
import com.product.product_service.Request.ProductRequest;
import com.product.product_service.Response.ProductCommonResponse;
import com.product.product_service.Response.categories.CategoriesCommonResponse;
import com.product.product_service.Response.categories.CategoriesResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class CategoryService {

    private final Common common;

    public CategoryService(){
        this.common = new Common();
    }

    @Autowired
    CategoriesRepository categoriesRepository;

    public List<CategoriesResponse> getCategoryAll(){
        log.info("call method getCategoryAll");
        List<CategoriesResponse> listcategories = new ArrayList<>();
        try {
            List<CategoriesEntity> getallcategories = categoriesRepository.findAll();
            for (CategoriesEntity getallcategory : getallcategories) {
                CategoriesResponse categories = new CategoriesResponse();
                categories.setCategoryName(common.checkEmpty(getallcategory.getCategoryName()) ? getallcategory.getCategoryName() : "");
                categories.setCategoryImage(common.checkEmpty(getallcategory.getCategoryImage()) ? getallcategory.getCategoryImage() : "");
                categories.setActive(common.checkEmpty(getallcategory.getActive()) ? getallcategory.getActive() : "");
                listcategories.add(categories);
            }
            log.info("get categories all successful");
        } catch (Error e){
            log.error(e.getMessage(), e);
            throw new ApiException(ErrorCodes.SE00001 , e.getMessage());
        }
        return listcategories;
    }

    public List<CategoriesResponse> getCategoryById(@RequestParam Integer category_id){
        log.info("call method getCategoryById");
        List<CategoriesResponse> listcategories = new ArrayList<>();
        try {
            Optional<CategoriesEntity> getallcategories = categoriesRepository.findById(category_id);
                if (getallcategories.isPresent()) {
                    CategoriesResponse categories = new CategoriesResponse();
                    categories.setCategoryImage(common.checkEmpty(getallcategories.get().getCategoryName()) ? getallcategories.get().getCategoryName() : "");
                    categories.setCategoryImage(common.checkEmpty(getallcategories.get().getCategoryImage()) ? getallcategories.get().getCategoryImage() : "");
                    categories.setActive(common.checkEmpty(getallcategories.get().getActive()) ? getallcategories.get().getActive() : "");
                    listcategories.add(categories);
                }
            log.info("get categories by id successful");
        } catch (Error e){
            log.error(e.getMessage(), e);
            throw new ApiException(ErrorCodes.SE00001 , e.getMessage());
        }
        return listcategories;
    }

    @Transactional
    public CategoriesCommonResponse saveCategories(@RequestBody CategoriesRequest request){
        log.info("call method saveCategories by CategoriesName {}", request.getCategoriesName());
        CategoriesEntity categoriesEntity = new CategoriesEntity();
        CategoriesCommonResponse categoriesCommonResponse = new CategoriesCommonResponse();
        try {
            categoriesEntity.setCategoryName(common.checkEmpty(request.getCategoriesName()) ? request.getCategoriesName() : "");
            categoriesEntity.setCategoryImage(common.checkEmpty(request.getCategoriesImage()) ? request.getCategoriesImage() : "");
            categoriesEntity.setActive(common.checkEmpty(request.getActive()) ? request.getActive() : "T");
            categoriesEntity.setCreateBy(1);
            categoriesEntity.setCreateDate(new Date());

            categoriesRepository.save(categoriesEntity);

            categoriesCommonResponse.setReturnCode("200");
            categoriesCommonResponse.setReturnMessage("Insert CategoriesName Successful");
            log.info("insert CategoriesName {} successful", request.getCategoriesName());
        } catch (Exception e){
            log.error(e.getMessage(), e);
            throw new ApiException(ErrorCodes.SE00001 , e.getMessage());
        }

        return categoriesCommonResponse;
    }

    @Transactional
    public CategoriesCommonResponse updateCategories(@RequestBody CategoriesRequest request){
        log.info("call method updateCategories by sku {}", request.getCategoriesName());
        if(null == request.getCategoriesName() || request.getCategoriesName().isEmpty()) {
            log.error("Categories Name could not be null or empty {}", request.getCategoriesName());
            throw new ApiException(ErrorCodes.AP00002, "Categories Name could not be null or empty");
        }
        CategoriesCommonResponse categoriesCommonResponse = new CategoriesCommonResponse();
        try {
            Optional<CategoriesEntity> cetegoriesEntity = categoriesRepository.findById(request.getId());
            if (cetegoriesEntity.isPresent()) {
                cetegoriesEntity.get().setCategoryName(common.checkEmpty(request.getCategoriesName()) ? request.getCategoriesName() : "");
                cetegoriesEntity.get().setCategoryImage(common.checkEmpty(request.getCategoriesImage()) ? request.getCategoriesImage() : "");
                cetegoriesEntity.get().setActive(common.checkEmpty(request.getActive()) ? request.getActive() : "");
                cetegoriesEntity.get().setUpdateBy(1);
                cetegoriesEntity.get().setUpdateDate(new Date());
            }

            categoriesRepository.save(cetegoriesEntity.get());

            categoriesCommonResponse.setReturnCode("0001");
            categoriesCommonResponse.setReturnMessage("Update CategoriesName Successful");
            log.info("update product by CategoriesName {} successful", request.getCategoriesName());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ApiException(ErrorCodes.SE00001 , e.getMessage());
        }
        return categoriesCommonResponse;
    }

    @Transactional
    public CategoriesCommonResponse deleteCategories(@RequestBody CategoriesRequest request){
        log.info("call method deleteCategories by categoriesName {}", request.getCategoriesName());
        if(null == request.getCategoriesName() || request.getCategoriesName().isEmpty()){
            log.error("Categories Name could not be null or empty {}", request.getCategoriesName());
            throw new ApiException(ErrorCodes.AP00002, "Categories Name could not be null or empty");
        }
        CategoriesCommonResponse categoriesCommonResponse = new CategoriesCommonResponse();
        try {
            //categoriesRepository.deleteByCategoriesName(request.getCategoriesName());

            categoriesCommonResponse.setReturnCode("0001");
            categoriesCommonResponse.setReturnMessage("Delete Product Successful");
            log.info("delete categories by name {} successful", request.getCategoriesName());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ApiException(ErrorCodes.SE00001 , e.getMessage());
        }
        return categoriesCommonResponse;
    }
}
