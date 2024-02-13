package ExoClientCommande;

public class Commande {
    Panier panier;
    float totalTTC;
    boolean validee = false;
    public Commande(Panier panier) {
        this.panier = panier;
        this.totalTTC = panier.getTotalTTC();
    }

    public void valider() {
        this.validee = true;
    }
}
