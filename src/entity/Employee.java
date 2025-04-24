package entity;

import java.io.Serializable;

public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    private String empId;
    private String name;
    private String designation;
    transient private int jobLevel;
    private Address address;

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public int getJobLevel() {
        return jobLevel;
    }

    public void setJobLevel(int jobLevel) {
        this.jobLevel = jobLevel;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Employee(String empId, String name, String designation, int jobLevel) {
        super();
        this.empId = empId;
        this.name = name;
        this.designation = designation;
        this.jobLevel = jobLevel;
    }

    public Employee(String empId, String name, String designation, int jobLevel, Address address) {
        super();
        this.empId = empId;
        this.name = name;
        this.designation = designation;
        this.jobLevel = jobLevel;
        this.address = address;
    }

    public static Employee copyEmployee(Employee employee) {
        Employee newEmployee = new Employee();
        newEmployee.setName(employee.getName());
        newEmployee.setJobLevel(employee.getJobLevel());
        newEmployee.address = employee.address;
        newEmployee.setDesignation(employee.getDesignation());
        return newEmployee;
    }

    public Employee() {
    }

    @Override
    public String toString() {
        return "Employee [empId=" + empId + ", name=" + name + ", designation=" + designation + ", address="
                + address.getCity() + " " + address.getPinCode()
                + "]";
    }

}
