package com.product.product_service.Service;

import com.product.product_service.Common.Common;
import com.product.product_service.Entity.ProductEntity;
import com.product.product_service.ExceptionHandler.ApiException;
import com.product.product_service.Model.ErrorCodes;
import com.product.product_service.Repository.ProductRepository;
import com.product.product_service.Request.ProductRequest;
import com.product.product_service.Response.ProductCommonResponse;
import com.product.product_service.Response.ProductResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {

    private final Common common;

    @Autowired
    ProductRepository productRepository;

    public ProductService(){
        this.common = new Common();
    }

    public List<ProductResponse> getProductAll(){
        log.info("call method getProductAll");
        List<ProductResponse> listproducts = new ArrayList<>();
        try {
            List<ProductEntity> getallproducts = productRepository.findAll();
            for (ProductEntity getallproduct : getallproducts) {
                ProductResponse products = new ProductResponse();
                products.setId(common.checkEmpty(getallproduct.getId()) ? getallproduct.getId() : 0);
                products.setProductName(common.checkEmpty(getallproduct.getProductName()) ? getallproduct.getProductName() : "");
                products.setSku(common.checkEmpty(getallproduct.getProductSku()) ? getallproduct.getProductSku() : "");
                products.setPrice(common.checkEmpty(getallproduct.getProductPrice()) ? new BigDecimal(getallproduct.getProductPrice().toString()) : null);
                listproducts.add(products);
            }
            log.info("get product all successful");
        } catch (Error e){
            log.error(e.getMessage(), e);
            throw new ApiException(ErrorCodes.SE00001 , e.getMessage());
        }
        return listproducts;
    }

    @Transactional
    public ProductCommonResponse saveProduct(@RequestBody ProductRequest request){
        log.info("call method saveProduct by sku {}", request.getSku());
        ProductEntity productEntity = new ProductEntity();
        ProductCommonResponse productCommonResponse = new ProductCommonResponse();
        try {
            productEntity.setProductName(common.checkEmpty(request.getProductName()) ? request.getProductName() : "");
            productEntity.setProductSku(common.checkEmpty(request.getSku()) ? request.getSku() : "");
            productEntity.setProductPrice(common.checkEmpty(request.getPrice()) ? request.getPrice() : new BigDecimal(0.00));

            productRepository.save(productEntity);

            productCommonResponse.setReturnCode("200");
            productCommonResponse.setReturnMessage("Insert Product Successful");
            log.info("insert product by sku {} successful", request.getSku());
        } catch (Exception e){
            log.error(e.getMessage(), e);
            throw new ApiException(ErrorCodes.SE00001 , e.getMessage());
        }

        return productCommonResponse;
    }

    @Transactional
    public ProductCommonResponse updateProduct(@RequestBody ProductRequest request){
        log.info("call method updateProduct by sku {}", request.getSku());
        if(null == request.getSku() || request.getSku().isEmpty()) {
            log.error("Sku Product could not be null or empty {}", request.getSku());
            throw new ApiException(ErrorCodes.AP00002, "Sku Product could not be null or empty");
        }
        ProductCommonResponse productCommonResponse = new ProductCommonResponse();
        try {
            Optional<ProductEntity> productEntity = productRepository.findById(request.getId());
            if (productEntity.isPresent()) {
                productEntity.get().setProductName(common.checkEmpty(request.getProductName()) ? request.getProductName() : "");
                productEntity.get().setProductSku(common.checkEmpty(request.getSku()) ? request.getSku() : "");
                productEntity.get().setProductPrice(common.checkEmpty(request.getPrice()) ? new BigDecimal(request.getPrice().toString()) : null);
            }

            productRepository.save(productEntity.get());

            productCommonResponse.setReturnCode("0001");
            productCommonResponse.setReturnMessage("Update Product Successful");
            log.info("update product by sku {} successful", request.getSku());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ApiException(ErrorCodes.SE00001 , e.getMessage());
        }
        return productCommonResponse;
    }

    @Transactional
    public ProductCommonResponse deleteProduct(@RequestBody ProductRequest request){
        log.info("call method updateProduct by sku {}", request.getSku());
        if(null == request.getSku() || request.getSku().isEmpty()){
            log.error("Sku Product could not be null or empty {}", request.getSku());
            throw new ApiException(ErrorCodes.AP00002, "Sku Product could not be null or empty");
        }
        ProductCommonResponse productCommonResponse = new ProductCommonResponse();
        try {
            productRepository.deleteById((long) request.getId());

            productCommonResponse.setReturnCode("0001");
            productCommonResponse.setReturnMessage("Delete Product Successful");
            log.info("delete product by sku {} successful", request.getSku());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ApiException(ErrorCodes.SE00001 , e.getMessage());
        }
        return productCommonResponse;
    }


}
