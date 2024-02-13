package fr.pantheonsorbonne.cri.ExoClientCommande;

import java.util.Map;

public class CentreDistribution {
    Map<Produit, Integer> stockMap;

    public CentreDistribution(Map<Produit, Integer> stockMap) {
        this.stockMap = stockMap;
    }

    public void ajouterStock(Produit produit, int quantite) {
        if (stockMap.containsKey(produit)) {
            stockMap.put(produit, stockMap.get(produit) + quantite);
        } else {
            stockMap.put(produit, quantite);
        }
    }

    public void retirerStock(Produit produit, int quantite) {
        if (stockMap.containsKey(produit)) {
            stockMap.put(produit, stockMap.get(produit) - quantite);
        }
    }

    public boolean verifierStock(Produit produit, int quantite) {
        if (stockMap.containsKey(produit)) {
            return stockMap.get(produit) >= quantite;
        }
        return false;
    }

    public void validerCommande(Commande commande) {
        for (Map.Entry<Produit, Integer> entry : commande.panier.produits.entrySet()) {
            Produit produit = entry.getKey();
            int quantite = entry.getValue();
            retirerStock(produit, quantite);
        }
        commande.valider();
    }

}
