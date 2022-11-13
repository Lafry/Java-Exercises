package Iteratori_e_foreach;

import java.util.*;

/**
 * L’interfaccia parametrica Selector prevede un metodo select che restituisce un valore booleano
 * per ogni elemento del tipo parametrico.
 * Implementare una classe SelectorIterator che accetta una collezione e un selettore dello stesso
 * tipo, e permette di iterare sugli elementi della collezione per i quali il selettore restituisce true.
 */

public class SelectorDrive {
    public static void main(String[]args){
        Integer [] a = { 1, 2, 45, 56, 343, 22, 12, 7, 56};
        List<Integer> l = Arrays.asList(a);
        Selector<Integer> pari = new Selector<Integer>() {
            public boolean select(Integer n) {
                return (n % 2) == 0;
            }
        };
        for (Integer n: new SelectorIterator<Integer>(l, pari))
            System.out.print(n + "␣"); //2 56 22 12 56
    }
}

interface Selector<T> {
    boolean select(T x);
}

class SelectorIterator<T> implements Iterable<T>{
    Collection<T> l;
    Selector<T> s;
    public SelectorIterator(Collection<T> l, Selector<T> s){
        this.l=l;
        this.s=s;
    }

    @Override
    public Iterator<T> iterator() {
        ArrayList<T> list = new ArrayList<>(l);
        return new Iterator<T>() {
            int i=0;
            @Override
            public boolean hasNext() {
                return i<list.size();
            }

            @Override
            public T next() {
                T currentElement = list.get(i++);
                if(s.select(currentElement)) return currentElement;
                return next();
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}