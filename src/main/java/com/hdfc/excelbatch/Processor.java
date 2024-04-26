package com.hdfc.excelbatch;

import com.hdfc.exception.EmpDbException;
import com.hdfc.model.Employee;
import com.hdfc.service.EmployeeService;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Processor {

    private static Workbook wbook;


    public List<Employee> readExcelData() {
        String excelPath = "D:\\workspace-proj\\employee.xlsx";


        List<Employee> listEmployee = null;
        try {
            FileInputStream fis = new FileInputStream(excelPath);
            Workbook wbook = WorkbookFactory.create(fis);
            Sheet sheet = wbook.getSheet("employee");
            listEmployee = new ArrayList<Employee>();
            for (Row row : sheet) {
                if (row.getRowNum() != 0) {
                    Employee emp = new Employee();
                    emp.setEmpId((int) row.getCell(0).getNumericCellValue());
                    emp.setFirstName(row.getCell(1).getStringCellValue());
                    emp.setLastName(row.getCell(2).getStringCellValue());
                    emp.setAddress(row.getCell(3).getStringCellValue());
                    emp.setSalary((int) row.getCell(4).getNumericCellValue());
                    listEmployee.add(emp);
                }

            }


        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }
        return listEmployee;
    }

    public void writeIntoDB(List<Employee> emps) throws EmpDbException {
        EmployeeService service = new EmployeeService();
        service.saveEmployee(emps);
    }

    public static void main(String[] args) {
        Processor processor = new Processor();

        try {
            List<Employee> emps = processor.readExcelData();
            processor.writeIntoDB(emps);
        } catch (EmpDbException e) {
            throw new RuntimeException(e);
        }

    }

}
