package ExoCalculatrice;
public class Calculateur {
    Nombre a;
    Nombre b;
    OpAjout add = new OpAjout();
    OpSoustraction sub = new OpSoustraction();

    public Calculateur(Nombre a, Nombre b) {
        this.a = a;
        this.b = b;
    }
    public Calculateur() {
        this.a = null;
        this.b = null;
    }   

    public Nombre addition() {
        if (a!= null && b!= null) {

            return add.execute(a, b);
        }
        return null;
    }
    /**
     * Always substracts the second number from the first number
     */
    public Nombre soustraction() {
        if (a!= null && b!= null) {
            return sub.execute(a, b);
        }
        return null;
    }
    public Nombre getFirst() {
        return a;
    }
    public Nombre getSecond() {
        return b;
    }
    public void setFirst(Nombre a) {
        this.a = a;
    }
    public void setSecond(Nombre b) {
        this.b = b;
    }
}
