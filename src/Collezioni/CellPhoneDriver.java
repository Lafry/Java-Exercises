package Collezioni;

import java.util.HashMap;
import java.util.Map;

/**
 * Implementare la classe Cellphone, che rappresenta un’utenza telefonica dotata di un gestore (strin-
 * ga) e un numero di telefono (stringa). La classe è in grado di calcolare il costo di una telefonata,
 * in base al gestore di partenza, al gestore di arrivo, e alla durata.
 * Il metodo setCost consente di impostare il costo al minuto di una telefonata con un dato gestore
 * di partenza e un dato gestore di arrivo. Il metodo getCost calcola il costo di una telefonata verso
 * una data utenza e di una data durata (in minuti).
 */

public class CellPhoneDriver {
    public static void main(String []args){
        Cellphone a = new Cellphone("TIMMY", "3341234"),
                b = new Cellphone("Megafon", "3355678"),
                c = new Cellphone("Odissey", "3384343");
        Cellphone.setCost("TIMMY", "TIMMY", 0.05);
        Cellphone.setCost("TIMMY", "Megafon", 0.15);
        Cellphone.setCost("Megafon", "TIMMY", 0.25);
        System.out.println(a.getCost(b, 10));           // 1.5
        System.out.println(b.getCost(a, 8)) ;           // 2.0
        System.out.println(a.getCost(c, 10));           // provoca eccezione
    }
}

class Cellphone{
    private String gestore;
    private String numero;
    private static Map<String, Map<String, Double>> map = new HashMap<>();

    public Cellphone(String gestore, String numero) {
        this.gestore = gestore;
        this.numero = numero;
    }

    public static void setCost(String chiamante, String ricevente, Double costoPerMinuto){
        Map<String, Double> tmp = new HashMap<>();
        tmp.put(ricevente, costoPerMinuto);
        map.put(chiamante, tmp);
    }

    public double getCost(Cellphone cellphone, Integer minuti){
        return map.get(this.gestore).get(cellphone.gestore) * minuti;
    }
}
