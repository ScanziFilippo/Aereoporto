public class Aeroporto
{
    Grafica finestra;
    Pista sinistra;
    Pista destra;
    TorreDiControllo torreDiControllo;
    boolean[] parcheggiLiberi = {true, true, true, true, true, true};
    public Aeroporto()
    {
        finestra = new Grafica();
        sinistra = new Pista("L");
        destra = new Pista("R");
        torreDiControllo = new TorreDiControllo(this);
    }
    
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
