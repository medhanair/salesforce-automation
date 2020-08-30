package com.herokuapp.theinternet;

public class EmployeeTestClass {
    private String name;
    private String id;
    private String msisdn;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EmployeeTestClass(String name, String id, String msisdn) {
        this.name = name;
        this.id = id;
        this.msisdn = msisdn;
    }

    public String getId() {
        return id;
    }

    public void setId(String testid) {
        id = testid;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }
}
