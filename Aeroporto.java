public class Aeroporto
{
    Pista sinistra;
    Pista destra;
    TorreDiControllo torreDiControllo;
    public Aeroporto()
    {
        sinistra = new Pista("L");
        destra = new Pista("R");
        torreDiControllo = new TorreDiControllo(this);
    }
}
