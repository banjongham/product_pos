package com.product.product_service.Service;

import com.product.product_service.Common.Common;
import com.product.product_service.Entity.CustomerEntity;
import com.product.product_service.Entity.ProductEntity;
import com.product.product_service.ExceptionHandler.ApiException;
import com.product.product_service.Model.ErrorCodes;
import com.product.product_service.Repository.CustomerRepository;
import com.product.product_service.Request.CustomerRequest;
import com.product.product_service.Response.CustomerResponse;
import com.product.product_service.Response.ProductResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class CustomerService {

    private final Common common;

    @Autowired
    CustomerRepository customerRepository;

    public List<CustomerResponse> getCustomer(@RequestBody CustomerRequest request){
        log.info("call method getCustomerAll");
        List<CustomerResponse> listcustomers = new ArrayList<>();
        try {
            Optional<CustomerEntity> getcustomers = customerRepository.findByCustomerId(request.getCustomerId());
                CustomerResponse customers = new CustomerResponse();
                customers.setCustomerId("X101");
                customers.setCustomerName("NAME TEST");
                listcustomers.add(customers);
            log.info("get customer all successful");
        } catch (Error e){
            log.error(e.getMessage(), e);
            throw new ApiException(ErrorCodes.SE00001 , e.getMessage());
        }
        return listcustomers;
    }
}
