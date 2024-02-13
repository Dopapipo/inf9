package ExoClientCommande;

public class CarteDeCredit {
    String numero;
    int cvv;
    String dateExpiration;
    double argentDisponible;
    public CarteDeCredit(String numero, int cvv, String dateExpiration, double argentDisponible) {
        this.numero = numero;
        this.cvv = cvv;
        this.dateExpiration = dateExpiration;
        this.argentDisponible = argentDisponible;
    }
    public boolean payer(float amount) {
        if (argentDisponible >= amount) {
            argentDisponible -= amount;
            return true;
        }
        return false;
    }

    public boolean verifierCarte(String numero, int cvv, String dateExpiration) {
        return this.numero.equals(numero) && this.cvv == cvv && this.dateExpiration.equals(dateExpiration);
    }
    public boolean deposerArgent(int argent) {
        if (argent < 0) return false; // On ne peut pas déposer un montant négatif (retrait d'argent)
        argentDisponible += argent;
        return true;
    }

    public double getArgentDisponible() {
        return argentDisponible;
    }


}
