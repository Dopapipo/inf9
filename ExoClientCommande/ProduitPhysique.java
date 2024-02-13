package ExoClientCommande;

public class ProduitPhysique extends Produit {
    float fraisDeLivraison;
    public ProduitPhysique(float prix, String nom, String description, int stock, int id, float fraisDeLivraison) {
        super(prix, nom, description, stock, id);
        this.fraisDeLivraison = fraisDeLivraison;
    }
}
