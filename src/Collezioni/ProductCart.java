package Collezioni;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Nell’ambito di un sistema di commercio elettronico, implementare le classi Product e Cart (carrello
 * della spesa). Un prodotto è caratterizzato da descrizione e prezzo. Il tentativo di istanziare due
 * oggetti prodotto con la stessa descrizione deve produrre un’eccezione.
 * Un carrello può contenere diversi prodotti, compresi eventuali duplicati, ed offre le seguenti
 * funzionalità:
 * • Aggiungere un prodotto
 * • Rimuovere un prodotto
 * • Conoscere il prezzo totale dei prodotti inseriti
 * L’implementazione deve rispettare il seguente caso d’uso:
 */

public class ProductCart {
    public static void main(String[] args) {
        Product sedia = new Product("Sedia␣elegante", 100);
        Product tavolo = new Product("Tavolo␣di␣cristallo", 200);
        Cart cart = new Cart();
        cart.add(sedia);
        cart.add(tavolo);
        cart.add(sedia);
        System.out.println(cart. totalPrice ());
        cart.remove(sedia);
        System.out.println(cart. totalPrice ());
        Product sedia2 = new Product("Sedia␣elegante", 100);
    }
}

class Product {
    private String description;

    public double getPrice() {
        return price;
    }

    private double price;
    private static Set<String> productSet=new HashSet<>();

    public Product(String description, double price){
        if(productSet.add(description)){
            this.description = description;
            this.price = price;
        }
        else
            throw new IllegalArgumentException();
    }
}

class Cart {
    private final List<Product> productList;

    public Cart() {
        productList = new ArrayList<>();
    }

    public void add(Product p){
        productList.add(p);
    }

    public void remove(Product p){
        productList.remove(p);
    }

    public double totalPrice(){
        double total=0;
        for(Product p: productList){
            total=total+p.getPrice();
        }

        return total;
    }
}

