package Uguaglianza;

import java.math.BigInteger;

/**
 * Implementare la classe Fraction, che rappresenta una frazione, e la sottoclasse ReducedFraction,
 * che rappresenta una frazione irriducibile.
 * Due oggetti di questi tipi devono essere uguali per equals se rappresentano lo stesso numero
 * razionale, anche se uno è di tipo Fraction e l’altro ReducedFraction.
 *
 * Oltre a un costruttore che accetta numeratore e denominatore, le due classi offrono il metodo
 * times, che calcola il prodotto, restituendo un nuovo oggetto Fraction. Il nuovo oggetto deve essere
 * di tipo effettivo ReducedFraction se e soltanto se entrambi gli operandi del prodotto sono di tipo
 * effettivo ReducedFraction
 *
 * Suggerimento: per calcolare il massimo comun divisore tra due interi a e b, si può usare
 * l’istruzione BigInteger.valueOf(a).gcd(BigInteger.valueOf(b)).intValue().
 */

public class FractionDrive {
    public static void main(String []args){
        Fraction a = new Fraction(12, 30), b = new ReducedFraction(12, 30),
                c = new Fraction(1, 4), d = c.times(a);

        System.out.println(a);
        System.out.println(b);
        System.out.println(d);
        System.out.println(a.equals(b));
        System.out.println(c.times(b));
    }
}

class Fraction{
    private int numeratore;
    private int denominatore;

    public Fraction(int numeratore, int denominatore){
        this.numeratore = numeratore;

        if(denominatore <= 0) throw new IllegalArgumentException();
        this.denominatore = denominatore;
    }

    public int getNumeratore(){
        return numeratore;
    }

    public int getDenominatore(){
        return denominatore;
    }

    // scenario uniforme
    // final: non deve essere sovrascritto dalle altre classi (perchè ci troviamo
    // nello scenario uniforme)
    @Override
    public final boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof Fraction)) return false;
        Fraction f = (Fraction) o;
        return (numeratore/denominatore == f.numeratore/f.denominatore);
    }

    public Fraction times(Fraction f){
        int new_n = numeratore * f.numeratore;
        int new_d = denominatore * f.denominatore;

        return new Fraction(new_n, new_d);
    }

    @Override
    public String toString(){
        return numeratore + "/" + denominatore;
    }
}

class ReducedFraction extends Fraction {

    public static int getMCD(int a, int b) {
        return BigInteger.valueOf(a).gcd(BigInteger.valueOf(b)).intValue();
    }

    public ReducedFraction(int numeratore, int denominatore) {
        super(
                numeratore / ReducedFraction.getMCD(numeratore, denominatore),
                denominatore / ReducedFraction.getMCD(numeratore, denominatore)
        );
    }

    @Override
    public Fraction times(Fraction f) {
        int new_n = getNumeratore() * f.getNumeratore();
        int new_d = getDenominatore() * f.getDenominatore();

        if (f instanceof Fraction)
            return new Fraction(new_n, new_d);
        else
            return new ReducedFraction(new_n, new_d);
    }
}