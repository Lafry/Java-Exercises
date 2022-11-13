package Classes;

import java.util.Comparator;

public class Person {
    private Integer age;

    public final static Comparator<Person> comparatorByAge = (o1, o2) -> Integer.compare(o1.age, o2.age);
}
