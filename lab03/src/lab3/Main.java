package lab3;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    Main frame = new Main();
                    frame.setVisible(true);
                    frame.setLocationRelativeTo(null);
                } catch (Exception e) {
                    e.printStackTrace(System.err);
                }
            }
        });
    }

    public Main() throws HeadlessException {
        this("Login");
    }

    public Main(String title) throws HeadlessException {
        super(title);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setResizable(false);
        getContentPane().setBackground(Color.white);

        JPanel contentPane = new JPanel();
        contentPane.setBackground(Color.white);
        setLayout(null);
        setContentPane(contentPane);
        contentPane.setLayout(new FlowLayout());

        Panel loginPanel = new Panel();
        contentPane.add(loginPanel);
    }
}
