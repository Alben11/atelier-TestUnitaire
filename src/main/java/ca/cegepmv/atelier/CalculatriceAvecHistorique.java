package ca.cegepmv.atelier;

/**
 * Variante de la calculatrice qui dépend d'un {@link Journal} pour enregistrer chaque
 * opération effectuée. Cette dépendance est injectée par constructeur — c'est ce qui
 * permet de la remplacer par un "mock" (une doublure) dans les tests, sans jamais
 * toucher à un vrai journal (fichier, base de données, service distant, etc.).
 */
public class CalculatriceAvecHistorique {

    private final Journal journal;

    public CalculatriceAvecHistorique(Journal journal) {
        this.journal = journal;
    }

    /**
     * Additionne deux entiers et enregistre l'opération dans le journal.
     */
    public int additionner(int a, int b) {
        int resultat = a + b;
        journal.enregistrer(a + " + " + b + " = " + resultat);
        return resultat;
    }

    /**
     * Divise a par b et enregistre l'opération dans le journal.
     *
     * @throws ArithmeticException si b vaut 0 (aucun enregistrement n'est fait dans ce cas)
     */
    public int diviser(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division par zéro impossible");
        }
        int resultat = a / b;
        journal.enregistrer(a + " / " + b + " = " + resultat);
        return resultat;
    }
}
