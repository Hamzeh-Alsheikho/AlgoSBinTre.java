# Mappeeksamen i Algoritmer og Datastrukturer Høst 2020

# Krav til innlevering

Se oblig-tekst for alle krav, og husk spesielt på følgende:

* Git er brukt til å dokumentere arbeid (minst 2 commits per oppgave, beskrivende commit-meldinger)	
* git bundle er levert inn
* Hovedklassen ligger i denne path'en i git: src/no/oslomet/cs/algdat/Eksamen/EksamenSBinTre.java
* Ingen debug-utskrifter
* Alle testene i test-programmet kjører og gir null feil (også spesialtilfeller)
* Readme-filen her er fyllt ut som beskrevet


# Beskrivelse av oppgaveløsning (4-8 linjer/setninger per oppgave)

Vi har brukt git til å dokumentere arbeidet vårt. Jeg har 16 commits totalt, og hver logg-melding beskriver det jeg har gjort av endringer.

* Oppgave 0:
  - Jeg start med å lage den opprinnelige utleverte kildekonden.
  - Laget EksamenSBinTre main klasse, og sjekket at den gir ikke  noen syntaksfeil. 
    når vi bruker både Integer , Character og String som datatyper.
    kjørte System.out.println("Hello world"); for å kjekke det er ikke noe proble med utskrift.
  
* Oppgave 1:
  A. Jeg kommentarte ut exception //throw new UnsupportedOperationException("Ikke kodet ennå!");ennå!");//
    ellers vi kan ikke kjøre programme på grunn av feilien messtage
    // Exception in thread "main" java.lang.UnsupportedOperationException: Ikke kodet ennå!
     	at no.oslomet.cs.algdat.Eksamen.java.EksamenSBinTre.leggInn(EksamenSBinTre.java:86)
     	at no.oslomet.cs.algdat.Eksamen.java.Main.main(Main.java:9)//
  B. Jeg kopieret Programkode 5.2 3 a) fra kompendet.
  C. Her har jeg opprettert en ny node q og kjørte testen.
  D. Testen er grønn, og det ser ut al alt fugerer bra. 
  E. Jeg pluset anttall og endringen.

* Oppgave 2: 
  A. Jeg kommentarte ut exception //throw new UnsupportedOperationException("Ikke kodet ennå!");
  B. Jeg kaller Noden //P//. 
  D. så bruker vi while lokke. så har vi compare vediene //P.
    etter jeg har kjørte testen. det gikk bra utentatt en feil i Oppgave 2a
    //Oppgave 2a: Feil antall(T)-metoden!//
  - Det viser seg at det var en feil i lokken, etter fixing, ble det to feiler, 
  //Oppgave 2b: Skal ikke kaste unntak her!
    Oppgave 2c: Feil antall(T)-metoden!// men en av de er anklet å håntere.
  C. jeg compare verdi to p verdi, hvis større enn 0 den går til høyre.
     elles den gå til venstre.
     
* Oppgave 3:
   - Første delen førstePostorden
  A. Jeg prøver å code med noe steps her, hvis p har et høyre subtre, så er den neste helt til venstre i det subtreet
  B. p har ikke et høyre subtre, den neste befinner seg dermed over p i treet
  C. hvis p er det høyre barnet til foreldren sin, er det besteforeldren som er den neste
  D. hvis p er det venstre barnet til foreldren sin, er det foreldren som er den neste.
  E. siden høyrebarna blir satt til p.forelder i while-løkken over, så tilsvarer dette å sette p = p.forelder.forelder for høyrebarna.
   Obs. coden er fra Programkode 5.1.7 g.
  - Den andre delen nestePostorden
  A. her har jeg det sammme code men, men fortsatt en fiel
     // Oppgave 3e: Her kastes et unntak! Det skal ikke skje!
     etter debuging står det S 10.
  - den forrje koden funket ikke, så prøver jeg en annen kode fra forlesningen
    testen ble grønn men har noen feiler.
    //Oppgave 3d: Feil i toStringPostOrder()! Men feilen kan
    ligge i leggInn() eller i nesteInorden().
    Oppgave 3f: Feil i toStringPostOrder()! Men feilen kan
    ligge i leggInn() eller i nesteInorden().
    Oppgave 3g: Feil i toStringPostOrder()! Men feilen kan
    ligge i leggInn() eller i nesteInorden().
    - Førsteposteorden var helt rikktig, men nestepostorden var komplisert det hjlup å tegne treet.
    Jeg får hjelpe node q som represrntere p parents.
    - Tillslutt førstePostorden var fra kompendiet Programkode 5.1.7 h)
    - nestePostorden brukte et prggram for å tegne treet. prgramme het: 
    Binary Search Tree //https://www.cs.usfca.edu/~galles/visualization/BST.html//
    for å komme fram til nest node. 
    ///////////////////////////////////////
    - Nestepotorden andre forsøk:
    A. //throw new UnsupportedOperationException("Ikke kodet ennå!");
    B. hjelpenode. q skal være forelder til p
    C. er p høyrebarnet til q eller q ikke har et høyrebarn så er q den neste     
    D. Vi kjekker venstere siden først av treet
    E. er p høyrebarnet til q eller q ikke har et høyrebarn så er q den neste
    F. hvis p er venstrebarnet til q og det eksisterer et høyre subtre for q er den første
    G. førstePostorden der den neste
    
