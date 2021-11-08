package lab3;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Map;

public class Panel extends JPanel {
    JLabel idLabel;
    JLabel passwordLabel;
    JTextField loginText;
    JPasswordField passwordText;
    JButton loginButton;
    JButton cancelButton;

    Map<String, String> dataBase;

    public Panel() {
        setBorder(new EmptyBorder(20,70,20,70));
        setBackground(Color.WHITE);
        setLayout(new GridLayout(3,2));

        dataBase = Map.of("login1","pass1", "login2", "pass2", "login3", "pass3");

        idLabel = new JLabel("ID: ");
        add(idLabel);

        loginText = new JTextField();
        add(loginText);

        passwordLabel = new JLabel("Password:");
        add(passwordLabel);

        passwordText = new JPasswordField();
        add(passwordText);

        loginButton = new JButton("Login");
        loginButton.addActionListener(e -> {
            char[] pass = passwordText.getPassword();
            if(dataBase.containsKey(loginText.getText()) && dataBase.get(loginText.getText()).equals((String.valueOf(pass)))){
                setBackground(Color.GREEN);
            } else setBackground(Color.RED);
        });
        add(loginButton);

        cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(e -> System.exit(0));
        add(cancelButton);
    }
}
