package Iteratori_e_foreach;

import java.util.Iterator;

/**
 * Definire una classe Primes che rappresenta l’insieme dei numeri primi. Il campo statico iterable
 * fornisce un oggetto su cui si può iterare, ottenendo l’elenco di tutti i numeri primi. Non deve
 * essere possibile per un’altra classe creare oggetti di tipo Primes.
 * Suggerimento: Primes potrebbe implementare sia Iterator<Integer> che Iterable<Integer>. In tal
 * caso, il campo iterable potrebbe puntare ad un oggetto di tipo Primes.
 */

public class PrimesMain {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        for (Integer i : Primes.iterable ) {
            if ( i > 20) break;
            System.out.println( i ) ;
        }
    }
}

abstract class Primes {
    public static final Iterable<Integer> iterable = () -> {
        return new Iterator<>() {
            private int n = 1;

            public boolean hasNext() {
                return true;
            }

            public Integer next() {
                n++;
                int i;
                for (i = 2; i < n; i++) {
                    if (n % i == 0) {
                        n++;
                    }
                }
                return i;
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    };
}
