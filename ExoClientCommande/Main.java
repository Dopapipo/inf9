package ExoClientCommande;

public class Main {
    public static void main(String[] args) {
        ProduitPhysique p1 = new ProduitPhysique(10.0f, "p1", "p1", 10, 1, 5.0f);
        ProduitPhysique p2 = new ProduitPhysique(10.0f, "p1", "p1", 10, 1, 5.0f);
        ProduitDigital p3 = new ProduitDigital(10.0f, "p1", "p1", 10, 1);
        CarteDeCredit c1 = new CarteDeCredit("1234123412341234", 123,"21/12/2025" , 2000.0 ); 
        Client cl1 = new Client("nom", "prenom", "adresse", "email", "telephone", c1);
        cl1.ajouterProduit(p1, 2);
        cl1.ajouterProduit(p2, 2);
        cl1.ajouterProduit(p3, 2);
        cl1.validerCommande();
        System.out.println(cl1.commandesPassees.get(0).validee);
        System.out.println(c1.argentDisponible);
    }
}
