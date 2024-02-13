package ExoClientCommande;

import java.util.ArrayList;
import java.util.List;

public class Client {
    CarteDeCredit carteDeCredit;
    Panier panier;
    String nom;
    String prenom;
    String adresse;
    String email;
    String telephone;
    List <Commande> commandesPassees = new ArrayList<>();

    public Client(String nom, String prenom, String adresse, String email, String telephone,
            CarteDeCredit carteDeCredit) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.email = email;
        this.telephone = telephone;
        this.carteDeCredit = carteDeCredit;
    }

    public void ajouterProduit(Produit produit, int quantite) {
        panier.ajouterProduit(produit, quantite);
    }

    public void ajouterProduit(Produit produit) {
        panier.ajouterProduit(produit);
    }

    public void retirerProduit(Produit produit) {
        panier.retirerProduit(produit);
    }

    public void retirerProduit(Produit produit, int quantite) {
        for (int i = 0; i < quantite; i++) {
            retirerProduit(produit);
        }
    }

    public void validerCommande() {
        Commande commande = new Commande(panier);
        if (this.carteDeCredit.payer(panier.getTotalTTC())) {
            commande.valider();
        }
        commandesPassees.add(commande);
    }

}
