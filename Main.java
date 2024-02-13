import ExoCalculatrice.Calculateur;
import ExoCalculatrice.Nombre;

public class Main {
    public static void main(String[] args) {
        Nombre a = new Nombre(5.0f);
        Nombre b = new Nombre(3.0f);
        Calculateur c = new Calculateur(a, b);
        System.out.println(c.addition().getValeur());
        System.out.println(c.soustraction().getValeur());
    }
}
