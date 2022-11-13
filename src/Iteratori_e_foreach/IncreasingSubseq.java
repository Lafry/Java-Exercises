package Iteratori_e_foreach;

import java.util.*;

/**
 * Implementare la classe IncreasingSubseq che, data una lista di oggetti tra loro confrontabili,
 * rappresenta la sottosequenza crescente che inizia col primo elemento.
 * Attenzione: la classe deve funzionare con qualunque tipo di dato che sia confrontabile (non solo
 * con “Integer”).
 * Sarà valutato negativamente l’uso di “strutture di appoggio”, ovvero di spazio aggiuntivo di
 * dimensione non costante
 * @param <T>
 */

public class IncreasingSubseq<T extends Comparable<? super T>> implements Iterable<T>{
    List<T> listOfT = new ArrayList<>();

    public static void main(String []args){
        List<Integer> l = new LinkedList<Integer>();
        l .add(10); l .add(3);
        l .add(5); l .add(12);
        l .add(11); l .add(35);
        for (Integer i : new IncreasingSubseq<Integer>(l))
            System.out.println(i );
    }

    public IncreasingSubseq(List<T> fullList){
        T previous = fullList.get(0); // get first element, O(1)
        for(T t: fullList){
            /**
             *  se l'elemento corrente è >= a previous allora lo aggiungo alla lista
             *  e aggiorno previous.
             *  Es:
             *      - 10 >= 3? Si, aggiungo 10 alla lista
             *      - 3 >= 10? No, continua
             *      - 5 idem
             *      - 12 >= 10? Si, aggiungo 12 alla lista, e così via
             */
            if(t.compareTo(previous) >= 0){
                listOfT.add(t);
                previous = t;
            }
        }
    }

    public Iterator<T> iterator(){
        return new Iterator<T>(){
            int i = 0;
            @Override
            public boolean hasNext(){
                return i < listOfT.size();
            }

            @Override
            public T next(){
                return listOfT.get(i++);
            }
        };
    }

}