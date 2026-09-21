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
        // Arrange
        int a = 4;
        int b = 5;

        // Act
        int resultat = calculatrice.multiplier(a, b);

        // Assert
        assertEquals(20, resultat, "La multiplication de 4 et 5 devrait être 20");
    }

    @Test
    void maxRetourneLePlusGrandDesDeuxNombres() {
        // Arrange
        int a = 7;
        int b = 3;

        // Act
        int resultat = calculatrice.max(a, b);

        // Assert
        assertEquals(7, resultat, "Le maximum entre 7 et 3 devrait être 7");
    }

    // ------------------------------------------------------------------
    // Niveau 2 — Comportements composés (assertAll, assertThrows)
    // ------------------------------------------------------------------

    @Test
    void estPairDistingueLesNombresPairsEtImpairs() {
        // Arrange
        int a = 4;
        int b = 7;
        int c = 0;

        // Act & Assert
        assertAll(
            () -> assertTrue(calculatrice.estPair(a), "4 devrait être pair"),
            () -> assertFalse(calculatrice.estPair(b), "7 devrait être impair"),
            () -> assertTrue(calculatrice.estPair(c), "0 devrait être pair")
        );
    }

    @Test
    void diviserParZeroLanceUneException() {
        // Arrange
        int a = 10;
        int b = 0;

        // Act & Assert
        assertThrows(ArithmeticException.class, () -> calculatrice.diviser(a, b), "Diviser par zéro devrait lancer une ArithmeticException");
    }

    // ------------------------------------------------------------------
    // Niveau 3 — Tests paramétrés (@ValueSource / @CsvSource) et cas limites
    // ------------------------------------------------------------------

    @ParameterizedTest
    @ValueSource(ints = {2, 3, 5, 7, 11, 13})
    void estPremierRetourneVraiPourLesNombresPremiersConnus(int nombre) {
        // Act & Assert
        assertTrue(calculatrice.estPremier(nombre), nombre + " devrait être premier");
    }

    @ParameterizedTest
    @CsvSource({
        "1, false",   // 1 n'est pas premier par définition
        "4, false",   // 4 = 2 x 2
        "9, false",   // 9 = 3 x 3
        "17, true"    // 17 est premier
    })
    void estPremierGereLesCasLimites(int nombre, boolean attendu) {
        // Act
        boolean resultat = calculatrice.estPremier(nombre);

        // Assert
        assertEquals(attendu, resultat, nombre + " devrait retourner " + attendu);
    }

    @Test
    void diviserAvecNombresNegatifs() {
        // Arrange
        int a = -10;
        int b = 2;

        // Act
        int resultat = calculatrice.diviser(a, b);

        // Assert
        assertEquals(-5, resultat, "Diviser -10 par 2 devrait retourner -5");
    }
}