package model;

public class DeepDepartment implements Cloneable {
    private String deptName;

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public DeepDepartment(String deptName) {
        super();
        this.deptName = deptName;
    }

    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
