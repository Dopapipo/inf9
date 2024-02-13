package fr.pantheonsorbonne.cri;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarteDeCreditTest {

    private CarteDeCredit carte;

    @BeforeEach
    public void setUp() {
        carte = new CarteDeCredit("1234567890123456", 123, "12/24", 1000.0);
    }

    @Test
    public void testPayer_sufficientFunds() {
        assertTrue(carte.payer(500));
        assertEquals(500.0, carte.getArgentDisponible(), 0.01);
    }

    @Test
    public void testPayer_insufficientFunds() {
        assertFalse(carte.payer(2000));
        assertEquals(1000.0, carte.getArgentDisponible(), 0.01); 
    }

    @Test
    public void testVerifierCarte_validData() {
        assertTrue(carte.verifierCarte("1234567890123456", 123, "12/24"));
    }

    @Test
    public void testVerifierCarte_invalidData() {
        assertFalse(carte.verifierCarte("9876543210987654", 456, "06/23"));
    }

    @Test
    public void testDeposerArgent_positiveAmount() {
        assertTrue(carte.deposerArgent(200));
        assertEquals(1200.0, carte.getArgentDisponible(), 0.01);
    }

    @Test
    public void testDeposerArgent_negativeAmount() {
        assertFalse(carte.deposerArgent(-200));
        assertEquals(1000.0, carte.getArgentDisponible(), 0.01);
    }
}
