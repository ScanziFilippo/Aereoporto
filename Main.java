public class Main
{
    public Aeroporto aeroporto;
    public Main()
    {
        Grafica finestra = new Grafica();
        aeroporto = new Aeroporto();
        aeroporto.torreDiControllo.generaAerei();
    }
}