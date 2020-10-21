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
    