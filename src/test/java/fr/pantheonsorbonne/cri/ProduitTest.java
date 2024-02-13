package fr.pantheonsorbonne.cri;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ProduitTest {

    @Test
    public void testProduitEquals() {
        Produit produit1 = new Produit(10.0f, "Produit 1", "Description produit 1", 5, 1);
        Produit produit2 = new Produit(10.0f, "Produit 1", "Description produit 1", 5, 1);
        Produit produit3 = new Produit(20.0f, "Produit 2", "Description produit 2", 10, 2);

        assertTrue(produit1.equals(produit2));
        assertFalse(produit1.equals(produit3));
    }

    @Test
    public void testProduitPhysiqueGetPrix() {
        ProduitPhysique produitPhysique = new ProduitPhysique(10.0f, "Produit 1", "Description produit 1", 5, 1, 2.0f);

        assertEquals(12.0f, produitPhysique.getPrix());
    }

    @Test
    public void testProduitPhysiqueEquals() {
        ProduitPhysique produitPhysique1 = new ProduitPhysique(10.0f, "Produit 1", "Description produit 1", 5, 1, 2.0f);
        ProduitPhysique produitPhysique2 = new ProduitPhysique(10.0f, "Produit 1", "Description produit 1", 5, 1, 2.0f);
        ProduitPhysique produitPhysique3 = new ProduitPhysique(20.0f, "Produit 2", "Description produit 2", 10, 2, 3.0f);

        assertTrue(produitPhysique1.equals(produitPhysique2));
        assertFalse(produitPhysique1.equals(produitPhysique3));
    }

    @Test
    public void testProduitDigitalGetPrix() {
        ProduitDigital produitDigital = new ProduitDigital(10.0f, "Produit 1", "Description produit 1", 5, 1);

        assertEquals(10.0f, produitDigital.getPrix());
    }

    @Test
    public void testProduitDigitalEquals() {
        ProduitDigital produitDigital1 = new ProduitDigital(10.0f, "Produit 1", "Description produit 1", 5, 1);
        ProduitDigital produitDigital2 = new ProduitDigital(10.0f, "Produit 1", "Description produit 1", 5, 1);
        ProduitDigital produitDigital3 = new ProduitDigital(20.0f, "Produit 2", "Description produit 2", 10, 2);

        assertTrue(produitDigital1.equals(produitDigital2));
        assertFalse(produitDigital1.equals(produitDigital3));
    }
    
}
