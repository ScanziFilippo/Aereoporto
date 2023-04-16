import java.security.SecureRandom;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Aereo extends Thread
{
    //database
    String caratteri = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String numeri = "0123456789";
    String[] modelliAerei = {"Boeing 737", "Boeing 747", "Boeing 777", "Boeing 787", "Airbus A380", "Embraer E175", "Bombardier CRJ900", "Bombardier Global 7500", "Cessna 172", "Piaggio Avanti", "Pilatus PC-12", "Beechcraft King Air"};
    SecureRandom random = new SecureRandom();
    String codice;
    String modello;
    Aeroporto aeroporto;
    JLabel immagine;
    int parcheggio;
    //aTerra, inAria, atterrando, decollando, inCoda
    Stato stato;
    public Aereo(Aeroporto aeroporto)
    {
        if(Math.random() < .5){
            stato = Stato.aTerra;
        }else{
            stato = Stato.inAria;
        }
        this.aeroporto = aeroporto;
        codice = generaCodice();
        modello = generaModello();
        ImageIcon icona = new ImageIcon(generaImmagine());
        immagine = new JLabel(icona);
        aeroporto.finestra.add(immagine);
        immagine.setSize(icona.getIconWidth(), icona.getIconHeight());
        immagine.setLocation(0,(int)(360 + Math.random()*560));
        System.out.println("Nuovo aereo " + stato + " creato " + codice + " " + modello);
    }
    public Aereo(Stato stato, Aeroporto aeroporto)
    {
        this.stato = stato;
        this.aeroporto = aeroporto;
        codice = generaCodice();
        modello = generaModello();
        ImageIcon icona = new ImageIcon(generaImmagine());
        immagine = new JLabel(icona);
        aeroporto.finestra.add(immagine);
        immagine.setSize(icona.getIconWidth(), icona.getIconHeight());
        immagine.setLocation(0,(int)(360 + Math.random()*560));
        System.out.println("Nuovo aereo " + stato + " creato " + codice + " " + modello);
    }
    public Aereo(String modello, Stato stato, Aeroporto aeroporto)
    {
        this.stato = stato;
        this.aeroporto = aeroporto;
        codice = generaCodice();
        this.modello = modello;
        ImageIcon icona = new ImageIcon(generaImmagine());
        immagine = new JLabel(icona);
        aeroporto.finestra.add(immagine);
        immagine.setSize(icona.getIconWidth(), icona.getIconHeight());
        immagine.setLocation(0,(int)(360 + Math.random()*560));
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
        //System.out.println("immagini/" + modello + ".png");
        //return "immagini/" + modello + " - ORIGINALE.png";
        return "immagini/" + modello + ".png";
    }
    
    public void run(){
        while(true){
            switch(stato) {
                case aTerra:
                    //System.out.println(codice + " " + modello + " è a terra");
                    break;
                case inAria:
                    //System.out.println(codice + " " + modello + " è in volo");
                    immagine.setLocation(immagine.location().x + 1, immagine.location().y);
                    if(immagine.getLocation().x > 1920){
                        immagine.setLocation(-200, immagine.location().y);
                    }
                    
                    try
                    {
                        Thread.sleep((long)((1d/immagine.getSize().height)*500));
                    }
                    catch (InterruptedException ie)
                    {
                        ie.printStackTrace();
                    }
                    parcheggio = aeroporto.parcheggioLibero();
                    if(parcheggio >= 0){
                        System.out.println(codice + " " + modello + " ha prenotato il parcheggio " + parcheggio);
                        stato = Stato.parcheggioPrenotato;
                    }
                    break;
                case parcheggioPrenotato:
                    immagine.setLocation(immagine.location().x + 1, immagine.location().y);
                    if(immagine.getLocation().x > 1920){
                        immagine.setLocation(-200, immagine.location().y);
                    }
                    try
                    {
                        Thread.sleep((long)((1d/immagine.getSize().height)*500));
                    }
                    catch (InterruptedException ie)
                    {
                        ie.printStackTrace();
                    }
                    
                    break;
                case atterrandoS:
                    immagine.setLocation(immagine.location().x - 1, 300 - immagine.getSize().height/2);
                    if(immagine.getLocation().x < 70){
                        aeroporto.sinistra.liberaPista();
                        System.out.println(codice + " " + modello + " sta procedendo verso il parcheggio");
                        stato = Stato.rullaggioAParcheggio;
                        ImageIcon icona = (ImageIcon) immagine.getIcon();
                        Image img = icona.getImage();
                        BufferedImage bufImg = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
                        Graphics2D g2 = bufImg.createGraphics();
                        g2.rotate(-Math.PI/2, bufImg.getWidth() / 2, bufImg.getHeight() / 2);
                        g2.drawImage(img, 0, 0, null);
                        g2.dispose();
                        int ampiezza = immagine.getSize().width;
                        int altezza = immagine.getSize().height;
                        immagine.setSize(altezza, ampiezza);
                        ImageIcon newIcon = new ImageIcon(bufImg);
                        immagine.setIcon(newIcon);
                    }else{
                        try
                        {
                            Thread.sleep((long)((1d/immagine.getSize().height)*500));
                        }
                        catch (InterruptedException ie)
                        {
                            ie.printStackTrace();
                        }
                        //System.out.println(codice + " " + modello + " sta atterrando sulla pista di sinistra");
                    }
                    break;
                case atterrandoD:
                    immagine.setLocation(immagine.location().x - 1, 60 - immagine.getSize().height/2);
                    if(immagine.getLocation().x < 70){
                        aeroporto.destra.liberaPista();
                        System.out.println(codice + " " + modello + " sta procedendo verso il parcheggio");
                        stato = Stato.rullaggioAParcheggio;
                        ImageIcon icona = (ImageIcon) immagine.getIcon();
                        Image img = icona.getImage();
                        BufferedImage bufImg = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
                        Graphics2D g2 = bufImg.createGraphics();
                        g2.rotate(-Math.PI/2, bufImg.getWidth() / 2, bufImg.getHeight() / 2);
                        g2.drawImage(img, 0, 0, null);
                        g2.dispose();
                        int ampiezza = immagine.getSize().width;
                        int altezza = immagine.getSize().height;
                        immagine.setSize(altezza, ampiezza);
                        ImageIcon newIcon = new ImageIcon(bufImg);
                        immagine.setIcon(newIcon);
                    }else{
                        try
                        {
                            Thread.sleep((long)((1d/immagine.getSize().height)*500));
                        }
                        catch (InterruptedException ie)
                        {
                            ie.printStackTrace();
                        }
                        //System.out.println(codice + " " + modello + " sta atterrando sulla pista di destra");
                    }
                    break;
                case rullaggioAParcheggio:
                    immagine.setLocation(70 - immagine.getSize().width/2, immagine.location().y + 1);
                    if(immagine.getLocation().y > 500){
                        System.out.println(codice + " " + modello + " ha parcheggiato");
                        stato = Stato.parcheggiato;
                        immagine.setLocation((320 * parcheggio + 160) - immagine.getSize().width/2, 680 - immagine.getSize().height/2);
                    }else{
                        try
                        {
                            Thread.sleep((long)((1d/immagine.getSize().height)*1000));
                        }
                        catch (InterruptedException ie)
                        {
                            ie.printStackTrace();
                        }
                        //System.out.println(codice + " " + modello + " sta procedendo verso il parcheggio");
                    }
                    break;
                case decollandoS:
                    System.out.println(codice + " " + modello + " sta decollando dalla pista di sinistra");
                    break;
                case decollandoD:
                    System.out.println(codice + " " + modello + " sta decollando dalla pista di destra");
                    break;
                case pistaPrenotataS:
                    System.out.println(codice + " " + modello + " si sta dirigendo verso la pista di sinistra prenotata");
                    break;
                case pistaPrenotataD:
                    System.out.println(codice + " " + modello + " si sta dirigendo verso la pista di destra prenotata");
                    break;
                case rullaggioAPistaS:
                    System.out.println(codice + " " + modello + " sta dirigendosi alla pista di decollo sinistra tramite il rullaggio");
                    break;
                case rullaggioAPistaD:
                    System.out.println(codice + " " + modello + " sta dirigendosi alla pista di decollo destra tramite il rullaggio");
                    break;
                case parcheggiato:
                    break;
                case raggiungendoLaPistaS:
                    while(immagine.getLocation().x < 1920){
                        immagine.setLocation(immagine.location().x + 1, immagine.location().y);
                        try
                        {
                            Thread.sleep((long)((1d/immagine.getSize().height)*500));
                        }
                        catch (InterruptedException ie)
                        {
                            ie.printStackTrace();
                        }
                    }
                    ImageIcon icona = (ImageIcon) immagine.getIcon();
                    Image img = icona.getImage();
                    BufferedImage bufImg = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
                    Graphics2D g2 = bufImg.createGraphics();
                    g2.rotate(Math.PI, bufImg.getWidth() / 2, bufImg.getHeight() / 2);
                    g2.drawImage(img, 0, 0, null);
                    g2.dispose();
                    ImageIcon newIcon = new ImageIcon(bufImg);
                    immagine.setIcon(newIcon);
                    stato = Stato.atterrandoS;
                    break;
                case raggiungendoLaPistaD:
                    while(immagine.getLocation().x < 1920){
                        immagine.setLocation(immagine.location().x + 1, immagine.location().y);
                        try
                        {
                            Thread.sleep((long)((1d/immagine.getSize().height)*500));
                        }
                        catch (InterruptedException ie)
                        {
                            ie.printStackTrace();
                        }
                    }
                    ImageIcon icona2 = (ImageIcon) immagine.getIcon();
                    Image img2 = icona2.getImage();
                    BufferedImage bufImg2 = new BufferedImage(img2.getWidth(null), img2.getHeight(null), BufferedImage.TYPE_INT_ARGB);
                    Graphics2D g3 = bufImg2.createGraphics();
                    g3.rotate(Math.PI, bufImg2.getWidth() / 2, bufImg2.getHeight() / 2);
                    g3.drawImage(img2, 0, 0, null);
                    g3.dispose();
                    ImageIcon newIcon2 = new ImageIcon(bufImg2);
                    immagine.setIcon(newIcon2);
                    stato = Stato.atterrandoD;
                    break;
                default:
                    System.out.println("Tipo di volo non riconosciuto");
                    break;
            }
        }
    }
}
