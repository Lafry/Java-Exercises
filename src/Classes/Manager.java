package Classes;

import java.util.Comparator;

public class Manager extends Employee {
    private Integer bonus;

    public Manager(String name, Integer salary, Integer bonus) {
        super(name, salary);
        this.bonus = bonus;
    }

    public static final Comparator<Manager> byBonus = new Comparator<Manager>() {
        @Override
        public int compare(Manager o1, Manager o2) {
            return Integer.compare(o1.bonus, o2.bonus);
        }
    };

    @Override
    public String toString() {
        return "Manager{" +
                "bonus=" + bonus +
                '}';
    }
}
