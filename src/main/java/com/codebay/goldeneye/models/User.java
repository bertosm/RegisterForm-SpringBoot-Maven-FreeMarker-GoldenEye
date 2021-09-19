package com.codebay.goldeneye.models;

import javax.validation.constraints.NotEmpty;

public class User {
    
    private final String companyDomain = "goldenEye.com";

    @NotEmpty
    private String name;
    
    @NotEmpty
    private String surname;
    private String department;
    private String office;
    private String email;


    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getOffice() {
        return office;
    }
  
    public String getDepartment() {
        return department;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void generateEmail(){

        this.email  = (this.name.charAt(0) + this.surname.replace(" ", "") + "." + this.department.replace(" ", "") + "@" + this.office.replace(" ", "") + "." + this.companyDomain).toLowerCase();
    }

    

}
