package com.hdfc.service;

import com.hdfc.dao.EmployeeDao;
import com.hdfc.model.Employee;

import java.util.List;

public class EmployeeService {

    public void saveEmployee(List<Employee> emps){
        EmployeeDao empDao=new EmployeeDao();
        for(Employee emp:emps){
            empDao.saveEmployee(emp);
        }
    }
}
