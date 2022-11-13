package MemoryLayout;

public class MemoryLayout_28_3_2022 {
    public static void main(String[] args){
        F a1 = new F();
        F a2 = new F();
        Object x = a1.makeObj(42);
        F.B y = (F.B) a1.makeObj(42);
        F.B b = new F.B();
    }
}

class F{
    private int n=0;
    public F(){
        n++;
    }
    public static class B{
        private int i=1;
    }

    public Object makeObj(int val){
        return new B(){
            private int j=val;
        };
    }
}
