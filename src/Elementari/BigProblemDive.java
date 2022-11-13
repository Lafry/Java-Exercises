package Elementari;

import java.util.*;

public class BigProblemDive {
    public static void main(String[]args){
        BigProblem bp = new BigProblem();
        bp.add(new RuntimeException("Problem A"));
        bp.add(new Exception("Problem B"));
        bp.add(new InterruptedException("Problem C"));
        bp.add(new ArrayIndexOutOfBoundsException("Problem D"));
        bp.add(new OutOfMemoryError("Error"));

        System.out.println(bp.containsChecked());
        try{
            throw bp;
        }catch (Throwable t){
            System.out.println(t.getMessage());
        }
    }
}

//Ho pensato di usare Throwable invece di Exception perché così è possibile passare sia Eccezioni che Errori
class BigProblem extends RuntimeException{
    List<Throwable> exceptions = new ArrayList<>();
    public void add(Throwable t){
        exceptions.add(t);
    }

    @Override
    public String getMessage(){
        StringBuilder msg = new StringBuilder();
        for(Throwable t: exceptions){
            msg.append(t.getMessage()).append("\n");
        }
        return msg.toString();
    }

    public boolean containsChecked(){
        for(Throwable t : exceptions)
            if((!(t instanceof RuntimeException)) && !(t instanceof Error)) return true;
        return false;
    }
}
