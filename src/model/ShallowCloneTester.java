package model;

public class ShallowCloneTester {
    public void test() throws CloneNotSupportedException {
        Employee employee_1 = new Employee(1002, "John", new Department("ETA"));

        Employee employee_2 = (Employee) employee_1.clone();

        System.out.println(employee_1.toString());
        System.out.println(employee_2.toString());

        employee_2.setEmpName("Rick");
        employee_2.getDepartment().setDeptName("ADM");

        System.out.println(employee_1.toString());
        System.out.println(employee_2.toString());

    }
}
