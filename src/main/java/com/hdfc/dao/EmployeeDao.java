package com.hdfc.dao;

import com.hdfc.exception.EmpException;
import com.hdfc.model.Employee;
import com.hdfc.service.EmployeeService;
import com.hdfc.util.DBConnection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class EmployeeDao {
    Logger log= LogManager.getLogger(EmployeeDao.class);

    public void saveEmployee(Employee emp) throws EmpException {
        Connection con=null;
        try {
             con= DBConnection.getConnection();
           PreparedStatement ps= con.prepareStatement("INSERT INTO EMPLOYEE VALUES(?,?,?,?,?)");
           ps.setInt(1,emp.getEmpId());
           ps.setString(2,emp.getFirstName());
            ps.setString(3,emp.getLastName());
            ps.setString(4,emp.getAddress());
            ps.setInt(5,emp.getSalary());
            ps.execute();

        } catch (SQLException e) {
            log.error(e.getMessage());
     throw new EmpException(e.getMessage());
        } finally {
            try {
                DBConnection.closeConnection();
            } catch (SQLException e) {
                log.error(e.getMessage());
            }
        }
    }

    public int getEmployee(Employee emp) throws EmpException {
        Connection con=null;
int empId=0;

        try {
            con= DBConnection.getConnection();
           PreparedStatement ps=  con.prepareStatement("select  emp_id from employee where emp_id=?");
           ps.setInt(1,emp.getEmpId());
          ResultSet rs= ps.executeQuery();

          while(rs.next()){
              empId=rs.getInt(1);
          }

        } catch (SQLException e) {
            log.error(e.getMessage());
            throw new EmpException(e.getMessage());
        } finally {
            try {
                DBConnection.closeConnection();
            } catch (SQLException e) {
                log.error(e.getMessage());
            }
        }

        return empId;
    }


    public void updateEmployee(Employee emp) throws EmpException {
        Connection con=null;
        try{
            con= DBConnection.getConnection();
            PreparedStatement ps=  con.prepareStatement("UPDATE EMPLOYEE SET  first_name=?,last_name=?,address=?,salary=? where emp_id=?");

            ps.setString(1,emp.getFirstName());
            ps.setString(2,emp.getLastName());
            ps.setString(3,emp.getAddress());
            ps.setInt(4,emp.getSalary());
            ps.setInt(5,emp.getEmpId());
            ps.execute();

        }catch (SQLException e) {
            log.error(e.getMessage());
            throw new EmpException(e.getMessage());
        } finally {
            try {
                DBConnection.closeConnection();
            } catch (SQLException e) {
                log.error(e.getMessage());
            }
        }
    }
}
