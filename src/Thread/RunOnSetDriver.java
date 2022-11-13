package Thread;

import java.util.Collection;
import java.util.HashSet;

/**
 * Si consideri la seguente interfaccia.
 *
 *      public interface RunnableWithArg<T> {
 *          void run(T x);
 *      }
 *
 * Un oggetto RunnableWithArg è simile ad un oggetto Runnable, tranne per il fatto che il suo metodo
 * run accetta un argomento.
 * Si implementi una classe RunOnSet che esegue il metodo run di un oggetto RunnableWithArg su
 * tutti gli oggetti di una data collezione, contemporaneamente.
 *
 * Un possibile output dell'esempio d'uso:
 * 1
 * 6
 * 44
 */

interface RunnableWithArg<T> {
    void run(T x);
}

class RunOnSet<T> extends Thread{
    private Collection<Thread> threadCollection = new HashSet<>();

    public RunOnSet(final RunnableWithArg<T> r, final Collection<T> s){
        /**
         * Unica eccezione del final perchè t si può vedere nella classe anonima.
         */
        for(final T t: s){
            threadCollection.add(new Thread(() -> r.run(t)));
        }
    }

    @Override
    public void run(){
        for(Thread t: threadCollection)
            t.start();
    }

}

public class RunOnSetDriver {
    public static void main(String []args){
        Collection<Integer> s = new HashSet<Integer>();
        s.add(3); s.add(13); s.add(88);
        RunnableWithArg<Integer> r = new RunnableWithArg<Integer>() {
            public void run(Integer i) {
                System.out.println(i/2);
            }
        };
        Thread t = new RunOnSet<Integer>(r, s);
        t.start();
    }
}
