package cri;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CentreDistribution {
    Map<Produit, Integer> stockMap;
    Map<Client, List<Commande>> commandesClients;

    public CentreDistribution(Map<Produit, Integer> stockMap) {
        this.stockMap = stockMap;
    }
    public CentreDistribution() {
        this.stockMap = new HashMap<>();
        this.commandesClients = new HashMap<>();
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
    public boolean verifierStock(Panier panier) {
        for (Map.Entry<Produit, Integer> entry : panier.produits.entrySet()) {
            Produit produit = entry.getKey();
            int quantite = entry.getValue();
            if (!verifierStock(produit, quantite)) {
                return false;
            }
        }
        return true;
    }
    public void validerCommande(Commande commande) {
        for (Map.Entry<Produit, Integer> entry : commande.panier.produits.entrySet()) {
            Produit produit = entry.getKey();
            int quantite = entry.getValue();
            retirerStock(produit, quantite);
        }
        commande.valider();
    }
    public void ajouterCommande(Client client, Commande commande) {
        if (commandesClients.containsKey(client)) {
            commandesClients.get(client).add(commande);
        } else {
            commandesClients.put(client, new ArrayList<>());
            commandesClients.get(client).add(commande);
        }
    }
}
