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
        //Jeg kopieret Programkode 5.2.3 a) fra kompendet.
        Objects.requireNonNull(verdi, "Ulovlig med nullverdier!");

        Node<T> p = rot, q = null;               // p starter i roten
        int cmp = 0;                             // hjelpevariabel

        while (p != null)       // fortsetter til p er ute av treet
        {
            q = p;                                 // q er forelder til p
            cmp = comp.compare(verdi, p.verdi);     // bruker komparatoren
            p = cmp < 0 ? p.venstre : p.høyre;     // flytter p
        }

        // p er nå null, dvs. ute av treet, q er den siste vi passerte

        p = new Node<>(verdi, q);                   // oppretter en ny node

        if (q == null) rot = p;                  // p blir rotnode
        else if (cmp < 0) q.venstre = p;         // venstre barn til q
        else q.høyre = p;                        // høyre barn til q

        antall++;
        endringer++;                              // én verdi mer i treet
        return true;                             // vellykket innlegging
    }

    public boolean fjern(T verdi) {
        //throw new UnsupportedOperationException("Ikke kodet ennå!");
        //koperte koden fra kompendet Løsningsforslag - oppgaver i Avsnitt 5.2.13
        if (verdi == null) return false;  // treet har ingen nullverdier
        Node<T> p = rot, q = null;         // q skal være forelder til p
        while (p != null){                 // leter etter verdi
            int cmp = comp.compare(verdi,p.verdi);      // sammenligner
            if (cmp < 0) { q = p; p = p.venstre; }      // går til venstre
            else if (cmp > 0) { q = p; p = p.høyre; }   // går til høyre
            else break;                               // verdien er i p
        }
        if (p == null) return false;                      //  verdien finnes ikke
        if (p.venstre == null || p.høyre == null){             // første og andre tilfelle
            Node<T> b = p.venstre != null ? p.venstre : p.høyre;  // b får barn venstre og høyre
            if (b != null) b.forelder = q;
            if (p == rot) rot = b;
            else if (p == q.venstre) q.venstre = b;
            else q.høyre = b;
        }
        else{                                          // sist ilfelle
            Node<T> s = p, r = p.høyre;   // finner neste
            while (r.venstre != null)
            {
                s = r;                   // s blir forelder til r
                r = r.venstre;
            }
            p.verdi = r.verdi;           // flytte verdien til p fra r

            if (s != p) s.venstre = r.høyre;
            else s.høyre = r.høyre;
        }
        antall--;                           // vi minske en node i treet
        endringer++;
        return true;
    }

    public int fjernAlle(T verdi) {
        //throw new UnsupportedOperationException("Ikke kodet ennå!");
        //koperte koden fra kompendet Løsningsforslag - oppgaver i Avsnitt 5.2.8 oppgave 3.
        if(tom()) return 0;   // ingen verdier
        int fjernVerdi = 0;
        while (fjern(verdi)) //vi løper gjennom while løke
            fjernVerdi++;    // oppdetere antallet
        return fjernVerdi;
    }

    public int antall(T verdi) {
        //throw new UnsupportedOperationException("Ikke kodet ennå!");
        //Denne koden er kopieert fra Programkodet 5.2.6 oppgave 2.
        int antall = 0;
        if (inneholder(verdi)){    // vi tar vediene fra inneholeren
            Node<T> p = rot;         //antar p som rot
            while (p != null){        // while løke for comperatoren
                int cp = comp.compare(verdi, p.verdi);
            if (cp<0) p = p.venstre;         // mender enn 0 gå til venstre
                else { if (cp == 0)
                    antall++;
                p=p.høyre;                //  gå til høyre
            }
            }
        }
        return antall;
    }

    public void nullstill() {
        //throw new UnsupportedOperationException("Ikke kodet ennå!");
        //Denne koden er kopiert fra kompendiet Oppgave 5 Løsningsforslag - oppgaver i Avsnitt 5.2.8
        if (!tom()) nullstill(rot);  // nullstiller
        rot = null;
        antall = 0;           //oppdetere antallet
        endringer++;        // treet er endret
    }

    private void nullstill(Node<T> p)
    {
        if (p.venstre != null)
        {
            nullstill(p.venstre);      // venstre subtre
            p.venstre = null;           // nuller peker
        }
        if (p.høyre != null)
        {
            nullstill(p.høyre);           // høyre subtre
            p.høyre = null;               // nuller peker
        }
        p.verdi = null;                    // nuller verdien
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
        Node<T> temp = p.forelder;      //hjelpenode. temp skal være forelder til p
                 if (temp==null){ p= null;
            }else if (temp.høyre==p){ p=temp;  //er p høyrebarnet til temp eller temp ikke har et høyrebarn så er temp den neste
                // Vi kjekker venstere siden først av treet
                // er p venstrebarnet til tem eller temp ikke har et venstrebarnet så er temp den neste
            }else if (temp.venstre==p){
                if (temp.høyre==null){ p=temp;
                    //hvis p er venstrebarnet til temp og det eksisterer et høyre subtre for temp er den første
                    // førstePostorden der den neste
                }else p = førstePostorden(temp.høyre);
            }
            return p;
    }

    public void postorden(Oppgave<? super T> oppgave) {
        //throw new UnsupportedOperationException("Ikke kodet ennå!");
        //Denne koden er kopieert fra Programkodet 5.1.7 a men koden var var for pretorden, må endre til postorden
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
        if (p.venstre != null) postordenRecursive(p.venstre, oppgave); //vi sjekker verdien i treet fra vernste siden først
        // vi sjekker verdien av p på den andre siden av treet
        if (p.høyre != null) postordenRecursive(p.høyre, oppgave); //Kaller seg selv- forenkle argumenter - ende i basitilfelle.
        oppgave.utførOppgave(p.verdi);
    }

    public ArrayList<T> serialize() {
        //throw new UnsupportedOperationException("Ikke kodet ennå!");
        ArrayList<T> results = new ArrayList<>();  // lager en ny arrylist
        if (rot == null) {   // sjekker roten først
            return results;
        }
        Queue<Node<T>> q = new LinkedList<>();  // lager en queue som tar elementer in noden.
        q.add(rot);                             // legge til roten først til arryet
        while (!q.isEmpty()) {                  // vi løper gjennom en while løke
            int sizeOfqueue = q.size();          // Hjelpe veriable for size
            for (int i = 0; i < sizeOfqueue; i++) {
                Node<T> temp = q.remove();            // legge til venstre barn
                results.add(temp.verdi);
                if (temp.venstre != null) {
                    q.add(temp.venstre);
                }
                if (temp.høyre != null) {              // legge høyre barn
                    q.add(temp.høyre);
                }
            }
        }
        return results;
    }

    static <K> EksamenSBinTre<K> deserialize(ArrayList<K> data, Comparator<? super K> c)   {
        //throw new UnsupportedOperationException("Ikke kodet ennå!");
        EksamenSBinTre<K> result = new EksamenSBinTre<K>(c); // vi kaller comparatoren her
        for (K verdi : data) {                              // en loke for each
            result.leggInn(verdi);                           // vi legger verdier en og en til treet
        }
        return result;
    }
} // ObligSBinTre
