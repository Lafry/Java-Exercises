package Collezioni;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Realizzare per una biblioteca le classi Library e Book. Un oggetto Book è caratterizzato dal suo
 * titolo. La classe Library offre le seguenti funzionalità:
 *      • Un costruttore senza argomenti che crea una biblioteca vuota.
 *      • Il metodo addBook aggiunge un libro alla biblioteca. Se il libro era già stato aggiunto,
 *        restituisce false.
 *      • Il metodo loanBook prende un libro come argomento e lo dà in prestito, a patto che sia
 *        disponibile. Se quel libro è già in prestito, restituisce false. Se quel libro non è mai stato
 *        inserito nella biblioteca, lancia un’eccezione.
 *      • Il metodo returnBook prende un libro come argomento e restituisce quel libro alla biblioteca.
 *        Se quel libro non era stato prestato col metodo loanBook, il metodo returnBook lancia
 *        un’eccezione.
 *      • Il metodo printLoans stampa la lista dei libri attualmente in prestito, in ordine temporale
 *        (a partire dal libro in prestito da più tempo).
 *
 * Inoltre, rispondere alla seguente domanda: nella vostra implementazione, qual è la complessità
 * dei metodi loanBook e returnBook, rispetto al numero di libri n inseriti nella biblioteca?
 */

public class LibraryDriver {
    public static void main(String []args){
        Library lib = new Library();
        Book a = new Book("a"), b = new Book("b"),
                c = new Book("c"), d = new Book("d");
        System.out.println( lib .addBook(a));       // true
        System.out.println( lib .addBook(b));       // true
        System.out.println( lib .addBook(c));       // true
        System.out.println( lib .addBook(a));       // false
        System.out.println( lib .loanBook(b));      // true
        System.out.println( lib .loanBook(a));      // true
        System.out.println( lib .loanBook(a));      // false;
        lib.printLoans();                           // b
                                                    // a
        // Prova per verificare se lancia l'eccezione:
        lib.addBook(d);
        lib.booksLoaned.add(d);
        lib .returnBook(d);                          // throw IAE()
    }
}

class Library{
    private Set<Book> bookList = new HashSet<>();
    public List<Book> booksLoaned = new ArrayList<>();

    public boolean addBook(Book book){
        return bookList.add(book);
    }

    public boolean loanBook(Book book){
        if(!bookList.contains(book))
            throw new IllegalArgumentException();

        /**
         * Se il libro non è stato preso in presito
         * lo aggiungo alla lista dei libri in prestito e setto il flag a true,
         * altrimenti se è già in prestito ritorno false
         */
        if(!book.isLoan()) {
            booksLoaned.add(book);
            book.setLoan(true);
            return true;
        } else
            return false;
    }

    public boolean returnBook(Book book){
        if(!book.isLoan())
            throw new IllegalArgumentException();

        /**
         * Se sono qui allora il libro era stato preso in prestito,
         * ergo, lo rimuovo dalla lista dei libri in prestito e risetto il flag a false.
         */
        boolean result = booksLoaned.remove(book);
        book.setLoan(!result);
        return result;
    }

    public void printLoans(){
        System.out.println(booksLoaned);
    }

    @Override
    public String toString() {
        return "Library{" +
                "bookList=" + bookList +
                '}';
    }
}

class Book{
    private String title;
    private boolean isLoan;

    public Book(String title){
        this.title = title;
        this.isLoan = false;
    }

    public String getTitle() {
        return title;
    }

    public boolean isLoan() {
        return isLoan;
    }

    public void setLoan(boolean loan) {
        isLoan = loan;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                '}';
    }
}


