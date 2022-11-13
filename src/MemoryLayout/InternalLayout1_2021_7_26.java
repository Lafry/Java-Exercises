package MemoryLayout;

public class InternalLayout1_2021_7_26 {
    public static void main (String []args){
        D a1 = new D();
        D a2 = new D.B();
        D.C c1 = a1.new C();
        D.C c2 = a2.new C();
    }
}

class D {
    public int n;
    private D myself = this;
    static class B extends D {
        int i = 1;
    }
    public class C {
        int j = 2;
    }
}

