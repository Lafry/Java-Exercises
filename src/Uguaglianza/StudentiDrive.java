package Uguaglianza;

public class StudentiDrive {
    public static void main(String[]args){
        Studente.Triennale.setPrefisso ("N86");
        Studente.Magistrale.setPrefisso ("N97");
        Object luca1 = new Studente.Triennale("Luca", "004312"),
                luca2 = new Studente.Triennale("Luca", "004312"),
                anna1 = new Studente.Triennale("Anna", "004312"),
                anna2 = new Studente.Magistrale("Anna", "004312");
        System.out.println(luca1.equals(luca2)); //true
        System.out.println(anna1.equals(anna2)); //false
        System.out.println(anna1); //Anna N86/004312

    }
}

class Studente{
    String nome;
    String matricola;

    public Studente(String nome, String matricola){
        this.nome = nome;
        this.matricola = matricola;
    }

    static class Magistrale extends Studente{
        public Magistrale(String nome, String matricola){
            super(nome, prefisso+"/"+matricola);
        }
        static String prefisso;

        public static void setPrefisso(String pref) {
            prefisso = pref;
        }
    }

    static class Triennale extends Studente{
        static String prefisso;

        public Triennale(String nome, String matricola) {
            super(nome, prefisso+"/"+matricola);
        }

        public static void setPrefisso(String pref) {
            prefisso = pref;
        }
    }

    @Override
    public boolean equals(Object o){
        if (this==o) return true;

        if(!(o instanceof Studente s)) return false;
        return (s.nome.equals(nome)) && (s.matricola.equals(matricola));
    }

    @Override
    public String toString(){
        return nome+" "+matricola;
    }
}
