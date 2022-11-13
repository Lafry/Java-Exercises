
package Uguaglianza;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BoxColorBox {
    public static void main(String []args){
        Box b = new Box(12, 14);
        Box a = new Box(12, 14);
        Box c = new Box(14,12);
        ColoredBox cb = new ColoredBox(12, 14, "verde");
        ColoredBox cb2 = new ColoredBox(12, 14, "verde");
        ColoredBox cb3 = new ColoredBox(12, 14, "rosso");
        ColoredBox cb4 = new ColoredBox(22, 14, "verde");
        ColoredBox cb5 = new ColoredBox(22, 14, "giallo");

        System.out.println(b.equals(a)); //true
        System.out.println(b.equals(c)); //false
        System.out.println(b.equals(cb)); //false
        System.out.println(cb.equals(cb2)); //true
        System.out.println(cb.equals(cb3)); //false
        System.out.println(cb.equals(cb4)); //false
        System.out.println(cb.equals(cb5)); //false

        System.out.println(b.hashCode());
        System.out.println(a.hashCode());
        System.out.println(c.hashCode());
        System.out.println(cb.hashCode());
        System.out.println(cb2.hashCode());
        System.out.println(cb3.hashCode());
        System.out.println(cb4.hashCode());
        System.out.println(cb5.hashCode());
    }

}
class Box {
    private int x, y;

    public Box(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o){
        if(this==o) return true;
        if(!(o.getClass() == getClass())) return false;
        Box other = (Box) o;
        return (this.x == other.x)&&(this.y==other.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

class ColoredBox extends Box {
    private String color;

    public ColoredBox(int x, int y, String color) {
        super(x, y);
        this.color = color;
    }

    @Override
    public boolean equals(Object o){
        if(!super.equals(o)) return false;
        ColoredBox cb = (ColoredBox) o;
        return (this.color.equals(cb.color));
    }

    @Override
    public int hashCode(){
        int prime = 31;
        int hash = super.hashCode();
        return prime*hash + color.hashCode();
    }
}
