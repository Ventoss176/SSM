package com.ventoss.crud.bean;

import com.ventoss.crud.service.DepartmentService;
import com.ventoss.crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.Pattern;

public class Employee {

    @Autowired
    DepartmentService departmentService;

    private Integer empId;


    @Pattern(regexp="(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})"
            ,message="用户名必须是2-5位中文或者6-16位英文和数字的组合")
    private String empName;

    private String gender;


    //@Email
    @Pattern(regexp="^([a-z0-9_\\.-]+)@([\\da-z\\.-]+)\\.([a-z\\.]{2,6})$",
            message="邮箱格式不正确")
    private String email;

    private Integer dId;

    private Department department;

    public Employee() {
        super();
    }

    public Employee(Integer empId, String empName, String gender, String email, Department department) {
        this.empId = empId;
        this.empName = empName;
        this.gender = gender;
        this.email = email;
        this.department = department;
        this.dId = department.getDeptId();
    }

    public Employee(Integer empId, String empName, String gender, String email, Integer dId) {
        this.empId = empId;
        this.empName = empName;
        this.gender = gender;
        this.email = email;
        this.dId = dId;
        Department dept = departmentService.getDept(dId);
        this.department = dept;
    }

    public Department getDepartment() {
        getdId();
        return department;
    }

    public void setDepartment(Department department) {
        setdId(department.getDeptId());
        this.department = department;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName == null ? null : empName.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", dId=" + dId +
                '}';
    }
}