package Iteratori_e_foreach;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Implementare una classe MyFor in modo che, per tutti i numeri interi a, b e c, il ciclo:
 *      for (Integer i : new MyFor(a, b, c)) { ... }
 * sia equivalente al ciclo:
 *      for (Integer i=a; i<b ; i+=c) { ... }
 */

public class MyFor implements Iterable<Integer> {
    Integer a,b,c;

    public static void main(String []args){
        for(Integer i = 2; i<5; i+=1){
            System.out.println(i + " for");
        }
        for(Integer i : new MyFor(2,5,1)){
            System.out.println(i + " myFor");
        }
    }

    public MyFor(Integer a, Integer b, Integer c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public Iterator<Integer> iterator(){
        return new Iterator<Integer>() {
            int i=a-c;
            @Override
            public boolean hasNext() {
                return i+c<b;
            }

            @Override
            public Integer next() {
                if(!hasNext()){
                    throw new NoSuchElementException();
                }
                i=i+c;
                return i;
            }
        };
    }
}