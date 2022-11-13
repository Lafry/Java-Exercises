package Generics;

import Classes.Manager;

import java.lang.reflect.Field;

/**
 * Implementare un metodo, chiamato reset, che prende come argomento un oggetto ed imposta a
 * zero tutti i suoi campi interi pubblici
 *
 * Implementare un metodo che, dato un oggetto, parte dalla classe che rappresenta il tipo effettivo
 * dell'oggetto e ne restituisce la superclasse più generale, escludendo Object (quindi, la penultima classe,
 * prima di arrivare a Object)
 *
 */
public class ResetMethodDrive {
    public static void main(String ... args){
        OggettoProva ogg = new OggettoProva();
        System.out.println(ogg); //Stampa l'oggetto come dichiarato
        try{
            ResetMethodDrive.reset(ogg);
        }catch (IllegalAccessException illegalAccessException){
            System.out.println("illegalAccessException");
        }
        System.out.println(ogg); //Stampa l'oggetto con i campi pubblici interi settati a 0

        System.out.println(ResetMethodDrive.getSuperClass(new Manager("poppo", 123, 12))); //Stampa Person, in quanto superclasse più generale prima di Object

    }

    public static void reset(Object o) throws IllegalAccessException {
        Class<?> c = o.getClass();
        Field[] f = c.getFields();
        for (Field field: f) {
            try{
                field.setInt(o,0);
            } catch (IllegalArgumentException p){
                System.out.println("passo avanti");
            }

        }
    }

    public static Class<?> getSuperClass (Object o){
        Class<?> c = o.getClass();
        while(c.getSuperclass()!= Object.class)
            c = c.getSuperclass();

        return c;
    }

}
class OggettoProva{
    public int a = 1;
    public int b = 2;
    private int c = 3;
    public String d = "pippo";

    @Override
    public String toString() {
        return "Generics.OggettoProva{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", d='" + d + '\'' +
                '}';
    }
}