* Oppgave 4:
    - Første delen er postorden. 
    A. Jeg kommenterte ut throw exception for å kviten med null point exceptions. 
       //throw new UnsupportedOperationException("Ikke kodet ennå!");
    B. Oppretter ny node pekere) vi tar p som rot til førstepst.
    C. Vi løpper gjennom while loke så lenge den ikke null. 
    D. keller vi interface med verdien til p.
    E. går videre of flytte pekeren fra første til nest.
       Testen kunne ikke kjøres uten kodeing del to. feilmelingen var.
        //org.opentest4j.AssertionFailedError: 
        Expected :
        Actual   : 2 4 5 3 1 7 9 8 6 11 13 12 14 10//
    - Den andre delen postordenRecursive
    F. Jeg kommenterte ut throw exception for å kviten med null point exceptions. 
       //throw new UnsupportedOperationException("Ikke kodet ennå!");
    G. vi sjekker verdien i treet fra vernste siden først.
    H. vi sjekker verdien av p på den andre siden av treet.
    
* oppgave 5:
    - Første delen serialize
    A. Jeg kommenterte ut throw exception for å kviten med null point exceptions. 
       //throw new UnsupportedOperationException("Ikke kodet ennå!");
    B. Jeg lager en ny arraylist.
    C. vi sjekker roten om den er null
    D. vi lager en quese for å legge til elemtene.
        - så kaller vi medthoden.
        -forenkle argumenter
        - ende i basitilfelle.
    E. brefily, start ved å lage rot level 1, så level 2 og level 3. håntering treet fra venstre siden og så 
        høyre siden fra toppen og nedover.
    - Andre delen deserialize. 
    A. Jeg kommenterte ut throw exception for å kviten med null point exceptions. 
       //throw new UnsupportedOperationException("Ikke kodet ennå!");
    B. koding i følge til tisdag forelesning. Og lage queue for treet.
    C. vi kaller comparatoren her
    D. Vi lage en for like for each elemet og legge verding in
    
* oppgave 6:
    - Første delen er fjern
    A. Jeg kommenterte ut throw exception for å kviten med null point exceptions. 
       //throw new UnsupportedOperationException("Ikke kodet ennå!");
    B. koperte koden fra kompendet Løsningsforslag - oppgaver i Avsnitt 5.2.13
    C. Denne koden trenger noen endring for å til passe denne legginn oppgaven.
    - Andre delen er fjernAll
    D. Jeg kommenterte ut throw exception for å kviten med null point exceptions. 
       //throw new UnsupportedOperationException("Ikke kodet ennå!");
    E. vi sjekker om treet er alrede tomet.
    F. vi løper gjennom en for løke 
    G. oppdetere antallet
    - Testen kan ikke kjøres med mindre nullstillingen er kodet. fielen er:
    // Oppgave 6i: Feil i fjern(T)!
       Oppgave 6j: Feil i fjern(T)!
       Oppgave 6m: Feil i nullstill() - antall er feil!
       Oppgave 6n: Feil i nullstill()!//
       - Tredje delen er nullstill
    H. Denne koden er kopiert fra kompendiet Oppgave 5 Løsningsforslag - oppgaver i Avsnitt 5.2.8
    I. Jeg sjekker først om teert er tomt, hivs ikke, så nuller vi roten.
    J. Jeg opdetere antallet og endingene i treet.
    K. Jeg lager en privet viod som tar Node<T> p.
    L. Jeg nullstille venstre siden først og så høyre siden av treet.