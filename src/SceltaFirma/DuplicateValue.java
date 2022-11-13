package SceltaFirma;

import java.util.*;

public class DuplicateValue {

    public static void main(String[] args) {
        Map<Integer,String> testMap = new HashMap<>();
        Set<String> result = new HashSet<>();

        testMap.put(1,"ciao");
        testMap.put(2,"ciao");
        testMap.put(3,"domani");
        testMap.put(4,"franco");
        testMap.put(5,"ciao");
        testMap.put(6,"domani");

        DuplicateValue.<String>duplicateValues(testMap, result);

        System.out.println(result);

    }

    //Uso un set di appoggio per passare i valori della mappa. Quando vi sarà un valore doppione non sarà possibile
    //inserirlo nel set di appoggio, quindi andrà inserito nel set passato come argomento
    public static <V> void duplicateValues(Map<?, ? extends V> map, Set<? super V> duplicates) {
        Collection<? extends V> values = map.values();
        Set<? super V> tmp = new HashSet<>();
        for(V element: values){
            if(!(tmp.add(element))) duplicates.add(element);
        }
    }
}
