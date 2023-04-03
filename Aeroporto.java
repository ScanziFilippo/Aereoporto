public class Aeroporto
{
    Grafica finestra;
    Pista sinistra;
    Pista destra;
    TorreDiControllo torreDiControllo;
    public Aeroporto()
    {
        finestra = new Grafica();
        sinistra = new Pista("L");
        destra = new Pista("R");
        torreDiControllo = new TorreDiControllo(this);
    }
}
