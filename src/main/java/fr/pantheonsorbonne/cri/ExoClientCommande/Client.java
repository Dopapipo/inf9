package fr.pantheonsorbonne.cri.ExoClientCommande;

import java.util.ArrayList;
import java.util.Date;
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
        this.panier = new Panier();
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

    public void payerCommande(Commande commande) {
        if (this.carteDeCredit.payer(panier.getTotalTTC())) {
            commande.valider();
        }
        commandesPassees.add(commande);
    }
    public boolean peutPayerCommande() {
        return this.carteDeCredit.getArgentDisponible() >= panier.getTotalTTC();
    }
    public void passerCommande(CentreDistribution centreDistribution) {
        if (this.verifierStock(centreDistribution) && this.peutPayerCommande()) {
            Commande commande = new Commande(panier, new Date());
            this.payerCommande(commande);
            centreDistribution.validerCommande(commande);
            commandesPassees.add(commande);
            centreDistribution.ajouterCommande(this, commande);
        }
        
    }
    public boolean verifierStock(CentreDistribution centreDistribution) {
        return centreDistribution.verifierStock(panier);
    }
}
