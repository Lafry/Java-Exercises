package MemoryLayout;

public class MemoryLayout_24_2_2022 {
    public static void main(String[]args){
        G a1 = new G();
        G a2 = new G();
        G.B b = new G.B();
        G.C c1 = a1.new C();
        G.C c2 = a2.new C();
    }
}

class G{
    private int n=0;
    G(){
        n++;
    }

    public static class B{
        int i =1;
    }

    public class C{
        int j=2;
    }
}
