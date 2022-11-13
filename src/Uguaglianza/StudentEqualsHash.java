package Uguaglianza;

public class StudentEqualsHash {
    private String name;
    private long matricola;

    public static void main (String [] args){
        StudentEqualsHash s1 = new StudentEqualsHash("Puippo", 1234);
        StudentEqualsHash s2 = new StudentEqualsHash("Gio", 6538);
        StudentEqualsHash s3 = new StudentEqualsHash("Luio", 1235);
        StudentEqualsHash s4 = new StudentEqualsHash();
        StudentEqualsHash s5 = new StudentEqualsHash();

        System.out.println(s1.equals(s2));
        System.out.println(s4.equals(s5));
        System.out.println(s1.equals(s3));

    }

    public StudentEqualsHash() {}

    public StudentEqualsHash(String name, long matricola) {
        this.name = name;
        this.matricola = matricola;
    }

    public String getName() {
        return name;
    }

    public long getMatricola() {
        return matricola;
    }

    //Hanno la matricola della stessa parità (entrambe pari o entrambe dispari).
    /*@Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(! (o instanceof StudentEqualsHash)) return false;
        StudentEqualsHash s = (StudentEqualsHash) o;
        return (((s.matricola%2==0) &&(matricola%2==0)) || ((s.matricola%2!=0) &&(matricola%2!=0)));
    }*/

    //Hanno entrambi i nomi null, oppure nessuno dei due nomi è null e hanno la stessa matricola.
    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(! (o instanceof StudentEqualsHash)) return false;
        StudentEqualsHash s = (StudentEqualsHash) o;
        if((name == null) && (s.name == null)) return true;
        if(!(name == null) && (s.name == null)) return matricola == s.matricola;
        return false;
    }
}
