package Collezioni;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Realizzare la classe SortedList, che rappresenta una lista di oggetti dotati di ordinamento naturale.
 * Come una normale lista, una SortedList accetta duplicati. Inoltre, è iterabile e i suoi iteratori la
 * percorrono in ordine non decrescente.
 * Nessun metodo di questa classe può avere una complessità superiore a O(n), dogve n è la
 * lunghezza della lista.
 * L’implementazione deve rispettare il seguente esempio d’uso.
 * @param <T>
 */

public class SortedList<T extends Comparable<T>> implements Iterable<T> {

    public static void main(String[] args) {
        SortedList<Integer> list = new SortedList<>();
        list .add(100); list .add(50); list .add(25); list .add(50);
        for (Integer n: list )
            System.out.println(n);
    }

    LinkedList<T> list = new LinkedList<>();

    public boolean add(T val) {
        list.add(val);
        Collections.sort(list);
        return true;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int i = 0;
            @Override
            public boolean hasNext() {
                return i < list.size();
            }

            @Override
            public T next() {
                if(hasNext())
                    return list.get(i++);
                return null;
            }
        };
    }
}
