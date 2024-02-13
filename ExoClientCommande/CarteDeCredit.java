package ExoClientCommande;

import java.util.Date;

public class CarteDeCredit {
    int numero;
    int cvv;
    Date dateExpiration;
    float argentDisponible;

    public boolean payer(float amount) {
        if (argentDisponible >= amount) {
            argentDisponible -= amount;
            return true;
        }
        return false;
    }

    public boolean verifierCarte(int numero, int cvv, Date dateExpiration) {
        return this.numero == numero && this.cvv == cvv && this.dateExpiration.equals(dateExpiration);
    }
    public boolean deposerArgent(int argent) {
        if (argent < 0) return false; // On ne peut pas déposer un montant négatif (retrait d'argent)
        argentDisponible += argent;
        return true;
    }
    

}
