package lab4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Main extends JFrame
{
    private JButton buttonRun;
    private Random random = new Random();

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Main().setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace(System.err);
                }
            }
        });
    }

    public Main()
    {
        setTitle("Uciekajacy przycisk");
        setLayout(null);
        setResizable(false);
        //setLocationRelativeTo(null); za duże okno by było na środku
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,600);

        JPanel panel = new JPanel();
        panel.setBounds(0,0,800,600);
        panel.setLayout(null);
        panel.setBackground(Color.pink);
        setContentPane(panel);
        buttonRun = new JButton("Złap mnie");
        buttonRun.setBounds(300,200,160,60);
        panel.add(buttonRun);

        buttonRun.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseEntered(MouseEvent me) //nowe położenie przycisku po najechaniu na niego
            {
                super.mouseEntered(me);
                //całe okno 800x600, strefa bezpieczna okna(tam, gdzie można nacisnąć przycisk) to
                // (50+wymiar przycisku) od stron prawo-dół i 50 od stron lewo-góra
                if(buttonRun.getX() > 50 && buttonRun.getX() < 590 && buttonRun.getY() > 50 && buttonRun.getY() < 490)
                    buttonRun.setLocation(random.nextInt(640),random.nextInt(540));
            }
        });

        buttonRun.addActionListener(new ActionListener() {//kanwa rysuje się po przyciśnięciu przycisku
            @Override
            public void actionPerformed(ActionEvent e) {
                //potrzeba nowej ramki, na starym panelu nie były zczytywane klawisze
                JFrame frame = new JFrame("Rysowanie. 'k' - kwadraty, 'o' - kółka");
                frame.setLayout(null);
                frame.setResizable(false);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800,600);
                frame.setVisible(true);
                dispose(); //zamknij okno z przyciskiem

                JPanel kanwa = new Kanwa();
                frame.add(kanwa);
            }
        });

    }
}
