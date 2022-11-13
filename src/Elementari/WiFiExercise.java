package Elementari;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Realizzare le classi WiFi e Network, che rappresentano un elenco di reti WiFi e una singola rete.
 * La classe WiFi offre un costruttore senza argomenti e i seguenti metodi:
 *      • addNetwork: memorizza e restituisce una nuova rete, caratterizzata da nome (SSID) e
 *        intensità del segnale.
 *      • strongest: restituisce la rete con l’intensità più alta (più vicina allo zero).
 *
 * Inoltre, gli oggetti WiFi devono essere iterabili, dando la possibilità di scorrere le reti inserite, in
 * ordine di intensità decrescente.
 * La classe Network offre soltanto il metodo updateStrength, che aggiorna l’intensità del segnale.
 * Fare in modo che l’unico modo per creare oggetti Network sia tramite il metodo addNetwork.
 */

public class WiFiExercise {
    public static void main (String []args){
        WiFi manager = new WiFi();
        WiFi.Network home = manager.addNetwork("Vodafone", -40.5);
        WiFi.Network hotel = manager.addNetwork("Hotel␣Vesuvio", -53.05);
        WiFi.Network neighbor = manager.addNetwork("Casa␣Esposito",-48.95);
        neighbor.updateStrength(-39.6);
        WiFi.Network x = manager.strongest();
        System.out.println(x); //Casa Esposito (-39.6 dBm)

        for(WiFi.Network n : manager.networkSet){
            System.out.println(n);
        }
        //WiFi.Network y = manager. new Network("pipppo", -54.06); SE IL COSTRUTTORE FOSSE PUBLIC QUESTA FUNZIONEREBBE
    }
}

class WiFi{
    // N.B.: Se si crea un TreeSet senza parametri nel costruttore -> Network deve implementare Comparable
    SortedSet<Network> networkSet = new TreeSet<>();

    public Network addNetwork(String SSID, Double frequency){
        Network net = new Network(SSID, frequency);
        networkSet.add(net);
        return net;
    }
    public Network strongest(){
        return networkSet.first();
    }

    class Network implements Comparable<Network>{
        private String SSID;
        private Double frequency;

        private Network(String SSID, Double frequency) {
            this.SSID = SSID;
            this.frequency = frequency;
        }

        public void updateStrength(Double newFrequency){
            networkSet.remove(this);
            frequency = newFrequency;
            networkSet.add(this);
        }

        @Override
        public int compareTo(Network o) {
            return o.frequency.compareTo(this.frequency);
            /*Ciò equivale a:
            * if(this.frequency>o.frequency) return -1;
            if(this.frequency<o.frequency) return 1;
            return 0;
            * */
        }

        @Override
        public String toString() {
            return "Network{" +
                    "SSID='" + SSID + '\'' +
                    ", frequency=" + frequency +
                    '}';
        }
    }
}
