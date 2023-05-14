/**
 * <p>Classe Main dove viene inizializzato tutto</p>
 * */
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
    /**
     * <p>Metodo main che crea l'istanza dell'aeroporto, generando gli aerei e aggiungendo lo sfondo alla finestra grafica</p>
     */
    public static void main(String args[]){
        aeroporto = new Aeroporto();
        aeroporto.torreDiControllo.generaAerei();
        aeroporto.finestra.concludi();
    }
}