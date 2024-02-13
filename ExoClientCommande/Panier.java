package ExoClientCommande;

import java.util.List;

public class Panier {
    List<Produit> produits;

    public float getTotalTTC() {
        float total = 0;
        for (Produit produit : produits) {
            total+= produit.getPrix();
        }
        return total;
    }

    public List<Produit> getProduits() {
        return produits;
    }
}
