package org.example.entities;

import javax.persistence.*;

import java.util.List;

@Entity
@Table(name="emp_details")
public class Employee {
    @Id
    private int eId;
    private String eName;
    @ManyToMany(mappedBy = "employeeList")
    private List<Project> projectList;

    public Employee(int eId, String eName, List<Project> projectList) {
        super();
        this.eId = eId;
        this.eName = eName;
        this.projectList = projectList;
    }

    public Employee(){
        super();
    }

    public int geteId() {
        return eId;
    }

    public void seteId(int eId) {
        this.eId = eId;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }
}
