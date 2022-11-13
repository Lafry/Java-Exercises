package Chiarimenti;

class K{
    private int x;

    private class Z{
        private int z;
    }
}

public class InternClass {

    private int n;
    private int k;

    /**
     * Privilegio di visibilità: A e B non hanno restrizioni di visibilità.
     * B è conosciuto solo da A.
     */
    private class B{
        private int i;
        private void foo(InternClass a){
            // Posso utilizzare n in B anche se è privata
            System.out.println(a.n);
            /**
             * Siccome non c'è un k in B allora è implicitamente riferito a quello di A
             * ergo le prossime due s.o.p risultano equivalenti
             */
            System.out.println(k);
            System.out.println(InternClass.this.k); // se B statico -> errore di compilazione
            /**
             * Se anche in B ci fosse K allora le due istruzioni non sarebbero più equivalenti:
             *      - la prima per riferirsi al k di B
             *      - la seconda per riferirsi al k di A
             */
        }
    }

    public class C{

    }

    public D something() { return new D(); }

    public static class D{
        public void ofD(){ }
    }

    public static void main (String []args){
        InternClass a = new InternClass();
        InternClass.B b = a.new B();        // compila perchè si trovano nello stesso file
        C c = a.new C();
        InternClass.C c2 = a.new C();       // istruzione sopra e questa sono equivalenti
        D d = new D();                      // perchè è interna statica
        d.ofD();
        D fromIntern = a.something();

        K k = new K();
        //K.Z z = k.new Z();                // errore: Z deve essere public oppure il main deve trovarsi in K

    }
}
