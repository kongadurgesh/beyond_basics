package entity;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ObjectStreamTester {
    @SuppressWarnings("unchecked")
    public void test() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(
                "C:\\Users\\konga\\Study\\LEX\\Java_Beyond_Basics\\beyond_basics\\src\\entity\\Employee.txt"));
                ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(
                        "C:\\Users\\konga\\Study\\LEX\\Java_Beyond_Basics\\beyond_basics\\src\\entity\\Employee.txt"))) {
            Employee employee = new Employee("1234", "John", "SE", 3);
            outputStream.writeObject(employee);

            Employee employee2 = (Employee) inputStream.readObject();
            System.out.println(employee2);

            // Use this code for collection serialization

            Employee eDTO = new Employee("1234", "John", "SE", 3, new Address("blr", 560076));
            Employee eDTO1 = new Employee("1235", "Robert", "SSE", 3, new Address("chn", 600017));
            Employee eDTO2 = new Employee("1235", "Nick", "TA", 4, new Address("hyd", 500008));
            ArrayList<Employee> emp = new ArrayList<>();
            emp.add(eDTO);
            emp.add(eDTO1);
            emp.add(eDTO2);
            outputStream.writeObject(emp);
            ArrayList<Employee> emp1 = (ArrayList<Employee>) inputStream.readObject();
            for (Employee Employee : emp1) {
                System.out.println(Employee);
            }
        } catch (Exception e) {
            System.out.println("Exception Occured");
        }
    }
}
