package Generics;

/**
 * Realizzare la classe parametrica Pair, che rappresenta una coppia di oggetti di tipo potenzialmente
 * diverso. La classe deve supportare le seguenti funzionalità:
 * 1) due Pair sono uguali secondo equals se entrambe le loro componenti sono uguali secondo equals;
 * 2) il codice hash di un oggetto Pair è uguale allo XOR tra i codici hash delle sue due componenti;
 * 3) la stringa corrispondente ad un oggetto Pair è “(str1,str2)”, dove str1 (rispettivamente,
 * str2) è la stringa corrispondente alla prima (risp., seconda) componente.
 * @param <S>
 * @param <T>
 */

public class Pair<S, T>{
    private S elemento1;
    private T elemento2;
    public Pair(S elemento1, T elemento2){
        this.elemento1 = elemento1;
        this.elemento2 = elemento2;
    }

    public static void main(String[] args) {
        Pair<String,Integer> p1 = new Pair<String,Integer>("uno", 1);
        Pair<String,Integer> p2 = new Pair<String,Integer>("due", 2);
        Pair<Integer,String> p3 = new Pair<Integer,String>(3, "tre");
        Pair<String,Integer> p4 = new Pair<String,Integer>("uno", 1);
        System.out.println(p1);
        System.out.println(p1.equals(p2));
        System.out.println(p1.equals(p3));
        System.out.println(p1.equals(p4));
        System.out.println(p2.equals(2));
        System.out.println(p1.hashCode() + " = " + p4.hashCode());
        System.out.println(p1.hashCode() + " = " + p2.hashCode());
    }

    @Override
    public boolean equals(Object o){
        if(o == this) return true;
        if(! (o instanceof Pair)) return false;
        Pair<?,?> prova = (Pair<?, ?>) o;
        return ((prova.elemento1.equals(this.elemento1)) && (prova.elemento2.equals(this.elemento2)));
    }

    @Override
    public int hashCode(){
        return elemento1.hashCode() ^ elemento2.hashCode();
    }

    @Override
    public String toString(){
        return "("+elemento1.toString()+","+elemento2.toString()+")";
    }

}