package model;

public class DeepCloneEmployee implements Cloneable {
    private int empId;
    private String empName;
    private DeepDepartment department;

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public DeepDepartment getDepartment() {
        return department;
    }

    public void setDepartment(DeepDepartment department) {
        this.department = department;
    }

    public DeepCloneEmployee(int empId, String empName, DeepDepartment department) {
        super();
        this.empId = empId;
        this.empName = empName;
        this.department = department;
    }

    public Object clone() throws CloneNotSupportedException {
        DeepCloneEmployee employee_2 = (DeepCloneEmployee) super.clone();
        employee_2.setDepartment((DeepDepartment) employee_2.getDepartment().clone());
        return employee_2;
    }

    @Override
    public String toString() {
        return "Employee [empId=" + empId + ", empName=" + empName + ", department=" + department.getDeptName() + "]";
    }
}
