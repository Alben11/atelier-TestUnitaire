package ca.cegepmv.atelier;

/**
 * Petite calculatrice utilisée comme exemple pour l'atelier sur les tests unitaires.
 * Aucune dépendance externe, aucune base de données : uniquement de la logique pure,
 * facile à tester.
 */
public class Calculatrice {

    /**
     * Additionne deux entiers.
     */
    public int additionner(int a, int b) {
        return a + b;
    }

    /**
     * Soustrait b de a.
     */
    public int soustraire(int a, int b) {
        return a - b;
    }

    /**
     * Multiplie deux entiers.
     */
    public int multiplier(int a, int b) {
        return a * b;
    }

    /**
     * Divise a par b.
     *
     * @throws ArithmeticException si b vaut 0
     */
    public int diviser(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division par zéro impossible");
        }
        return a / b;
    }

    /**
     * Indique si n est un nombre pair.
     */
    public boolean estPair(int n) {
        return n % 2 == 0;
    }

    /**
     * Retourne le plus grand des deux entiers.
     */
    public int max(int a, int b) {
        return Math.max(a, b);
    }

    /**
     * Indique si n est un nombre premier.
     * Rappel : un nombre premier est un entier supérieur à 1 qui n'a que deux diviseurs
     * distincts, 1 et lui-même.
     */
    public boolean estPremier(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
