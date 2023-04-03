import java.util.Iterator;
import java.util.HashMap;

public class TorreDiControllo extends Thread
{
    HashMap<String,Aereo> aerei = new HashMap<>();
    Aeroporto aeroporto;
    public TorreDiControllo(Aeroporto aeroporto)
    {
        this.aeroporto = aeroporto;
    }
    public void generaAerei(){
        for(int i = 0;i < 10; i++){
            Aereo aereo = new Aereo(aeroporto);
            aerei.put(aereo.codice, aereo);
            aereo.start();
        }
    }
    public void run(){
        while(true){
        }
    }
    public Pista richiediPista(){
        return null;
    }
}
