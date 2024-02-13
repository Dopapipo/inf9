package fr.pantheonsorbonne.cri;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;

public class CommandeTest {

    private Commande commande;
    private Panier panier;

    @BeforeEach
    public void setUp() {
        panier = new Panier();
        panier.ajouterProduit(new Produit(10.0f, "Produit 1", "Description produit 1", 5, 1), 2);
        panier.ajouterProduit(new Produit(20.0f, "Produit 2", "Description produit 2", 10, 2), 3);
        Date date = new Date();
        commande = new Commande(panier, date);
    }

    @Test
    public void testCreationCommande() {
        assertNotNull(commande);
        assertEquals(80.0f, commande.totalTTC);
        assertFalse(commande.validee);
        assertNotNull(commande.date);
    }

    @Test
    public void testValiderCommande() {
        assertFalse(commande.validee);
        commande.valider();
        assertTrue(commande.validee);
    }
}
