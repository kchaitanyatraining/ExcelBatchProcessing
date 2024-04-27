package com.hdfc.service;

import com.hdfc.dao.EmployeeDao;
import com.hdfc.excelbatch.Processor;
import com.hdfc.exception.EmpException;
import com.hdfc.exception.EmpServiceExcetion;
import com.hdfc.model.Employee;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class EmployeeService {
    Logger log= LogManager.getLogger(EmployeeService.class);
     public void employeeProcess(List<Employee> emps) throws EmpServiceExcetion, EmpException {
        try {
            EmployeeDao empDao = new EmployeeDao();
            for (Employee emp : emps) {
                if(employeeValidation(emp)!=0){
                    updateEmployee(emp);
                }else{
                    empDao.saveEmployee(emp);
                }

            }
        }catch(NullPointerException e){
            log.error(e.getMessage());
            throw new EmpServiceExcetion("exceptin is in service class");
        }
    }


  private   int employeeValidation(Employee emp) throws EmpException {
        EmployeeDao empDao = new EmployeeDao();
       return empDao.getEmployee(emp);
    }

  private  void updateEmployee(Employee emp) throws EmpException {
        EmployeeDao empDao = new EmployeeDao();
        empDao.updateEmployee(emp);
    }


}
