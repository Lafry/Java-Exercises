package SceltaFirma;

/**
 * Implementare il metodo combine, che accetta due comparatori e li combina lessicograficamente,
 * ovvero restituisce un comparatore che, dati due oggetti, restituisce il valore del primo compara-
 * tore, se diverso da zero; altrimenti, restituisce il valore del secondo comparatore
 */

import Classes.Employee;
import Classes.Manager;
import Classes.Person;

import java.util.Comparator;

/**
 * a) <T> Comparator<T> combine(Comparator<T> a, Comparator<T> b)
 *      - Funzionale
 *      - Corretta
 *      - Non completa
 *      - Non offre ulteriori garanzie
 *      - Semplice
 * b) <T> Comparator<T> combine(Comparator<T> a, Comparator<?> b)
 *      - Non funzionale: non posso comparare con jolly
 * c) <S, T extends S, U extends S> Comparator<S> combine(Comparator<T> a, Comparator<U>
 *      - Funzionale
 *      - Corretta
 *      - Completa
 *      - Non offre ulteriori garanzie
 *      - L'avrei fatta più difficile
 * d) <T> Comparator<T> combine(Comparator<? super T> a, Comparator<? super T> b)
 *      - Non funzionale
 * e) <T> Comparator<T> combine(Comparator<Object> a, Comparator<Object> b)
 *      - Boh
 * f) <T> Comparator<? extends T> combine(Comparator<? super T> a, Comparator<? super T> b)
 *      - Non (dovrebbe) essere funzionale perchè ritorno
 */

public class Combine {

    /**
     * a return 0 -> ritorna il valore di b
     * a return 1/-1 -> ritorna 1/-1
     */
    public static <T> Comparator<? extends T> combine(Comparator<? super T> a, Comparator<? super T> b){
        return new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                if(a.compare(o1, o2) == 0) return b.compare(o1, o2);
                else return a.compare(o1, o2);
            }
        };
    }

    public static void main(String []args){
        Employee e1 = new Employee("Pippo", 100);
        Employee e2 = new Employee("Pluto", 200);
        Employee e3 = new Employee("Paperino", 300);

        System.out.println(Employee.c.compare(e2, e1));
        System.out.println(Employee.byName.compare(e2, e1));

        Comparator<? extends Employee> employeeComparator = combine(Person.comparatorByAge, Person.comparatorByAge);
    }
}
