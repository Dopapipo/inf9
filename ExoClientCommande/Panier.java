package ExoClientCommande;

import java.util.HashMap;
import java.util.Map;

public class Panier {
    Map<Produit, Integer> produits;

    public Panier(Client client) {
        this.produits = new HashMap<>();
            
        };
    
    public float getTotalTTC() {
        float total = 0;
        for (Produit produit : produits.keySet()) {
            total += produit.getPrix() * produits.get(produit);
        }
        return total;
    }

    public Map<Produit,Integer> getProduits() {
        return produits;
    }

    public void ajouterProduit(Produit produit) {
        this.ajouterProduit(produit,1);
    }

    public void retirerProduit(Produit produit) {
        this.retirerProduit(produit,1);
    }
    public void retirerProduit(Produit produit, int quantite) {
        if (this.produits.containsKey(produit)) {
            this.produits.put(produit, this.produits.get(produit) - quantite);
            if (this.produits.get(produit) <= 0) {
                this.produits.remove(produit);
            }
        }
    }
    public void ajouterProduit(Produit produit, int quantite) {
        this.produits.putIfAbsent(produit, 0);
        this.produits.put(produit, this.produits.get(produit) + quantite);
    }


}