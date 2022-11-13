package Thread;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Implementare un metodo statico delayIterator che prende come argomenti un iteratore “i” ed un
 * numero intero “n”, e restituisce un nuovo iteratore dello stesso tipo di “i”, che restituisce gli stessi
 * elementi di “i”, ma in cui ogni elemento viene restituito (dal metodo next) dopo un ritardo di “n”
 * secondi.
 * Suggerimento: se possibile, utilizzare classi anonime.
 *
 * Output: il programma stampa il contenuto della lista, mostrando ciascun valore dopo 2 secondi di
 * ritardo.
 */

public class DelayIterator {

    //public static <T> Iterator<T> delayIterator(Iterator<T> listIterator, int seconds){
    // Firma migliore:
    // l'iteratore viene solo letto, quindi è più opportuno aggiungere ulteriori garanzie in modo
    // che non venga scritto.
    public static <T> Iterator<T> delayIterator(Iterator<? extends T> listIterator, int seconds){
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return listIterator.hasNext();
            }

            @Override
            public T next() {
                try {
                    Thread.sleep(seconds * 1000L);
                } catch (InterruptedException e) {
                    return null;
                }
                return listIterator.next();
            }
        };
    }

    public static void main(String []args){
        List<Integer> l = new LinkedList<Integer>();
        l.add(3);
        l.add(4);
        l.add(177);
        Iterator<Integer> i = delayIterator(l.iterator(), 2);
        while (i.hasNext()) {
            System.out.println(i.next());
        }
    }
}
