/*
 * Created by JFormDesigner on Fri Apr 29 14:41:32 CEST 2022
 */

package password.manager.window;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import com.jgoodies.forms.factories.*;
import password.generator.PasswordGen;

/**
 * @author unknown
 */
public class MainMenu extends JFrame {
    public MainMenu() {
        initComponents();
    }

    private void generateButtonMouseClicked(MouseEvent e) {

        String length = passwordLength.getText();

        if (Objects.equals(length, "0") || length.length() > 0) {
            errorLabel.setText(" ");
            passwordOut.setText(PasswordGen.Generate(Integer.parseInt(length)));
        } else {
            errorLabel.setText("Length has to be bigger than 0");
        }
    }

    private void button1MouseClicked(MouseEvent e) {  }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        ResourceBundle bundle = ResourceBundle.getBundle("password.manager.window.resources.MainFrame");
        tabbedPane1 = new JTabbedPane();
        manager = new JPanel();
        label1 = new JLabel();
        passwordGen = new JPanel();
        passwordGenLabel = new JLabel();
        generateButton = new JButton();
        passwordOut = new JTextField();
        passwordOutLabel = new JLabel();
        passwordLengthLabel = new JLabel();
        passwordLength = new JTextField();
        seperator = new JSeparator();
        errorLabel = new JLabel();

        //======== this ========
        setMinimumSize(new Dimension(650, 350));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("PasswordManager");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== tabbedPane1 ========
        {

            //======== manager ========
            {
                manager.setLayout(null);

                //---- label1 ----
                label1.setText(bundle.getString("MainMenu.label1.text"));
                label1.setHorizontalAlignment(SwingConstants.CENTER);
                label1.setFont(new Font("Grold Rounded Slim Medium", Font.PLAIN, 24));
                manager.add(label1);
                label1.setBounds(0, 0, 650, 40);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < manager.getComponentCount(); i++) {
                        Rectangle bounds = manager.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = manager.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    manager.setMinimumSize(preferredSize);
                    manager.setPreferredSize(preferredSize);
                }
            }
            tabbedPane1.addTab(bundle.getString("MainMenu.manager.tab.title"), manager);

            //======== passwordGen ========
            {
                passwordGen.setLayout(null);

                //---- passwordGenLabel ----
                passwordGenLabel.setText(bundle.getString("MainMenu.passwordGenLabel.text"));
                passwordGenLabel.setFont(new Font("Grold Rounded Slim Medium", Font.PLAIN, 24));
                passwordGenLabel.setHorizontalAlignment(SwingConstants.CENTER);
                passwordGen.add(passwordGenLabel);
                passwordGenLabel.setBounds(0, 0, 650, 40);

                //---- generateButton ----
                generateButton.setText(bundle.getString("MainMenu.generateButton.text"));
                generateButton.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        button1MouseClicked(e);
                        generateButtonMouseClicked(e);
                    }
                });
                passwordGen.add(generateButton);
                generateButton.setBounds(270, 120, 112, generateButton.getPreferredSize().height);
                passwordGen.add(passwordOut);
                passwordOut.setBounds(85, 225, 550, 25);

                //---- passwordOutLabel ----
                passwordOutLabel.setText(bundle.getString("MainMenu.passwordOutLabel.text"));
                passwordGen.add(passwordOutLabel);
                passwordOutLabel.setBounds(15, 220, 70, 30);

                //---- passwordLengthLabel ----
                passwordLengthLabel.setText(bundle.getString("MainMenu.passwordLengthLabel.text"));
                passwordGen.add(passwordLengthLabel);
                passwordLengthLabel.setBounds(135, 55, 55, 30);

                //---- passwordLength ----
                passwordLength.setText(bundle.getString("MainMenu.passwordLength.text"));
                passwordGen.add(passwordLength);
                passwordLength.setBounds(190, 60, 290, passwordLength.getPreferredSize().height);
                passwordGen.add(seperator);
                seperator.setBounds(0, 200, 650, 5);

                //---- errorLabel ----
                errorLabel.setText(" ");
                errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
                passwordGen.add(errorLabel);
                errorLabel.setBounds(0, 95, 650, 20);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < passwordGen.getComponentCount(); i++) {
                        Rectangle bounds = passwordGen.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = passwordGen.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    passwordGen.setMinimumSize(preferredSize);
                    passwordGen.setPreferredSize(preferredSize);
                }
            }
            tabbedPane1.addTab(bundle.getString("MainMenu.passwordGen.tab.title"), passwordGen);
        }
        contentPane.add(tabbedPane1);
        tabbedPane1.setBounds(0, 0, 650, 320);

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
    private JTabbedPane tabbedPane1;
    private JPanel manager;
    private JLabel label1;
    private JPanel passwordGen;
    private JLabel passwordGenLabel;
    private JButton generateButton;
    private JTextField passwordOut;
    private JLabel passwordOutLabel;
    private JLabel passwordLengthLabel;
    private JTextField passwordLength;
    private JSeparator seperator;
    private JLabel errorLabel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
