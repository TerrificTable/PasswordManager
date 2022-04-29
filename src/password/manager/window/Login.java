/*
 * Created by JFormDesigner on Fri Apr 29 17:56:58 CEST 2022
 */

package password.manager.window;

import password.Main;
import password.manager.LoadData;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.*;
import javax.swing.*;

/**
 * @author TerrificTable
 */
public class Login extends JFrame {
    public Login() {
        initComponents();
    }

    private void loginButtonMouseClicked(MouseEvent e) {
        try {
            LoadData.load();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        if (Main.correct(this.field_loginUsername, this.field_loginPassword)) {
            this.error.setText("");

            Main.loggedIn = true;
            Main.window.loggedIn_Label.setText("Logged In: " + Main.account);

            this.field_loginUsername.setText("");
            this.field_loginPassword.setText("");

            this.dispose();
            Main.window.setVisible(true);
        } else {
            this.field_loginUsername.setText("");

            this.error.setText("Invalid Login");
        }
    }

    private void exitButtonMouseClicked(MouseEvent e) {
        this.dispose();
        System.exit(0);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        ResourceBundle bundle = ResourceBundle.getBundle("password.manager.window.resources.LoginFrame");
        headline = new JLabel();
        loginButton = new JButton();
        exitButton = new JButton();
        field_loginUsername = new JTextField();
        field_loginPassword = new JPasswordField();
        usernameLabel = new JLabel();
        passwordLabel = new JLabel();
        error = new JLabel();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(400, 260));
        setTitle("Login");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- headline ----
        headline.setText(bundle.getString("Login.headline.text"));
        headline.setFont(new Font("Grold Rounded Slim Medium", Font.PLAIN, 28));
        headline.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(headline);
        headline.setBounds(0, 10, 400, 39);

        //---- loginButton ----
        loginButton.setText(bundle.getString("Login.loginButton.text"));
        loginButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                loginButtonMouseClicked(e);
            }
        });
        contentPane.add(loginButton);
        loginButton.setBounds(new Rectangle(new Point(200, 170), loginButton.getPreferredSize()));

        //---- exitButton ----
        exitButton.setText(bundle.getString("Login.exitButton.text"));
        exitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                exitButtonMouseClicked(e);
            }
        });
        contentPane.add(exitButton);
        exitButton.setBounds(new Rectangle(new Point(118, 170), exitButton.getPreferredSize()));
        contentPane.add(field_loginUsername);
        field_loginUsername.setBounds(155, 60, 160, field_loginUsername.getPreferredSize().height);
        contentPane.add(field_loginPassword);
        field_loginPassword.setBounds(155, 105, 160, field_loginPassword.getPreferredSize().height);

        //---- usernameLabel ----
        usernameLabel.setText(bundle.getString("Login.usernameLabel.text"));
        contentPane.add(usernameLabel);
        usernameLabel.setBounds(75, 60, 80, 30);

        //---- passwordLabel ----
        passwordLabel.setText(bundle.getString("Login.passwordLabel.text"));
        contentPane.add(passwordLabel);
        passwordLabel.setBounds(75, 105, 80, 30);

        //---- error ----
        error.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(error);
        error.setBounds(0, 140, 400, 25);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel headline;
    private JButton loginButton;
    private JButton exitButton;
    private JTextField field_loginUsername;
    private JPasswordField field_loginPassword;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JLabel error;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
