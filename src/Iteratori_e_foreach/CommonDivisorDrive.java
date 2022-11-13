package Iteratori_e_foreach;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Implementare una classe CommonDividers che rappresenta tutti i divisori comuni di due numeri
 * interi, forniti al costruttore. Su tale classe si deve poter iterare secondo il seguente caso d’uso.
 * Dei 30 punti, 15 sono riservati a coloro che realizzeranno l’iteratore senza usare spazio aggiuntivo.
 * Viene valutato positivamente l’uso di classi anonime laddove opportuno.
 *
 * N.B: Mancano tre ore all'esame e non sono riuscito a farlo, quindi non funziona
 */

public class CommonDivisorDrive {
    public static void main(String[]args){
        for (Integer n: new CommonDividers(12, 60))
            System.out.print(n + "␣");
    }
}

class CommonDividers implements Iterable<Integer>{
    Integer div1, div2, minoreTraIDue;



    public CommonDividers(Integer div1, Integer div2){
        this.div1 = div1;
        this.div2 = div2;
        this.minoreTraIDue = Math.min(div1, div2);
    }


    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int i=1;
            @Override
            public boolean hasNext() {
                return i<minoreTraIDue;
            }

            @Override
            public Integer next() {
                int value=i++;
                if((value%div1==0) && (value%div2==0)){
                    return value;
                }
                return next();
            }
        };
    }
}