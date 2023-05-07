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
    int variazioneVelocita = (int)(Math.random()*3);
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
        if(stato == Stato.aTerra){
            parcheggio = aeroporto.parcheggioLibero();
            aeroporto.parcheggi[parcheggio] = this;
            immagine.setLocation((320 * parcheggio + 160) - immagine.getSize().width/2, 680 - immagine.getSize().height/2);
            icona = (ImageIcon) immagine.getIcon();
            Image img = icona.getImage();
            BufferedImage bufImg = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2 = bufImg.createGraphics();
            g2.rotate(Math.PI/2, bufImg.getWidth() / 2, bufImg.getHeight() / 2);
            g2.drawImage(img, 0, 0, null);
            g2.dispose();
            int ampiezza = immagine.getSize().width;
            int altezza = immagine.getSize().height;
            immagine.setSize(altezza, ampiezza);
            ImageIcon newIcon = new ImageIcon(bufImg);
            immagine.setIcon(newIcon);
        }
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
        if(stato == Stato.aTerra){
            parcheggio = aeroporto.parcheggioLibero();
            aeroporto.parcheggi[parcheggio] = this;
            immagine.setLocation((320 * parcheggio + 160) - immagine.getSize().width/2, 680 - immagine.getSize().height/2);
            icona = (ImageIcon) immagine.getIcon();
            Image img = icona.getImage();
            BufferedImage bufImg = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2 = bufImg.createGraphics();
            g2.rotate(Math.PI/2, bufImg.getWidth() / 2, bufImg.getHeight() / 2);
            g2.drawImage(img, 0, 0, null);
            g2.dispose();
            int ampiezza = immagine.getSize().width;
            int altezza = immagine.getSize().height;
            immagine.setSize(altezza, ampiezza);
            ImageIcon newIcon = new ImageIcon(bufImg);
            immagine.setIcon(newIcon);
        }
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
        if(stato == Stato.aTerra){
            parcheggio = aeroporto.parcheggioLibero();
            aeroporto.parcheggi[parcheggio] = this;
            immagine.setLocation((320 * parcheggio + 160) - immagine.getSize().width/2, 680 - immagine.getSize().height/2);
            icona = (ImageIcon) immagine.getIcon();
            Image img = icona.getImage();
            BufferedImage bufImg = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2 = bufImg.createGraphics();
            g2.rotate(Math.PI/2, bufImg.getWidth() / 2, bufImg.getHeight() / 2);
            g2.drawImage(img, 0, 0, null);
            g2.dispose();
            int ampiezza = immagine.getSize().width;
            int altezza = immagine.getSize().height;
            immagine.setSize(altezza, ampiezza);
            ImageIcon newIcon = new ImageIcon(bufImg);
            immagine.setIcon(newIcon);
        }
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
                case inCoda:
                    aeroporto.parcheggiLiberi[parcheggio] = true;
                    aeroporto.parcheggi[parcheggio] = null;
                    immagine.setLocation(1840 - immagine.getSize().width/2, immagine.location().y - 1);
                    if(immagine.getLocation().y < 370){
                        System.out.println(codice + " " + modello + " ha parcheggiato");
                        stato = Stato.inAttesa;
                        //immagine.setLocation((320 * parcheggio + 160) - immagine.getSize().width/2, 680 - immagine.getSize().height/2);
                    }else{
                        try
                        {
                            Thread.sleep((long)((1d/immagine.getSize().height)*1000 + variazioneVelocita));
                        }
                        catch (InterruptedException ie)
                        {
                            ie.printStackTrace();
                        }
                        //System.out.println(codice + " " + modello + " sta procedendo verso il parcheggio");
                    }
                    break;
                case inAttesa:
                    if(aeroporto.destra.richiediPista()){
                        System.out.println(codice + " " + modello + " sta decollando sulla pista di destra");
                        stato = Stato.decollandoD;
                        while(immagine.getLocation().y > 5){
                            immagine.setLocation(immagine.location().x, immagine.location().y - 1);
                            try
                            {
                                Thread.sleep((long)((1d/immagine.getSize().height)*500 + variazioneVelocita));
                            }
                            catch (InterruptedException ie)
                            {
                                ie.printStackTrace();
                            }
                        }
                        immagine.setLocation(immagine.location().x, 60 - immagine.getHeight()/2);
                        ImageIcon icona = (ImageIcon) immagine.getIcon();
                        Image img = icona.getImage();
                        BufferedImage bufImg = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
                        Graphics2D g2 = bufImg.createGraphics();
                        g2.rotate(-Math.PI/2, bufImg.getWidth() / 2, bufImg.getHeight() / 2);
                        g2.drawImage(img, 0, 0, null);
                        g2.dispose();
                        /*int ampiezza = immagine.getSize().width;
                        int altezza = immagine.getSize().height;
                        immagine.setSize(altezza, ampiezza);*/
                        ImageIcon newIcon = new ImageIcon(bufImg);
                        immagine.setIcon(newIcon);
                    }else if(aeroporto.sinistra.richiediPista()){
                        System.out.println(codice + " " + modello + " sta decollando sulla pista di sinistra");
                        stato = Stato.decollandoS;
                        while(immagine.getLocation().y > 250){
                            immagine.setLocation(immagine.location().x, immagine.location().y - 1);
                            try
                            {
                                Thread.sleep((long)((1d/immagine.getSize().height)*500 + variazioneVelocita));
                            }
                            catch (InterruptedException ie)
                            {
                                ie.printStackTrace();
                            }
                        }
                        immagine.setLocation(immagine.location().x, 300 - immagine.getHeight()/2);
                        ImageIcon icona = (ImageIcon) immagine.getIcon();
                        Image img = icona.getImage();
                        BufferedImage bufImg = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
                        Graphics2D g2 = bufImg.createGraphics();
                        g2.rotate(-Math.PI/2, bufImg.getWidth() / 2, bufImg.getHeight() / 2);
                        g2.drawImage(img, 0, 0, null);
                        g2.dispose();
                        /*int ampiezza = immagine.getSize().width;
                        int altezza = immagine.getSize().height;
                        immagine.setSize(altezza, ampiezza);*/
                        ImageIcon newIcon = new ImageIcon(bufImg);
                        immagine.setIcon(newIcon);
                    }
                    break;
                case decollandoS:
                    immagine.setLocation(immagine.location().x - 1, immagine.location().y);
                    if(immagine.getLocation().x < -160){
                        System.out.println(codice + " " + modello + " è decollato");
                        stato = Stato.decollato;
                        aeroporto.sinistra.liberaPista();
                    }else{
                        try
                        {
                            Thread.sleep((long)((1d/immagine.getSize().height)*500 + variazioneVelocita));
                        }
                        catch (InterruptedException ie)
                        {
                            ie.printStackTrace();
                        }
                    }
                    break;
                case decollandoD:
                    immagine.setLocation(immagine.location().x - 1, immagine.location().y);
                    if(immagine.getLocation().x < -160){
                        System.out.println(codice + " " + modello + " è decollato");
                        stato = Stato.decollato;
                        aeroporto.destra.liberaPista();
                    }else{
                        try
                        {
                            Thread.sleep((long)((1d/immagine.getSize().height)*500 + variazioneVelocita));
                        }
                        catch (InterruptedException ie)
                        {
                            ie.printStackTrace();
                        }
                    }
                    break;
                case inAria:
                    //System.out.println(codice + " " + modello + " è in volo");
                    immagine.setLocation(immagine.location().x + 1, immagine.location().y);
                    if(immagine.getLocation().x > 1920){
                        immagine.setLocation(-200, immagine.location().y);
                    }
                    
                    try
                    {
                        Thread.sleep((long)((1d/immagine.getSize().height)*500 + variazioneVelocita));
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
                        Thread.sleep((long)((1d/immagine.getSize().height)*500 + variazioneVelocita));
                    }
                    catch (InterruptedException ie)
                    {
                        ie.printStackTrace();
                    }
                    if(aeroporto.destra.richiediPista()){
                        System.out.println(codice + " " + modello + " sta atterrando sulla pista di destra");
                        stato = Stato.atterrandoD;
                        while(immagine.getLocation().x < 1920){
                            immagine.setLocation(immagine.location().x + 1, immagine.location().y);
                            try
                            {
                                Thread.sleep((long)((1d/immagine.getSize().height)*500 + variazioneVelocita));
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
                    }else if(aeroporto.sinistra.richiediPista()){
                        System.out.println(codice + " " + modello + " sta atterrando sulla pista di sinistra");
                        stato = Stato.atterrandoS;
                        while(immagine.getLocation().x < 1920){
                            immagine.setLocation(immagine.location().x + 1, immagine.location().y);
                            try
                            {
                                Thread.sleep((long)((1d/immagine.getSize().height)*500 + variazioneVelocita));
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
                    }
                    break;
                case atterrandoS:
                    //centro-altezza/2
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
                            Thread.sleep((long)((1d/immagine.getSize().height)*500 + variazioneVelocita));
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
                            Thread.sleep((long)((1d/immagine.getSize().height)*500 + variazioneVelocita));
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
                        aeroporto.parcheggiLiberi[parcheggio] = false;
                        aeroporto.parcheggi[parcheggio] = this;
                    }else{
                        try
                        {
                            Thread.sleep((long)((1d/immagine.getSize().height)*1000 + variazioneVelocita));
                        }
                        catch (InterruptedException ie)
                        {
                            ie.printStackTrace();
                        }
                        //System.out.println(codice + " " + modello + " sta procedendo verso il parcheggio");
                    }
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
                    stato = Stato.aTerra;
                    break;
                /*default:
                    System.out.println("Tipo di volo non riconosciuto");
                    break;*/
            }
        }
    }
}
