package MemoryLayout;

public class MemoryLayout_1_2022 {
    public static void main(String[] args) {
        E a1 = new E(10);
        E a2 = new E(20);
        E.B b1 = a1.new B();
        E.B b2 = a2.new B();
        Object c = a1.makeTask("Bla_Bla");
    }
}

class E {
    public int val;
    public static boolean flag = true;

    public E(int val) {
        this.val = val;
        flag = !flag;
    }

    class B {
        private int secret;
        public B() { val++; }
    }

    public Runnable makeTask(String msg) {
        return () -> System.out.println(msg);
    }
}
