public class OpDivision extends Operation{
    
    @Override
    public Nombre execute(Nombre a, Nombre b) {
        if (a.getValeur() != null && b.getValeur() != null && b.getValeur() != 0){
            return new Nombre(a.getValeur() / b.getValeur());
        }
        return null;
    }
}
