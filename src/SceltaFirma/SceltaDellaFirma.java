package SceltaFirma;

import Classes.Employee;
import Classes.Manager;

import java.util.*;

public class SceltaDellaFirma {
    public static void main(String []args){
        //Main per CommonKeys
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("Primo", 1);
        map1.put("Secondo", 2);
        map1.put("Terzo", 3);

        Map <String, String> map2 = new HashMap<>();
        map2.put("Uno", "prima");
        map2.put("Due", "seconda");
        map2.put("Tre", "terza");
        map2.put("Primo", "primo");

        System.out.println(map1);
        System.out.println(map2);

        Set<?> set;
        set = commonKeys(map1, map2);
        System.out.println(set);

        //Main per findPrevious e isMax
        Set<Manager> managers = new HashSet<>();
        managers.add(new Manager("pippo", 23, 23));
        managers.add(new Manager("pluto", 25, 25));

        Set<Employee> employees = new HashSet<>();
        employees.add(new Employee("pippo", 23));
        employees.add(new Employee("pluto", 25));

        System.out.println(SceltaDellaFirma.<Employee> findPrevious(employees, Employee.c, new Manager("giuo", 24,12)));
        System.out.println(SceltaDellaFirma.<Employee> isMax( new Manager("giuo", 0, 2), Employee.c, employees));


        employees.add(new Employee("Pippo", 1));
        employees.add(new Employee("Giovanni", 2));
        employees.add(new Employee("Aldo", 5));
        employees.add(new Employee("Giacomo", 6));


        managers.add(new Manager("Pippo", 1, 2));
        managers.add(new Manager("Giovanni", 2, 3));
        managers.add(new Manager("Aldo", 5, 5));
        managers.add(new Manager("Giacomo", 6, 6));

        System.out.println(SceltaDellaFirma.<Manager> findNext(managers, Manager.c, new Manager("Marina", 4,2)));
    }


    public static <T> Set<?> commonKeys(Map<?,?> m1, Map<?,?> m2){
        HashSet<Object> result = new HashSet<>();

        for (Map.Entry<?,?> entry : m1.entrySet()) {
            for (Map.Entry<?,?> entry2 : m2.entrySet()) {
                if(entry.getKey().equals(entry2.getKey())){
                    result.add(entry.getKey());
                }
            }
        }
        return result;
    }

    public static <T> boolean isMax(T x, Comparator<? super T> c, Set<? extends T> set){
        for (T t: set) {
            if(c.compare(x,t)<=0) return false;
        }
        return true;
    }

    public <S,T> boolean sorted(Collection<S> s1, Comparator<T> c){
        List<S> list = (List<S>) s1;
        for(int i=0; i<s1.size();i++){
            S s_left = list.get(i);
            S s_right = list.get(i+1);
            //if(c.compare(s_left, s_right))
        }
        return true;
    }

    public void methodo(List<? super Employee> list){
        //SCRITTURA (? super Employee)
        list.add(new Manager("pietro", 344, 3456));
        //LETTURA (? extends Employee)
        //Employee e = list.get(3);
    }

    //La firma precedente era Collection<T>, e se T era Employee non accettava collezioni di tipo Manager
    public static <T> T findPrevious(Collection<? extends T> collection, Comparator<? super T> comp, T x) {

        ArrayList<T> list = new ArrayList<>(collection);
        /// aggiungo l'oggetto x
        list.add(x);
        // ordino la lista
        Collections.sort(list, comp);
        System.out.println(list);

        // Se l'oggetto x è più grande di tutti, è in fondo alla lista
        // l'oggetto più grande dell'insieme è il penultimo
        for(int i=0;i<list.size();i++){
            if(i>0){
                if(list.get(i).equals(x)){
                    return list.get(i-1);
                }
            }else{
                if(list.get(i).equals(x)){
                    return null;
                }
            }
        }
        return null;
    }

    public static <T> T findNext(Set<? extends T> coll, Comparator<? super T> comp, T x){
        //static <S,T extends S> T findNext(Set<T> coll, Comparator<S> comp, T x){

        ArrayList<T> list = new ArrayList<>(coll);
        list.sort(comp);
        for (T t: list) {
            System.out.println("Ciao sono t "+t);

            if(comp.compare(t,x)>0)
                return t;

        }
        return null;
    }

}


