package ExoClientCommande;

import java.util.Date;

public class Commande {
    int numero;
    Client client;
    Panier panier;
    float totalTTC;
    boolean validee = false;
    Date date;
    public Commande(Panier panier, Date date) {
        this.panier = panier;
        this.totalTTC = panier.getTotalTTC();
        this.date = date;
    }

    public void valider() {
        this.validee = true;
    }
    
}
