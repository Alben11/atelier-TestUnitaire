package ca.cegepmv.atelier;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Atelier — Tests unitaires
 * =========================
 *
 * Objectif : revoir les bases des tests unitaires avec JUnit 6 en complétant les tests
 * manquants (marqués TODO) sur la classe {@link Calculatrice}.
 *
 * Rappels de vocabulaire :
 * - Un "cas de test" (test case) = une seule méthode annotée @Test qui vérifie UN
 *   comportement précis.
 * - Une "suite de tests" (test suite) = l'ensemble des cas de test d'une classe
 *   (ici, toute la classe CalculatriceTest).
 * - Une "assertion" = un appel assertXxx(...) qui compare le résultat obtenu au résultat
 *   attendu. Si l'assertion échoue, le test échoue.
 * - Patron AAA : Arrange (préparer les données), Act (appeler la méthode testée),
 *   Assert (vérifier le résultat).
 *
 * Consigne : complétez chaque méthode marquée "// TODO" en suivant le patron AAA.
 * Ne modifiez pas les tests déjà fournis (niveau 1), ils servent d'exemple.
 */
class CalculatriceTest {

    private final Calculatrice calculatrice = new Calculatrice();

    // ------------------------------------------------------------------
    // Niveau 1 — Assertions simples (déjà fournis, à titre d'exemple)
    // ------------------------------------------------------------------

    @Test
    void additionnerDeuxNombresPositifs() {
        // Arrange
        int a = 2;
        int b = 3;

        // Act
        int resultat = calculatrice.additionner(a, b);

        // Assert
        assertEquals(5, resultat);
    }

    @Test
    void soustraireDonneLaDifference() {
        // Arrange
        int a = 10;
        int b = 4;

        // Act
        int resultat = calculatrice.soustraire(a, b);

        // Assert
        assertEquals(6, resultat);
    }

    // ------------------------------------------------------------------
    // Niveau 1 — À vous de jouer (suivez le même modèle que ci-dessus)
    // ------------------------------------------------------------------

    @Test
    void multiplierDeuxNombres() {
        // TODO: Arrange - Act - Assert
        int a = 10;
        int b = 4;
        int resultat = calculatrice.multiplier(a, b);
        // Vérifiez que multiplier(4, 5) retourne 20
        assertEquals(20, resultat  "la multiplication de 4 et 5 devrait être 20");
        fail("Test à compléter");
    }

    @Test
    void maxRetourneLePlusGrandDesDeuxNombres() {
        // TODO: Arrange - Act - Assert
        // Vérifiez que max(7, 3) retourne 7
        int a = 7;
        int b = 3;
        int resultat = calculatrice.max(a, b);
        //fail("Test à compléter");
    }

    // ------------------------------------------------------------------
    // Niveau 2 — Comportements composés (assertAll, assertThrows)
    // ------------------------------------------------------------------

    @Test
    void estPairDistingueLesNombresPairsEtImpairs() {
        // TODO: utilisez assertAll(...) pour vérifier PLUSIEURS assertions dans un seul test :
        //  - estPair(4) doit être vrai
        //  - estPair(7) doit être faux
        //  - estPair(0) doit être vrai
        int a = 4;
        int b = 7;
        int c = 0;
        assertAll(
            () -> assertTrue(calculatrice.estPair(a), "4 devrait être pair"),
            () -> assertFalse(calculatrice.estPair(b), "7 devrait être impair"),
            () -> assertTrue(calculatrice.estPair(c), "0 devrait être pair")
        );
        //fail("Test à compléter");
    }

    @Test
    void diviserParZeroLanceUneException() {
        // TODO: utilisez assertThrows(ArithmeticException.class, () -> ...)
        // pour vérifier que diviser(10, 0) lance bien une ArithmeticException.
        int a = 10;
        int b = 0;
        assertThrows(ArithmeticException.class, () -> calculatrice.diviser(a, b), "Diviser par zéro devrait lancer une ArithmeticException");

    }

    // ------------------------------------------------------------------
    // Niveau 3 — Tests paramétrés (@ValueSource / @CsvSource) et cas limites
    // ------------------------------------------------------------------

    @ParameterizedTest
    @ValueSource(ints = {2, 3, 5, 7, 11, 13})
    void estPremierRetourneVraiPourLesNombresPremiersConnus(int nombre) {
        // TODO: Act + Assert
        // Vérifiez que estPremier(nombre) retourne true pour chacune des valeurs fournies.
        int resultat = calculatrice.estPremier(nombre);
        assertTrue(resultat, nombre + " devrait être premier");
        
    }

    @ParameterizedTest
    @CsvSource({
        "1, false",   // 1 n'est pas premier par définition
        "4, false",   // 4 = 2 x 2
        "9, false",   // 9 = 3 x 3
        "17, true"    // 17 est premier
        
    })
    void estPremierGereLesCasLimites(int nombre, boolean attendu) {
        // TODO: Act + Assert
        // Vérifiez que estPremier(nombre) correspond bien à la valeur "attendu".
        boolean resultat = calculatrice.estPremier(nombre);
        assertEquals(attendu, resultat, nombre + " devrait retourner " + attendu);

        
    }

    @Test
    void diviserAvecNombresNegatifs() {
        // TODO: Arrange - Act - Assert
        // Cas limite : que se passe-t-il quand on divise un nombre négatif ?
        // Vérifiez que diviser(-10, 2) retourne -5.
        int a = -10;
        int b = 2;
        int resultat = calculatrice.diviser(a, b);
        assertEquals(-5, resultat, "Diviser -10 par 2 devrait retourner -5");
        fail("Test à compléter");
    }
}
