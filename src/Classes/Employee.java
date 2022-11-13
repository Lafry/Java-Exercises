package Classes;

import java.util.Comparator;
import java.util.Objects;

public class Employee extends Person{
    private String name;
    private Integer salary;

    public Employee(String name, Integer salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public static final Comparator<Employee> c = (o1, o2) -> o1.salary.compareTo(o2.salary);

    public static final Comparator<Employee> byName = (o1, o2) -> o1.name.compareTo(o2.name);


    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary='" + salary + '\'' +
                '}';
    }
}
