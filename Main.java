public class Main
{
    public static Aeroporto aeroporto;
    public Main()
    {
        main(new String[1]);
    }
    public void prova(){
        aeroporto.torreDiControllo.aerei.put("ABCDE",new Aereo("Boeing 747", Stato.inAria, aeroporto));
    }
    public static void main(String args[]){
        aeroporto = new Aeroporto();
        aeroporto.torreDiControllo.generaAerei();
        aeroporto.finestra.concludi();
        aeroporto.torreDiControllo.start();
    }
}