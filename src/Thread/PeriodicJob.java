package Thread;

/**
 * Implementare il metodo statico periodicJob, che accetta un Runnable r e un periodo p espresso in
 * millisecondi e fa partire un'esecuzione di r ogni p millisecondi.
 */

public class PeriodicJob {
    public static void main(String []args){
        Runnable r = () -> System.out.println("ciao");
        periodicJob(r, 2000);
    }

    public static void periodicJob(Runnable r, long delay){
        /**
         * Lo lancio in un nuovo thread(classe anonima) perchè altrimenti eseguirebbe quel ciclo
         * all'infinito senza restituire il controllo al chiamante.
         */
        new Thread(() -> {
            /**
             * while (!Thread.currentThread().isInterrupted() in questo caso sarebbe superfluo
             * perchè c'è già una chiamata bloccante nel corpo, motivo per cui while(True) è Ok.
             */
            while(true){
                new Thread(r).start();
                try{
                    Thread.sleep(delay);
                } catch (InterruptedException e){
                    return;
                }
            }
        }).start();
    }
}
