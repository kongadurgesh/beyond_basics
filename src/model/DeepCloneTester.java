package model;

public class DeepCloneTester {
    public void test() throws CloneNotSupportedException {
        DeepCloneEmployee employee_1 = new DeepCloneEmployee(1234, "Jack", new DeepDepartment("ETA"));

        DeepCloneEmployee employee_2 = (DeepCloneEmployee) employee_1.clone();

        System.out.println(employee_1.toString());
        System.out.println(employee_2.toString());

        employee_2.setEmpName("Rick");
        employee_2.getDepartment().setDeptName("HR");

        System.out.println(employee_1.toString());
        System.out.println(employee_2.toString());

    }
}
