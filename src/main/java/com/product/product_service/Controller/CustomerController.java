package com.product.product_service.Controller;

import com.product.product_service.Common.CommonRs;
import com.product.product_service.Request.CustomerRequest;
import com.product.product_service.Response.CustomerResponse;
import com.product.product_service.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "v1")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/getCustomer")
    public ResponseEntity<CommonRs<List<CustomerResponse>>> getCustomerAll(@RequestBody CustomerRequest request) {
        CommonRs<List<CustomerResponse>> productResponse = new CommonRs<>();
        productResponse.setData(customerService.getCustomer(request));
        return ResponseEntity.ok(productResponse);
    }
}
