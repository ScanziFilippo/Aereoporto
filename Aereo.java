import java.security.SecureRandom;
import javax.swing.*;

public class Aereo extends Thread
{
    //database
    String caratteri = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String numeri = "0123456789";
    String[] modelliAerei = {"Boeing 737", "Boeing 747", "Boeing 777", "Boeing 787", "Airbus A320", "Airbus A330", "Airbus A380", "Embraer E175", "Bombardier CRJ900", "Cessna Citation X", "Gulfstream G650", "Embraer E190", "Bombardier Global 7500", "Dassault Falcon 7X", "Cessna 172", "Piaggio Avanti", "Pilatus PC-12", "Beechcraft King Air"};
    SecureRandom random = new SecureRandom();
    //aTerra, inAria, atterrando, decollando, inCoda
    String stato;
    String codice;
    String modello;
    Aeroporto aeroporto;
    JLabel immagine;
    public Aereo(Aeroporto aeroporto)
    {
        if(Math.random() < .5){
            stato = "aTerra";
        }else{
            stato = "inAria";
        }
        this.aeroporto = aeroporto;
        codice = generaCodice();
        modello = generaModello();
        immagine = new JLabel(new ImageIcon(generaImmagine()));
        aeroporto.finestra.add(immagine);
        System.out.println("Nuovo aereo " + stato + " creato " + codice + " " + modello);
    }
    public Aereo(String stato, Aeroporto aeroporto)
    {
        this.stato = stato;
        this.aeroporto = aeroporto;
        codice = generaCodice();
        modello = generaModello();
        System.out.println("Nuovo aereo " + stato + " creato " + codice + " " + modello);
    }
    public Aereo(String modello, String stato, Aeroporto aeroporto)
    {
        this.stato = stato;
        this.aeroporto = aeroporto;
        codice = generaCodice();
        this.modello = modello;
        immagine = new JLabel(new ImageIcon(generaImmagine()));
        aeroporto.finestra.add(immagine);
        System.out.println("Nuovo aereo " + stato + " creato " + codice + " " + modello);
    }
    public String generaCodice() {
        String stringa = "";
        for (int i = 0; i < 2; i++) {
            stringa += (caratteri.charAt(random.nextInt(caratteri.length())));
        }
        for (int i = 0; i < 3; i++) {
            stringa += (numeri.charAt(random.nextInt(numeri.length())));
        }
        stringa += (caratteri.charAt(random.nextInt(caratteri.length())));
        if(aeroporto.torreDiControllo.aerei.containsKey(stringa)){
            stringa = generaCodice();
        }
        return stringa;
    }
    
    public String generaModello(){
        return modelliAerei[random.nextInt(modelliAerei.length)];
    }
    
    public String generaImmagine(){
        System.out.println("immagini/" + modello + ".png");
        return "immagini/" + modello + ".png";
    }
    
    public void run(){
        if(stato == "inAria"){
            aeroporto.torreDiControllo.richiediPista();
        }
        
    }
}
