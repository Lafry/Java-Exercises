package Thread;

import static java.lang.Thread.sleep;

/**
 * Implementare la classe Interruptor, il cui compito è quello di interrompere un dato thread dopo un
 * numero fissato di secondi.
 * Ad esempio, se t è un riferimento ad un oggetto Thread, la linea
 * Interruptor i = new Interruptor(t, 10);
 * crea un nuovo thread di esecuzione che interrompe il thread t dopo 10 secondi.
 */

public class InterruptorDrive {
    public static void main (String []args) throws InterruptedException {
        Runnable r = () -> System.out.println("Ciao, sono t e sono stato lanciato da interruptor");
        Thread t = new Thread(r);
        Interruptor i = new Interruptor(t, 50);
        i.start();
        System.out.println("Ora sto aspettando");
        sleep(1000);
        System.out.println(t.isInterrupted());
    }
}
class Interruptor extends Thread{
    Thread threadToStop;
    int time;
    public Interruptor(Thread t, int time){
        this.threadToStop = t;
        this.time=time;
    }

    @Override
    public void run(){
        threadToStop.start();
        try {
            sleep(time);
        } catch (InterruptedException e) {
            System.out.println("Ops, i did it again");
            throw new RuntimeException(e);
        }
        threadToStop.interrupt();
    }
}