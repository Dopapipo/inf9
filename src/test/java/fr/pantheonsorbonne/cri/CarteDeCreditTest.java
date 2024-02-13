package fr.pantheonsorbonne.cri.ClientCommandeTest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import cri.pantheonsorbonne.CarteDeCredit;

public class CarteDeCreditTest{

     @Test
    public void testPayer_sufficientFunds() {
        CarteDeCredit carte = new CarteDeCredit("1234567890123456", 123, "12/24", 1000.0);
        assertTrue(carte.payer(500));
        assertEquals(500.0, carte.getArgentDisponible(), 0.01);
    }

    @Test
    public void testPayer_insufficientFunds() {
        CarteDeCredit carte = new CarteDeCredit("1234567890123456", 123, "12/24", 100.0);
        assertFalse(carte.payer(200));
        assertEquals(100.0, carte.getArgentDisponible(), 0.01);
    }

    @Test
    public void testVerifierCarte_validData() {
        CarteDeCredit carte = new CarteDeCredit("1234567890123456", 123, "12/24", 1000.0);
        assertTrue(carte.verifierCarte("1234567890123456", 123, "12/24"));
    }

    @Test
    public void testVerifierCarte_invalidData() {
        CarteDeCredit carte = new CarteDeCredit("1234567890123456", 123, "12/24", 1000.0);
        assertFalse(carte.verifierCarte("9876543210987654", 456, "06/23"));
    }

    @Test
    public void testDeposerArgent_positiveAmount() {
        CarteDeCredit carte = new CarteDeCredit("1234567890123456", 123, "12/24", 1000.0);
        assertTrue(carte.deposerArgent(200));
        assertEquals(1200.0, carte.getArgentDisponible(), 0.01);
    }

    @Test
    public void testDeposerArgent_negativeAmount() {
        CarteDeCredit carte = new CarteDeCredit("1234567890123456", 123, "12/24", 1000.0);
        assertFalse(carte.deposerArgent(-200));
        assertEquals(1000.0, carte.getArgentDisponible(), 0.01);
    }

       
}
