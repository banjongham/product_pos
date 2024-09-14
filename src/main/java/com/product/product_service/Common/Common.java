package com.product.product_service.Common;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Date;

@Component
public class Common {

    public Boolean checkEmpty(Object data_rq) {
        Boolean response = true;
        if (null == data_rq || "".equals(data_rq)) {
            response = false;
        }
        return response;
    }

    public Boolean checkNotEmpty(Object data_rq) {
        Boolean response = false;
        if (null == data_rq || "".equals(data_rq)) {
            response = true;
        }
        return response;
    }

    public Boolean checkEmptyDate(Date data_rq) {
        Boolean response = true;
        if (null == data_rq) {
            response = false;
        }
        return response;
    }

    public Boolean checkNotEmptyInteger(Integer data_rq) {
        Boolean response = false;
        if (null == data_rq) {
            response = true;
        }
        return response;
    }

    public Boolean checkNotEmptyDecimal(BigDecimal rq){
        if (rq.signum() == 0) {
            return true;
        }
        return false;
    }
}
