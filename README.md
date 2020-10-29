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
        - Jeg komenterte ut alle throw new UnsupportedOperationException("Ikke kodet ennå!"); for å kunne kjøre koden. 
        
* Oppgave 1:
        B. Jeg kopieret Programkode 5.2.3 a) fra kompendet.
        C. Her har jeg opprettert en ny node q og kjørte testen. bruker komparatoren
        D. Testen er grønn, og det ser ut al alt fugerer bra. 
        E. Jeg pluset på anttall++ og endringen++. vellykket innlegging til slutt.
        
* Oppgave 2: 
        A. Denne koden er kopieert fra Programkodet 5.2.6 oppgave 2.
        B. Jeg kaller Noden //P//. 
        D. så bruker vi while lokke. så har vi compare vediene //P.
        C. Vi sjekker om verdien er inne eller alerde eksestere. 
        C. jeg compare verdi to p verdi, hvis større enn 0 den går til høyre.
         elles den gå til venstre.
         
* Oppgave 3:
        - Første delen førstePostorden
        A. Denne koden er kopieert fra Programkodet 5.1.7 h.
        
        - Den andre delen nestePostorden
        A. Jeg laget en hjelpenode. temp skal være forelder til p.
        B. Rr p høyrebarnet til temp eller temp ikke har et høyrebarn så er temp den neste.
        C. Vi kjekker venstere siden først av treet.
        D. Er p venstrebarnet til tem eller temp ikke har et venstrebarnet så er temp den neste.
        F. FørstePostorden der den neste.
         
* Oppgave 4:
        - Første delen er postorden. 
        A. Denne koden er kopieert fra Programkodet 5.1.7 a men koden var var for pretorden, må endre til postorden
        B. Oppretter ny node pekere) vi tar p som rot til førstepst.
        C. Vi løpper gjennom while loke så lenge den ikke null. 
        D. keller vi interface med verdien til p.
        E. går videre of flytte pekeren fra første til nest.
        
        - Den andre delen postordenRecursive
        G. vi sjekker verdien i treet fra vernste siden først.
        H. - så kaller vi medthoden. //Kaller seg selv
           -forenkle argumenter
           - ende i basitilfelle.
            
* oppgave 5:
        - Første delen serialize
        A. koding i følge til tisdag forelesning. Og lage queue for treet. 
        B. Jeg lager en ny arraylist. og lage ett nytt arrayet. Flytte elementer fra binarytre til arrayetlist.
        C. vi sjekker roten om den er null
        D. Hjelpe veriable for size
        E. vi lager en quese for å legge til elemtene til arrayet. venstre barn og høyre barn.
       
        - Andre delen deserialize. 
        A. Lag et nytt obiget fra klasset. Flytte elementer fra arrayetlist til bainarytre.
        B. vi kaller comparatoren her
        C. Vi lage en for like for each elemet og legge verding in.
        D. Brefily, start ved å lage rot level 1, så level 2 og level 3. håntering treet fra venstre siden og så 
           høyre siden fra toppen og nedover.
            
* oppgave 6:
        - Første delen er fjern 
        A. koperte koden fra kompendet Løsningsforslag - oppgaver i Avsnitt 5.2.13
        B. Denne koden trenger noen endring for å til passe denne legginn oppgaven.
        
        - Andre delen er fjernAll
        A. koperte koden fra kompendet Løsningsforslag - oppgaver i Avsnitt 5.2.8 oppgave 3.
        E. vi sjekker om treet er alerede tomet.
        F. vi løper gjennom en for løke og til slutt oppdetere vi antallet.
   
        - Tredje delen er nullstill
        H. Denne koden er kopiert fra kompendiet Oppgave 5 Løsningsforslag - oppgaver i Avsnitt 5.2.8
        I. Jeg sjekker først om teert er tomt, hivs ikke, så nuller vi roten.
        J. Jeg opdetere antallet og endingene i treet. hvis sluttet node har barn. venstre barnet blir forelder.
        K. Jeg lager en privet viod som tar Node<T> p. for å gjøre det rekrusive.
        L. Jeg nullstille venstre siden først og så høyre siden av treet.