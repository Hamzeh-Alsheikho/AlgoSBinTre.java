package no.oslomet.cs.algdat.Eksamen.java;

@FunctionalInterface
public interface Oppgave<T>  // legges under hjelpeklasser
{
    void utførOppgave(T t);    // f.eks. utskrift til konsollet
}
