package Thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

/**
 * Implementare il metodo statico threadRace, che accetta due oggetti Runnable come argomenti,
 * li esegue contemporaneamente e restituisce 1 oppure 2, a seconda di quale dei due Runnable è
 * terminato prima.
 *
 * Si noti che threadRace è un metodo bloccante. Sarà valutato negativamente l’uso di attesa attiva.
 */

public class ThreadRace {

    // soluzione alternativa con blocking queue
    public static int threadRaceQueue(Runnable r1, Runnable r2) throws InterruptedException {
        final BlockingQueue<Integer> buf = new ArrayBlockingQueue<>(2);

        Thread t1 = new Thread(){
            @Override
            public void run(){
                r1.run();
                try {
                    buf.put(1);
                } catch (InterruptedException e) { }
            }
        };

        Thread t2 = new Thread(){
            @Override
            public void run(){
                r2.run();
                try {
                    buf.put(2);
                } catch (InterruptedException e) { }
            }
        };

        return buf.take();
    }

    public static int threadRace(Runnable r1, Runnable r2) throws InterruptedException{
        final int[] result = { 0 };

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                r1.run();
                synchronized (result){
                    if(result[0] == 0)
                        result[0] = 1;
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                r2.run();
                synchronized (result){
                    if(result[0] == 0)
                        result[0] = 2;
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        return result[0];
    }

    public static void main(String []args) throws InterruptedException {
        Runnable r1 = () -> System.out.println("Primo");

        Runnable r2 = () -> System.out.println("Secondo");

        System.out.println("Qualcosa...");

        System.out.println(ThreadRace.threadRace(r1, r2));
    }
}
