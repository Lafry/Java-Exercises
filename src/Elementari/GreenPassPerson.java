package Elementari;

/**
 * Realizzare le classi Person e GreenPass che rappresentano una persona e una certificazione verde.
 * Una persona è identificata dal suo nome. Il metodo vaccinate di Person accetta come argomento
 * la data di vaccinazione (un intero che rappresenta un giorno) e restituisce un oggetto GreenPass.
 * La classe GreenPass offre i seguenti metodi:
 *      • isValidOn accetta una data e restituisce vero se questa certificazione verde è valida in quella
 *        data.
 *      • belongsTo accet
 *      ta un Person e restituisce vero se questa certificazione appartiene a quella
 *        persona.
 *
 * La validità di un GreenPass è definita dalle seguenti regole:
 *      • se si tratta della prima dose (prima chiamata a vaccinate per questa persona), il GreenPass
 * è valido per 180 giorni;
 *      • negli altri casi, il GreenPass è valido per 270 giorni.
 */

public class GreenPassPerson {
    public static void main(String []args){
        Person aldo = new Person("Aldo"), barbara = new Person("Barbara");
        GreenPass p1 = aldo.vaccinate(10), p2 = aldo.vaccinate(250);
        System.out.println(p1.isValidOn(20));   // true
        System.out.println(p1.isValidOn(200));  // false
        System.out.println(p2.isValidOn(200));  // true
        System.out.println(p1.belongsTo(barbara));     // false
        System.out.println(p1.belongsTo(aldo));        // true
        System.out.println(p2.belongsTo(aldo));        // true
    }
}

class Person{
    private String name;
    private GreenPass greenPass;

    public Person(String name) {
        this.name = name;
    }

    public GreenPass vaccinate(int day){
        // true: first vaccination, false otherwise
        if(greenPass == null){
            greenPass = new GreenPass(this, day, true);
            return greenPass;
        }

        return new GreenPass(this, day, false);
    }
}


class GreenPass{
    private Person person;
    private int day;
    private boolean isFirstVaccination = false;

    public GreenPass(Person person, int day, boolean isFirstVaccination) {
        this.person = person;
        this.day = day;
        this.isFirstVaccination = isFirstVaccination;
    }

    public boolean isValidOn(int lastDay){
        boolean isCurrentYear = day + lastDay < 365;
        if(isFirstVaccination){
            if(isCurrentYear)
                return lastDay - day <= 180;
            else
                return lastDay + day - 365 < 180;
        } else{
            if(isCurrentYear)
                return lastDay - day <= 270;
            else
                return lastDay + day - 365 < 270;
        }
    }

    public boolean belongsTo(Person p){
        return p == person;
    }
}
