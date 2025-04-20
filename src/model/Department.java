package model;

public class Department {
    private String deptName;

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Department(String deptName) {
        super();
        this.deptName = deptName;
    }

}
