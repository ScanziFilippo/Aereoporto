import java.util.Iterator;
import java.util.HashMap;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;


public class TorreDiControllo extends Thread
{
    HashMap<String,Aereo> aerei = new HashMap<>();
    Aeroporto aeroporto;
    public TorreDiControllo(Aeroporto aeroporto)
    {
        this.aeroporto = aeroporto;
    }
    public void generaAerei(){
        Aereo sette47 = new Aereo("Boeing 747", Stato.inAria, aeroporto);
        aerei.put(sette47.codice, sette47);
        sette47.start();
        for(int i = 0;i < 5; i++){
            Aereo aereo = new Aereo(Stato.inAria, aeroporto);
            aerei.put(aereo.codice, aereo);
            aereo.start();
        }
    }
    public void run(){
        while(true){
            for(Aereo aereo:aerei.values()){
                if(aereo.stato == Stato.parcheggioPrenotato){
                    if(aeroporto.destra.richiediPista()){
                        aereo.stato = Stato.raggiungendoLaPistaD;
                        System.out.println(aereo.codice + " " + aereo.modello + " sta atterrando sulla pista di destra");
                    }else if(aeroporto.sinistra.richiediPista()){
                        aereo.stato = Stato.raggiungendoLaPistaS;
                        System.out.println(aereo.codice + " " + aereo.modello + " sta atterrando sulla pista di sinistra");
                    }
                }
            }
        }
    }
}
