package Thread;

public class SharedObject {
    public static void main(String[] args) throws InterruptedException {
        class MyThread extends Thread {
            private int id;
            private int[] arr;

            public MyThread(int id, int[] arr) {
                this.id = id;
                this.arr = arr;
            }

            public void run() {
                synchronized (arr) {
                    arr[0]++;
                    System.out.println(id + ":" + arr[0]);
                }
                return;
            }
        }
        int[] a = {0};
        Thread t1 = new MyThread(1, a);
        Thread t2 = new MyThread(2, a);
        Thread t3 = new MyThread(3, a);
        t1.start();
        t2.start();
        t3.start();
    }
}

/**
 * Elencare le sequenze di output.
 *
 *  - Non sono presenti race conditions grazie al synchronized
 *  - Quindi alla fine arr[0] arriverà sicuramente a 3.
 *  - Possibili output:
 *      - 1 1
 *      - 2 2
 *      - 3 3
 *      - in generale l'ordine della prima colonna può cambiare, la seconda è uguale.
 *
 *
 *  Per esercizio considerare il system.out.println fuori dal synchronized:
 *      - In questo caso potrebbero vedere anche tutti e tre il numero 3.
 */
