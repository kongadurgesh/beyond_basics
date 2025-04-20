package entity;

public class ObjectCloner {
    public void test() {
        Employee employee_1 = new Employee("124", "JOhn", "SSE", 1, new Address("Hyd", 123456));

        Employee employee_2 = Employee.copyEmployee(employee_1);

        System.out.println(employee_1.toString());
        System.out.println(employee_2.toString());

        employee_2.setName("Tim");
        System.out.println(employee_1.toString());
        System.out.println(employee_2.toString());

        employee_2.getAddress().setCity("USA");
        System.out.println(employee_1.toString());
        System.out.println(employee_2.toString());
    }
}
