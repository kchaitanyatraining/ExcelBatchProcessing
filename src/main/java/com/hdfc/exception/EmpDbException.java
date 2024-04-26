package com.hdfc.exception;

import com.hdfc.service.EmployeeService;

public class EmpDbException extends Exception{

    public EmpDbException(String msg){
        super(msg);
    }
}
