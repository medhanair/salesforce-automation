package com.herokuapp.theinternet;

public class testEmployeeMethods {

    public void testEmployee(){
        EmployeeTestClass employeeTestClass = new EmployeeTestClass("Medha","1234","34335354");
        employeeTestClass.setId("12344");
        String newId = employeeTestClass.getId();
    }
}
