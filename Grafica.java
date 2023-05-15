import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.image.*;
/**
 * <p>Classe per la finestra grafica</p>
 */
public class Grafica extends JFrame implements MouseListener
{
    JLabel sfondo;
    JPanel pannelloSfondo = new JPanel();
    Aeroporto aeroporto;
    JLabel testo = new JLabel();
    String[] stringhe = {"","","","","",""};
    /**
     * <p>Crea la finestra e un muose listener</p>
     */
    public Grafica(Aeroporto aeroporto)
    {
        setSize(1297,682);
        setResizable(false);
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        this.aeroporto = aeroporto;
        addMouseListener(this);
        /*add(pannelloSfondo);
        pannelloSfondo.setSize(1920,1080);
        pannelloSfondo.setLocation(0,-2);
        pannelloSfondo.setDoubleBuffered(true);*/
        add(testo);
        testo.setLocation(500,700);
        testo.setSize(1900,500);
        testo.setText("");
        testo.setFont(new Font("Verdana", Font.PLAIN, 32));
        testo.setForeground(Color.white);
    }
    /**
     * <p>Aggiunge l'immagine di sfondo</p>
     */
    void concludi(){
        sfondo = new JLabel(new ImageIcon("immagini/sfondi/sfondo.png"));
        //sfondo.setSize(100,100);
        //pannelloSfondo.add(sfondo);
        add(sfondo);
        show();
    }
    void aggiornaTesto(String stringa){
        stringhe[5] = stringhe[4];
        stringhe[4] = stringhe[3];
        stringhe[3] = stringhe[2];
        stringhe[2] = stringhe[1];
        stringhe[1] = stringhe[0];
        stringhe[0] = stringa;
        testo.setText("<html><body style='background-color:black';>"+stringhe[5]+"<br>"+stringhe[4]+"<br>"+stringhe[3]+"<br>"+stringhe[2]+"<br>"+stringhe[1]+"<br> > "+stringhe[0]+"</body></html>");
    }
    /**
     * <p>Eventi Muose listener per impartire agli aerei premuti di partire</p>
     */
    public void mousePressed(MouseEvent e) {
        //System.out.println(e.getX() + " " +e.getY());
        if(e.getY() > 540 || e.getY() < 810){
            if(e.getX() < 322){
                ImageIcon icona = (ImageIcon) aeroporto.parcheggi[0].immagine.getIcon();
                Image img = icona.getImage();
                BufferedImage bufImg = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
                Graphics2D g2 = bufImg.createGraphics();
                g2.rotate(-Math.PI, bufImg.getWidth() / 2, bufImg.getHeight() / 2);
                g2.drawImage(img, 0, 0, null);
                g2.dispose();
                int ampiezza = aeroporto.parcheggi[0].immagine.getSize().width;
                int altezza = aeroporto.parcheggi[0].immagine.getSize().height;
                aeroporto.parcheggi[0].immagine.setSize(altezza, ampiezza);
                ImageIcon newIcon = new ImageIcon(bufImg);
                aeroporto.parcheggi[0].immagine.setIcon(newIcon);
                aeroporto.parcheggi[0].stato = Stato.inCoda;
                System.out.println("metto in coda " + aeroporto.parcheggi[0].modello);
            }else if(e.getX() < 644){
                ImageIcon icona = (ImageIcon) aeroporto.parcheggi[1].immagine.getIcon();
                Image img = icona.getImage();
                BufferedImage bufImg = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
                Graphics2D g2 = bufImg.createGraphics();
                g2.rotate(-Math.PI, bufImg.getWidth() / 2, bufImg.getHeight() / 2);
                g2.drawImage(img, 0, 0, null);
                g2.dispose();
                int ampiezza = aeroporto.parcheggi[1].immagine.getSize().width;
                int altezza = aeroporto.parcheggi[1].immagine.getSize().height;
                aeroporto.parcheggi[1].immagine.setSize(altezza, ampiezza);
                ImageIcon newIcon = new ImageIcon(bufImg);
                aeroporto.parcheggi[1].immagine.setIcon(newIcon);
                aeroporto.parcheggi[1].stato = Stato.inCoda;
                System.out.println("metto in coda " + aeroporto.parcheggi[1].modello);
            }else if(e.getX() < 966){
                ImageIcon icona = (ImageIcon) aeroporto.parcheggi[2].immagine.getIcon();
                Image img = icona.getImage();
                BufferedImage bufImg = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
                Graphics2D g2 = bufImg.createGraphics();
                g2.rotate(-Math.PI, bufImg.getWidth() / 2, bufImg.getHeight() / 2);
                g2.drawImage(img, 0, 0, null);
                g2.dispose();
                int ampiezza = aeroporto.parcheggi[2].immagine.getSize().width;
                int altezza = aeroporto.parcheggi[2].immagine.getSize().height;
                aeroporto.parcheggi[2].immagine.setSize(altezza, ampiezza);
                ImageIcon newIcon = new ImageIcon(bufImg);
                aeroporto.parcheggi[2].immagine.setIcon(newIcon);
                aeroporto.parcheggi[2].stato = Stato.inCoda;
                System.out.println("metto in coda " + aeroporto.parcheggi[2].modello);
            }else if(e.getX() < 1288){
                ImageIcon icona = (ImageIcon) aeroporto.parcheggi[3].immagine.getIcon();
                Image img = icona.getImage();
                BufferedImage bufImg = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
                Graphics2D g2 = bufImg.createGraphics();
                g2.rotate(-Math.PI, bufImg.getWidth() / 2, bufImg.getHeight() / 2);
                g2.drawImage(img, 0, 0, null);
                g2.dispose();
                int ampiezza = aeroporto.parcheggi[3].immagine.getSize().width;
                int altezza = aeroporto.parcheggi[3].immagine.getSize().height;
                aeroporto.parcheggi[3].immagine.setSize(altezza, ampiezza);
                ImageIcon newIcon = new ImageIcon(bufImg);
                aeroporto.parcheggi[3].immagine.setIcon(newIcon);
                aeroporto.parcheggi[3].stato = Stato.inCoda;
                System.out.println("metto in coda " + aeroporto.parcheggi[3].modello);
            }else if(e.getX() < 1610){
                ImageIcon icona = (ImageIcon) aeroporto.parcheggi[4].immagine.getIcon();
                Image img = icona.getImage();
                BufferedImage bufImg = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
                Graphics2D g2 = bufImg.createGraphics();
                g2.rotate(-Math.PI, bufImg.getWidth() / 2, bufImg.getHeight() / 2);
                g2.drawImage(img, 0, 0, null);
                g2.dispose();
                int ampiezza = aeroporto.parcheggi[4].immagine.getSize().width;
                int altezza = aeroporto.parcheggi[4].immagine.getSize().height;
                aeroporto.parcheggi[4].immagine.setSize(altezza, ampiezza);
                ImageIcon newIcon = new ImageIcon(bufImg);
                aeroporto.parcheggi[4].immagine.setIcon(newIcon);
                aeroporto.parcheggi[4].stato = Stato.inCoda;
                System.out.println("metto in coda " + aeroporto.parcheggi[4].modello);
            }else if(e.getX() < 1920){
                ImageIcon icona = (ImageIcon) aeroporto.parcheggi[5].immagine.getIcon();
                Image img = icona.getImage();
                BufferedImage bufImg = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
                Graphics2D g2 = bufImg.createGraphics();
                g2.rotate(-Math.PI, bufImg.getWidth() / 2, bufImg.getHeight() / 2);
                g2.drawImage(img, 0, 0, null);
                g2.dispose();
                int ampiezza = aeroporto.parcheggi[5].immagine.getSize().width;
                int altezza = aeroporto.parcheggi[5].immagine.getSize().height;
                aeroporto.parcheggi[5].immagine.setSize(altezza, ampiezza);
                ImageIcon newIcon = new ImageIcon(bufImg);
                aeroporto.parcheggi[5].immagine.setIcon(newIcon);
                aeroporto.parcheggi[5].stato = Stato.inCoda     ;
                System.out.println("metto in coda " + aeroporto.parcheggi[5].modello);
            }
        }
    }

    public void mouseReleased(MouseEvent e) {
       
    }

    public void mouseEntered(MouseEvent e) {
       
    }

    public void mouseExited(MouseEvent e) {
       
    }

    public void mouseClicked(MouseEvent e) {
        
    }

}
