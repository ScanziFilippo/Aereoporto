    /**
     * <p>Classe dell'aeroporto</p>
     */
public class Aeroporto
{

    Grafica finestra;
    Pista sinistra;
    Pista destra;
    TorreDiControllo torreDiControllo;
    boolean[] parcheggiLiberi = {true, true, true, true, true, true};
    Aereo[] parcheggi = {null, null, null, null, null, null};
    
    /**
     * <p>Crea la finestra, le due piste e la torre di controllo</p>
     */
    
    public Aeroporto()
    {
        finestra = new Grafica(this);
        sinistra = new Pista("L");
        destra = new Pista("R");
        torreDiControllo = new TorreDiControllo(this);
    }
    
    
    /**
     * <p>Assegna il primo parcheggio pronto, se disponibile</p>
     */
    int parcheggioLibero(){
        for(int i = 0; i < 6; i++){
            if(parcheggiLiberi[i]){
                parcheggiLiberi[i] = false;
                return i;
            }
        }
        return -1;
    }
}
