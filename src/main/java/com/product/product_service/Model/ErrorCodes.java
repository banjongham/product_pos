package com.product.product_service.Model;

public enum ErrorCodes {

    SE00001("Internal System Error"),
    SE00002("ระบบไม่สามารถดำเนินการได้ <br> กรุณาตรวจสอบข้อมูลเพื่อทำรายการใหม่อีกครั้งหรือติดต่อผู้ดูแลระบบ"),

    // BE
    BE00001("Data not found"),

    // AP
    AP00001("xxx"),

    //Bond Service
    DBT001("Transaction Fail"),

    DBT002("Transaction Duplicate"),

    AP00002("bad request"),

    RQ0001("ข้อมูลไม่สมบูรณ์ กรุณาตรวจสอบข้อมูล ({}) อีกครั้ง");

    private String message;

    ErrorCodes(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
