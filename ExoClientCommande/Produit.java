package ExoClientCommande;

public class Produit {
    float prix;
    String nom;
    String description;
    int stock;
    int id;

    public Produit(float prix, String nom, String description, int stock, int id) {
        this.prix = prix;
        this.nom = nom;
        this.description = description;
        this.stock = stock;
        this.id = id;
    }


    public float getPrix() {
        return prix;
    }

}
