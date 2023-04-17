import javax.swing.*;
import java.awt.event.*;

public class Grafica extends JFrame implements MouseListener
{
    JLabel sfondo;
    JPanel pannelloSfondo = new JPanel();
    Aeroporto aeroporto;
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
    }
    void concludi(){
        sfondo = new JLabel(new ImageIcon("immagini/sfondi/sfondo.png"));
        //sfondo.setSize(100,100);
        //pannelloSfondo.add(sfondo);
        add(sfondo);
        show();
    }
    public void mousePressed(MouseEvent e) {
        System.out.println(e.getX() + " " +e.getY());
        if(e.getY() > 540 || e.getY() < 810){
            if(e.getX() < 322){
               aeroporto.parcheggi[0].stato = Stato.inCoda;
               System.out.println("metto in coda " + aeroporto.parcheggi[0].modello);
            }else if(e.getX() < 644){
               aeroporto.parcheggi[1].stato = Stato.inCoda;
            }else if(e.getX() < 966){
               aeroporto.parcheggi[2].stato = Stato.inCoda;
            }else if(e.getX() < 1288){
               aeroporto.parcheggi[3].stato = Stato.inCoda;
            }else if(e.getX() < 1920){
               aeroporto.parcheggi[4].stato = Stato.inCoda;
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
