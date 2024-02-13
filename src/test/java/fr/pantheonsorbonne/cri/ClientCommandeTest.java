package fr.pantheonsorbonne.cri;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;



public class ClientCommandeTest {

    @Test
    public void testPayer() {
        CarteDeCredit carte = new CarteDeCredit("123456789", 123, "12/12/2022", 100);
        assertTrue(carte.payer(50));
        assertEquals(50, carte.argentDisponible);
        assertFalse(carte.payer(100));
        assertEquals(50, carte.argentDisponible);
    }

    
}
