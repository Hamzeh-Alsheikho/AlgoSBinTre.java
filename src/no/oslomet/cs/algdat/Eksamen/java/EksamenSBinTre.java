package no.oslomet.cs.algdat.Eksamen.java;


import java.util.*;

public class EksamenSBinTre<T> {
    private static final class Node<T>   // en indre nodeklasse
    {
        private T verdi;                   // nodens verdi
        private Node<T> venstre, høyre;    // venstre og høyre barn
        private Node<T> forelder;          // forelder

        // konstruktør
        private Node(T verdi, Node<T> v, Node<T> h, Node<T> forelder) {
            this.verdi = verdi;
            venstre = v;
            høyre = h;
            this.forelder = forelder;
        }

        private Node(T verdi, Node<T> forelder)  // konstruktør
        {
            this(verdi, null, null, forelder);
        }

        @Override
        public String toString() {
            return "" + verdi;
        }

    } // class Node

    private Node<T> rot;                            // peker til rotnoden
    private int antall;                             // antall noder
    private int endringer;                          // antall endringer

    private final Comparator<? super T> comp;       // komparator

    public EksamenSBinTre(Comparator<? super T> c)    // konstruktør
    {
        rot = null;
        antall = 0;
        comp = c;
    }

    public boolean inneholder(T verdi) {
        if (verdi == null) return false;

        Node<T> p = rot;

        while (p != null) {
            int cmp = comp.compare(verdi, p.verdi);
            if (cmp < 0) p = p.venstre;
            else if (cmp > 0) p = p.høyre;
            else return true;
        }

        return false;
    }

    public int antall() {
        return antall;
    }

    public String toStringPostOrder() {
        if (tom()) return "[]";

        StringJoiner s = new StringJoiner(", ", "[", "]");

        Node<T> p = førstePostorden(rot); // går til den første i postorden
        while (p != null) {
            s.add(p.verdi.toString());
            p = nestePostorden(p);
        }

        return s.toString();
    }

    public boolean tom() {
        return antall == 0;
    }

    public boolean leggInn(T verdi) {
       //throw new UnsupportedOperationException("Ikke kodet ennå!");
        Objects.requireNonNull(verdi, "Ulovlig med nullverdier!");

        Node<T> p = rot, q = null;               // p starter i roten
        int cmp = 0;                             // hjelpevariabel

        while (p != null)       // fortsetter til p er ute av treet
        {
            q = p;                                 // q er forelder til p
            cmp = comp.compare(verdi,p.verdi);     // bruker komparatoren
            p = cmp < 0 ? p.venstre : p.høyre;     // flytter p
        }

        // p er nå null, dvs. ute av treet, q er den siste vi passerte

        p = new Node<>(verdi,q);                   // oppretter en ny node

        if (q == null) rot = p;                  // p blir rotnode
        else if (cmp < 0) q.venstre = p;         // venstre barn til q
        else q.høyre = p;                        // høyre barn til q

        antall++;
        endringer++;                              // én verdi mer i treet
        return true;                             // vellykket innlegging
    }

    public boolean fjern(T verdi) {

        //throw new UnsupportedOperationException("Ikke kodet ennå!");
        return true;

    }

    public int fjernAlle(T verdi) {
        //throw new UnsupportedOperationException("Ikke kodet ennå!");
        return 0;
    }

    public int antall(T verdi) {
        //throw new UnsupportedOperationException("Ikke kodet ennå!");
        int antall = 0;
        if (inneholder(verdi)){

            Node<T> p = rot;
            while (p != null){
                int c = comp.compare(verdi, p.verdi);
            if (c<0)
                p = p.venstre;
                else {
                if (c == 0)
                    antall++;
                p=p.høyre;
            }
            }

        }

        return antall;
    }

    public void nullstill() {
        //throw new UnsupportedOperationException("Ikke kodet ennå!");
    }

    private static <T> Node<T> førstePostorden(Node<T> p) {
        //throw new UnsupportedOperationException("Ikke kodet ennå!");
        while (true)   // Denne koden er fra kompendiet Programkode 5.1.7 h)
        {
            if (p.venstre != null)
                p = p.venstre;
            else if (p.høyre != null) p = p.høyre;
            else return p;
        }

    }

    private static <T> Node<T> nestePostorden(Node<T> p) {
        //throw new UnsupportedOperationException("Ikke kodet ennå!");
        Node<T> q = p.forelder;      //hjelpenode. q skal være forelder til p
        // Vi løper gjennom while loke, å lenge parent til P ikke null
        while(q != null) {
            //
            if(p == q.høyre) return q;   // Vi får parent hvis p likke sin parent.
            if (p == q.venstre) {
                if (q.høyre == null) {  // Her er p er alene barn
                    return q;
                    // Vi kjekker venstere siden først av treet
                    // er p høyrebarnet til q eller q ikke har et høyrebarn så er q den neste

                } else if (q.høyre.venstre != null && q.høyre.venstre.venstre != null) {
                    return q.høyre.venstre.venstre;
                    // så kjekker høyre siden av treet
                } else if (q.høyre.venstre != null && q.høyre.venstre.venstre == null) {
                    return q.høyre.venstre;

                } else if (q.høyre.høyre == null) {
                    return q.høyre;
                    //hvis p er venstrebarnet til q og det eksisterer et høyre subtre for q er den første
                    // førstePostorden der den neste
                } else {
                    return førstePostorden(q.høyre);   //verdien er funnet
                }
            }
        }
        return null;
    }

    public void postorden(Oppgave<? super T> oppgave) {
        //throw new UnsupportedOperationException("Ikke kodet ennå!");
        Node<T> p = førstePostorden(rot); // (oppretter ny node pekere) vi tar p som rot til førstepst
        while (p != null){                // Vi løpper gjennom while loke så lenge den ikke null
            oppgave.utførOppgave(p.verdi);   //keller vi interface
            p=nestePostorden(p);}            // går videre of flytte pekeren fra første til nest

    }

    public void postordenRecursive(Oppgave<? super T> oppgave) {
        postordenRecursive(rot, oppgave);
    }

    private void postordenRecursive(Node<T> p, Oppgave<? super T> oppgave) {
        //throw new UnsupportedOperationException("Ikke kodet ennå!");
    }

    public ArrayList<T> serialize() {
        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }

    static <K> EksamenSBinTre<K> deserialize(ArrayList<K> data, Comparator<? super K> c) {
        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }


} // ObligSBinTre
