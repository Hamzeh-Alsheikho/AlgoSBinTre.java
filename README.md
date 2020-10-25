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
- Laget EksamenSBinTre main klasse, og sjekket at det ikke gir noen syntaksfeil. 
  når vi bruker både Integer , Character og String som datatyper.
  kjørte System.out.println("Hello world"); for å kjekke det er ikke noe proble med utskft.
  
* Oppgave 1:
  A. Jeg kommented ut all throw expetions //throw new UnsupportedOperationException("Ikke kodet ennå!");//
  ellers vi kan ikke kjøre programme på grunn av feilien messtage
  // Exception in thread "main" java.lang.UnsupportedOperationException: Ikke kodet ennå!
     	at no.oslomet.cs.algdat.Eksamen.java.EksamenSBinTre.leggInn(EksamenSBinTre.java:86)
     	at no.oslomet.cs.algdat.Eksamen.java.Main.main(Main.java:9)//
  B. Jeg kopieret Programkode 5.2 3 a) form komdendum.
  C. Her har jeg opprettert en ny node q og kjørte testen.
  D. Testen er grønn, og det ser ut al alt fugerer bra. 
  E. Jeg pliuset anttall endringen.

* Oppgave 2: 
  A. Jeg kommentet ut exception //throw new UnsupportedOperationException("Ikke kodet ennå!");
  B. Jeg kaller Noden //P//. 
  D. så bruker vi while lokke. så har vi compare vediene //P.
  etter jeg har kjørte testen. det gikk bra utentatt en feil i Oppgave 2a
  //Oppgave 2a: Feil antall(T)-metoden!//
  - Det viser seg at det var en feil i lokken, etter fixing, ble det to feiler, 
  //Oppgave 2b: Skal ikke kaste unntak her!
    Oppgave 2c: Feil antall(T)-metoden!// men en av de er anklet å håntere.
  C. jeg compare verdi to p verdi, hvis større den går til høyre.
     elles den gå til venstre.
     
* Oppgave 3:
   //førstePostorden
  A. Jeg prøver å code med noe steps her, hvis p har et høyre subtre, så er den neste helt til venstre i det subtreet
  B. p har ikke et høyre subtre, den neste befinner seg dermed over p i treet
  C. hvis p er det høyre barnet til foreldren sin, er det besteforeldren som er den neste
  D. hvis p er det venstre barnet til foreldren sin, er det foreldren som er den neste.
  E. siden høyrebarna blir satt til p.forelder i while-løkken over, så tilsvarer dette å sette p = p.forelder.forelder for høyrebarna.
  Obs. coden er fra Programkode 5.1.7 g.
  //nestePostorden
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
    -- Førsteposteorden var helt rikktig, men nestepostorden var komplisert det hjlup å tegne treet.
    Jeg får hjelpe node q som represrntere p parents.
    - Tillslutt førstePostorden var fra kompendiet Programkode 5.1.7 h)
    - nestePostorden brukte et prggram for å tegne treet. prgramme het: 
    Binary Search Tree //https://www.cs.usfca.edu/~galles/visualization/BST.html//
    for å komme fram til nest node. 
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
    H. vi sjekker verdien av p på den andre siden av treet
    