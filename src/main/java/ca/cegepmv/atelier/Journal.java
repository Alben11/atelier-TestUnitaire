package ca.cegepmv.atelier;

/**
 * Dépendance externe simulée : un service de journalisation.
 * Dans un vrai projet, ceci pourrait écrire dans un fichier, une base de données,
 * envoyer les logs à un serveur distant, etc. — quelque chose qu'on ne veut PAS
 * vraiment exécuter pendant un test unitaire.
 *
 * C'est exactement le genre de dépendance qu'on "mock" (simule) dans un test.
 */
public interface Journal {

    /**
     * Enregistre un message dans le journal.
     */
    void enregistrer(String message);
}
