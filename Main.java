public class Main
{
    public Aeroporto aeroporto;
    public Main()
    {
        aeroporto = new Aeroporto();
        aeroporto.torreDiControllo.generaAerei();
    }
    public void prova(){
        aeroporto.torreDiControllo.aerei.put("ABCDE",new Aereo("Boeing 747", "inAria", aeroporto));
    }
}