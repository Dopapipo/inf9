public class OpSoustraction extends Operation{

    @Override
    public Nombre execute(Nombre a, Nombre b) {
        if (a.getValeur() != null && b.getValeur() != null) {
            return new Nombre(a.getValeur() - b.getValeur());
        }
        return null;
    }
}
