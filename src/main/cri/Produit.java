package cri;

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

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Produit) {
            Produit produit = (Produit) obj;
            return produit.id == this.id;
        }
        return false;
    }

}
