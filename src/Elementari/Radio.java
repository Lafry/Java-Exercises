package Elementari;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Realizzare le classi Radio e Channel che rappresentano una radio e una stazione radiofonica. La
 * classe Radio offre un costruttore senza argomenti e i seguenti metodi:
 *      • addChannel memorizza e restituisce una nuova stazione, caratterizzata da nome e frequenza.
 *        Il tentativo di memorizzare una stazione che ha la stessa frequenza di una stazione già
 *        memorizzata deve provocare un’eccezione.
 *      • nearest accetta una frequenza e restituisce la stazione con la frequenza più vicina a quella
 *        data.
 *
 * Inoltre, se si itera su un oggetto Radio si ottiene la sequenza di stazioni inserite, in ordine crescente
 * di frequenza.
 * Fare in modo che l’unico modo per creare oggetti Channel sia tramite il metodo addChannel
 */

public class Radio implements Iterable<Radio.Channel>{
    public static void main (String []args){
        Radio r = new Radio();
        Channel rai1 = r.addChannel("Rai␣Radio␣Uno", 89.3);
        Channel kk = r.addChannel("Radio␣Kiss␣Kiss", 101.4);
        Channel rmc = r.addChannel("Radio␣Monte␣Carlo", 96.4);
        for (Channel c: r) {
            System.out.println(c);
        }
        System.out.println(r.nearest(98.1) );
    }

    List<Channel> channelSet = new ArrayList<>();

    public Channel addChannel(String name, double frequency){
        Channel c = new Channel(name, frequency);
        channelSet.add(c);
        return c;
    }

    public Channel nearest(double frequency){
        double previousDifference=Math.abs(channelSet.get(0).frequency-frequency);
        Channel returnValue=null;
        for(Channel c : channelSet){
            double currentDifference=Math.abs(c.frequency-frequency);
            if(currentDifference<previousDifference){
                previousDifference=currentDifference;
                returnValue = c;
            }
        }
        return returnValue;
    }

    @Override
    public Iterator<Channel> iterator() {
        return new Iterator<Channel>() {
            int i=0;
            @Override
            public boolean hasNext() {
                return i< channelSet.size();
            }

            @Override
            public Channel next() {
                if(!hasNext()){
                    throw new NoSuchElementException();
                }
                Channel c = channelSet.get(i);
                i++;
                return c;
            }
        };
    }

    public class Channel{
        String name;
        double frequency;
        private Channel(String name, double frequency){
            this.name = name;
            this.frequency = frequency;
        }

        @Override
        public String toString() {
            return "Channel{" +
                    "name='" + name + '\'' +
                    ", frequency=" + frequency +
                    '}';
        }
    }
}