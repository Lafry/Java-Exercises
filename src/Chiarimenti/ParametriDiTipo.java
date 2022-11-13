package Chiarimenti;

import Classes.Employee;
import Classes.Manager;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ParametriDiTipo {
    static void foo(List<?> list){
        Object x = list.get(0);
        System.out.println("Object: " + x);
        // ERROR: list.add(x); - non posso aggiungere Object ad una lista di tipo sconosciuto
        list.add(null);
    }

    static <T> void boo(List<? extends Employee> list){
        Employee employee = list.get(0); //se passo una lista di manager posso assegnare un manager ad Employee
        // ERROR: list.add(employee); - Se la lista fosse di manager non potrei assegnare un employee
        list.add(null); // anche qui posso solo aggiungere null
    }

    static <T> void f(List<? super Employee> list){
        Object x = list.get(0); // posso leggere solo come Object
        list.add(new Employee("new_e", 10));  // posso aggiungere
        list.add(new Manager("new_m", 11, 1000));
        System.out.println(list);
    }

    static <T> void alfa(List<T> list){
        // posso passare qualsiasi cosa
        T t = list.get(0);
        System.out.println(t.getClass());   // Se passo lista di Employee stampa T, se lista di Manager stampa Manager
        list.add(t);
        // quindi a differenza di ? posso leggere come T e assegnare T
    }

    /**
     * T al posto di Employee per rendere il metodo generico
     * Vantaggio: lettura
     */
    static <T> void beta(List<? extends T> list){
        T x = list.get(0); // Posso leggere come supertipo visto che il sottotipo è assegnabile al supertipo
        //list.add(x);    // NO: list potrebbe essere di Managers e non posso assegnare un Employee ad un Manager
        list.add(null);
    }

    /**
     * Idem
     * Vantaggio: Scrittura
     */
    static <T> void gamma(List<? super T> list){
        Object x = list.get(0);  // Posso solo leggere come object
        // posso aggiungere in lista tutti i sottotipi di T
        // se ? è Employee posso aggiungere Employee? Si
        // se ? è Employee posso aggiungere Manager? Si
    }

    static <T> Set<T> intersection (Set<? extends T> a, Set<? extends T> b){
        Set<T> s = new HashSet<>();

        for(T element: a){
            System.out.println(b);
            if(b.contains(element)){
                s.add(element);
            }
        }
        return s;
    }

    /**
     * Vince questo perchè è più specifico il tipo di ritorno
     */
    static <T> Set<T> intersection_perfect (Set<T> a, Set<?> b){
        Set<T> s = new HashSet<>();

        for(T element: a){
            System.out.println(b);
            if(b.contains(element)){
                s.add(element);
            }
        }
        return s;
    }

    public static void main (String []args) {
        Employee e1 = new Employee("Pippo", 1);
        Employee e2 = new Employee("Pluto", 2);
        Employee e3 = new Employee("Paperino", 3);

        Manager m1 = new Manager("Topolino", 4, 100);
        Manager m2 = new Manager("Minnie", 5, 101);

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(e1);
        employeeList.add(e2);
        employeeList.add(e3);

        List<Manager> managerList = new ArrayList<>();
        managerList.add(m1);
        managerList.add(m2);
        /**
         * Non posso aggiungere un employee ad una lista di manager
         * Gli AL in java hanno un overhead di spazio: è salvato il tipo con cui sono stati dichiarti
         * Employee non è sottotipo di Manager e pertanto non è assegnabile
         */
        // ERROR: managerList.add(e1);

        // Questo invece è valido perchè manager è assegnabile ad Employee
        employeeList.add(m1);

        // Prova con i metodi:
        ParametriDiTipo.f(employeeList);

        ParametriDiTipo.alfa(employeeList);

        Set<String> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();
        s2.add(10);
        s2.add(15);
        s2.add(40);
        s2.add(30);
        Set<Integer> s3 = new HashSet<>();
        s3.add(25);
        s3.add(15);
        s3.add(30);

        Set<Object> result = ParametriDiTipo.intersection(s2, s3);
        System.out.println(result);

        Set<String> res = ParametriDiTipo.intersection_perfect(s1, s3);
    }
}
