package ClassiInterne;

import java.util.*;

/**
 * Un oggetto Curriculum rappresenta una sequenza di lavori, ognuno dei quali è un’istanza della
 * classe Job. Il costruttore di Curriculum accetta il nome di una persona. Il metodo addJob aggiunge
 * un lavoro alla sequenza, caratterizzato da una descrizione e dall’anno di inizio, restituendo un
 * nuovo oggetto di tipo Job. Infine, la classe Job offre il metodo next, che restituisce in tempo
 * costante il lavoro successivo nella sequenza (oppure null).
 */

public class CurriculumDrive {
    public static void main(String []args){
        Curriculum cv = new Curriculum("Walter␣White");
        Curriculum.Job j1 = cv.addJob("Chimico", 1995);
        Curriculum.Job j2 = cv.addJob("Insegnante", 2005);
        Curriculum.Job j3 = cv.addJob("Cuoco", 2009);
        System.out.println(j1.hasNext());       // true
        System.out.println(j3.hasNext());       // false
        System.out.println(j2 .next()) ;        // Cuoco: 2009
        System.out.println(j3 .next()) ;        // null
    }
}

class Curriculum{
    private String person;
    private List<Job> jobList = new ArrayList<>();
    private int i = 0;
    private Integer k = 0;

    public Curriculum(String person){
        this.person = person;
    }

    public Job addJob(String profession, Integer year){
        Job j = new Job(profession, year, k++);
        jobList.add(j);
        return j;
    }

    @Override
    public String toString() {
        return "Curriculum{" +
                "person='" + person +
                '}';
    }

    class Job implements Iterator<Job>{
        private String profession;
        private Integer year;
        private Integer position;

        private Job(String profession, Integer year, Integer position){
            this.profession = profession;
            this.year = year;
            this.position = position;
        }

        @Override
        public boolean hasNext() {
            return position + 1 < jobList.size();
        }

        @Override
        public Job next() {
            if(!hasNext())
                return null;

            i = this.position + 1;
            return jobList.get(i);
        }

        @Override
        public String toString() {
            return profession + ":" + year;
        }
    }
}