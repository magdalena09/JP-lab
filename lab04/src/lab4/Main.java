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
        setContentPane(panel);
        buttonRun = new JButton("Złap mnie");
        buttonRun.setBounds(100,100,150,40);
        panel.add(buttonRun);

        buttonRun.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseEntered(MouseEvent me) //nowe położenie przycisku po najechaniu na niego
            {
                super.mouseEntered(me);
                if(buttonRun.getX() > 95 && buttonRun.getX() < 675 && buttonRun.getY() > 40 && buttonRun.getY() < 520)
                    buttonRun.setBounds(random.nextInt(650),random.nextInt(540),150,40);
            }
        });

        buttonRun.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { //kanwa rysuje się po przyciśnięciu przycisku
                JPanel kanwa = new Kanwa();
                kanwa.setBounds(5,5, 775, 555);
                kanwa.setBackground(Color.white);
                getContentPane().removeAll();
                add(kanwa);
                getContentPane().repaint();
                kanwa.setLayout(null);
            }
        });

    }
}
