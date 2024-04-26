package com.hdfc.dao;

import com.hdfc.exception.EmpDbException;
import com.hdfc.model.Employee;
import com.hdfc.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class EmployeeDao {


    public void saveEmployee(Employee emp) throws EmpDbException {

        try {
            Connection con= DBConnection.getConnection();
           PreparedStatement ps= con.prepareStatement("INSERT INTO EMPLOYEE VALUES(?,?,?,?,?,?)");
           ps.setInt(1,emp.getEmpId());
           ps.setString(2,emp.getFirstName());
            ps.setString(3,emp.getLastName());
            ps.setString(4,emp.getAddress());
            ps.setInt(5,emp.getSalary());
            ps.execute();

        } catch (SQLException e) {
           throw new EmpDbException(e.getMessage());
        }
    }
}
