import javax.swing.*;

public class Grafica extends JFrame
{
    JLabel sfondo;
    JPanel pannelloSfondo = new JPanel();
    public Grafica()
    {
        setSize(1297,682);
        setResizable(false);
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        /*add(pannelloSfondo);
        pannelloSfondo.setSize(1920,1080);
        pannelloSfondo.setLocation(0,-2);
        pannelloSfondo.setDoubleBuffered(true);*/
    }
    void concludi(){
        sfondo = new JLabel(new ImageIcon("immagini/sfondo.png"));
        //sfondo.setSize(100,100);
        //pannelloSfondo.add(sfondo);
        add(sfondo);
        show();
    }
}
