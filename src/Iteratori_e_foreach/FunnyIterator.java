package Iteratori_e_foreach;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Individuare l’output del seguente programma. Dire se la classe FunnyIterator rispetta il contratto
 * dell’interfaccia Iterator. In caso negativo, giustificare la risposta
 */

public class FunnyIterator implements Iterator {
    private String msg = "";

    public Object next() {
        if(!hasNext())
            throw new NoSuchElementException();

        if (msg.equals("")) msg = "ah";
        else msg += msg;
        return msg;
    }
    public boolean hasNext() { return msg.length() < 5; }
    public void remove() { }
    public void addChar() { msg += "b"; }

    public static void main(String[] args) {
        Iterator i = new FunnyIterator();

        do {
            System.out.println(i .next());
        } while (i.hasNext());

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(8);
        list.add(56);
        list.add(2);
        list.add(9);
        list.add(666);

        Iterator<Integer> iterator = list.iterator();


        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());    // lancia eccezione

        /**
         * Risposta:
         *      - hasNext: rispetta il contratto
         *      - next: non rispetta la pre-condizione, non richiamo prima hasNext
         *      - remove: non lo rispetta, se non lo si vuole implementare dovrebbe lanciare l'eccezione
         *        'UnsupportedOperationException', che è l'eccezione di default da lanciare in questo caso.
         *        N.B: qualora si volesse implementare tale metodo allora dovrebbe lanciare 'IllegalStateException'.
         *
         */
    }
}

