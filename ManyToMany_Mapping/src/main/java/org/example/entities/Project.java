package org.example.entities;

import javax.persistence.*;

import java.util.List;
@Entity
public class Project {
    @Id
    private int pId;
    @Column(name = "project_name")
    private String pName;
    @ManyToMany
    @JoinTable(name = "employee_list")
    private List<Employee> employeeList;

    public Project(int pId,String pName,List<Employee> employeeList){
        super();
        this.pId=pId;
        this.pName=pName;
        this.employeeList=employeeList;
    }

    public Project(){
        super();
    }

    public int getpId(){
        return pId;
    }

    public void setpId(int pId){
        this.pId=pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
