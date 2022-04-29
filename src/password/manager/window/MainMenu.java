/*
 * Created by JFormDesigner on Fri Apr 29 14:41:32 CEST 2022
 */

package password.manager.window;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.*;
import javax.swing.*;

import password.Main;
import password.generator.PasswordGen;
import password.manager.SaveData;

/**
 * @author TerrificTable
 */
public class MainMenu extends JFrame {
    public MainMenu() {
        initComponents();
    }

    private void generateButtonMouseClicked(MouseEvent e) {

        String length = field_pwdgenPasswordLength.getText();

        if (Objects.equals(length, "0") || length.length() > 0) {
            errorLabel.setText(" ");
            passwordOut.setText(PasswordGen.Generate(Integer.parseInt(length)));
        } else {
            errorLabel.setText("Length has to be bigger than 0");
        }
    }

    private void updateButtonMouseClicked(MouseEvent e) {
        this.platformList.setListData(Main.platformList);
        this.usernameList.setListData(Main.usernameList);
        if (Main.loggedIn) {
            this.passwordList.setListData(Main.clear_passwordList);
        } else {
            this.passwordList.setListData(Main.passwordList);
        }

        try {
            SaveData.save();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    private void button1MouseClicked(MouseEvent e) {  }

    private void addButtonMouseClicked(MouseEvent e) {
        if (this.field_addPlatform.getText().equals("") || this.field_addUsername.getText().equals("") || this.field_addPassword.getText().equals("")) {

            this.addErrorLabel.setText("Password Cant be ''");
            return;
        }

        Main.platformList.add(this.field_addPlatform.getText());
        Main.usernameList.add(this.field_addUsername.getText());
        Main.clear_passwordList.add(this.field_addPassword.getText());
        Main.passwordList.add(this.field_addPassword.getPassword());

        this.platformList.setListData(Main.platformList);
        this.usernameList.setListData(Main.usernameList);
        if (Main.loggedIn) {
            this.passwordList.setListData(Main.clear_passwordList);
        } else {
            this.passwordList.setListData(Main.passwordList);
        }

        this.field_addPlatform.setText("");
        this.field_addUsername.setText("");
        this.field_addPassword.setText("");
    }

    private void removeButtonMouseClicked(MouseEvent e) {

        int toRemove_Platform = this.platformList.getSelectedIndex();
        int toRemove_Username = this.usernameList.getSelectedIndex();
        int toRemove_Password = this.passwordList.getSelectedIndex();
        try {
            if (toRemove_Password <= -1) {
                if (toRemove_Username <= -1) {
                    Main.platformList.remove(toRemove_Platform);
                    Main.usernameList.remove(toRemove_Platform);
                    Main.passwordList.remove(toRemove_Platform);
                    Main.clear_passwordList.remove(toRemove_Platform);
                } else {
                    Main.platformList.remove(toRemove_Username);
                    Main.passwordList.remove(toRemove_Username);
                    Main.usernameList.remove(toRemove_Username);
                    Main.clear_passwordList.remove(toRemove_Username);
                }
            } else {
                Main.platformList.remove(toRemove_Password);
                Main.usernameList.remove(toRemove_Password);
                Main.passwordList.remove(toRemove_Password);
                Main.clear_passwordList.remove(toRemove_Password);
            }

            this.platformList.setListData(Main.platformList);
            this.usernameList.setListData(Main.usernameList);
            this.passwordList.setListData(Main.passwordList);
        } catch (ArrayIndexOutOfBoundsException exception) {
            exception.printStackTrace();
        }
    }

    private void logoutButtonMouseClicked(MouseEvent e) {
        Main.loggedIn = false;
        Main.account = "";
        this.dispose();
        Main.login.setVisible(true);
    }

    private void thisWindowClosed(WindowEvent e) {
        try {
            SaveData.save();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        ResourceBundle bundle = ResourceBundle.getBundle("password.manager.window.resources.MainFrame");
        tabbedPane1 = new JTabbedPane();
        manager = new JPanel();
        PasswordManagerLabel = new JLabel();
        updateButton = new JButton();
        scrollPane1 = new JScrollPane();
        platformList = new JList();
        scrollPane2 = new JScrollPane();
        usernameList = new JList();
        scrollPane3 = new JScrollPane();
        passwordList = new JList();
        loggedIn_Label = new JLabel();
        removeButton = new JButton();
        logoutButton = new JButton();
        passwordGen = new JPanel();
        passwordGenLabel = new JLabel();
        generateButton = new JButton();
        passwordOut = new JTextField();
        passwordOutLabel = new JLabel();
        passwordLengthLabel = new JLabel();
        field_pwdgenPasswordLength = new JTextField();
        seperator = new JSeparator();
        errorLabel = new JLabel();
        addPassword = new JPanel();
        AddPasswordLabel = new JLabel();
        Platform_Label = new JLabel();
        field_addPlatform = new JTextField();
        Username_Label = new JLabel();
        field_addUsername = new JTextField();
        Password_Label = new JLabel();
        field_addPassword = new JPasswordField();
        addButton = new JButton();
        addErrorLabel = new JLabel();

        //======== this ========
        setMinimumSize(new Dimension(650, 350));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("PasswordManager");
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                thisWindowClosed(e);
            }
        });
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== tabbedPane1 ========
        {

            //======== manager ========
            {
                manager.setLayout(null);

                //---- PasswordManagerLabel ----
                PasswordManagerLabel.setText(bundle.getString("MainMenu.PasswordManagerLabel.text"));
                PasswordManagerLabel.setHorizontalAlignment(SwingConstants.CENTER);
                PasswordManagerLabel.setFont(new Font("Grold Rounded Slim Medium", Font.PLAIN, 24));
                manager.add(PasswordManagerLabel);
                PasswordManagerLabel.setBounds(0, 0, 650, 40);

                //---- updateButton ----
                updateButton.setText(bundle.getString("MainMenu.updateButton.text"));
                updateButton.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        button1MouseClicked(e);
                        updateButtonMouseClicked(e);
                    }
                });
                manager.add(updateButton);
                updateButton.setBounds(new Rectangle(new Point(20, 240), updateButton.getPreferredSize()));

                //======== scrollPane1 ========
                {
                    scrollPane1.setViewportView(platformList);
                }
                manager.add(scrollPane1);
                scrollPane1.setBounds(115, 55, 130, 170);

                //======== scrollPane2 ========
                {
                    scrollPane2.setViewportView(usernameList);
                }
                manager.add(scrollPane2);
                scrollPane2.setBounds(260, 55, 135, 170);

                //======== scrollPane3 ========
                {
                    scrollPane3.setViewportView(passwordList);
                }
                manager.add(scrollPane3);
                scrollPane3.setBounds(410, 55, 135, 170);

                //---- loggedIn_Label ----
                loggedIn_Label.setText(bundle.getString("MainMenu.loggedIn_Label.text"));
                manager.add(loggedIn_Label);
                loggedIn_Label.setBounds(5, 10, 120, loggedIn_Label.getPreferredSize().height);

                //---- removeButton ----
                removeButton.setText(bundle.getString("MainMenu.removeButton.text"));
                removeButton.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        removeButtonMouseClicked(e);
                    }
                });
                manager.add(removeButton);
                removeButton.setBounds(new Rectangle(new Point(506, 245), removeButton.getPreferredSize()));

                //---- logoutButton ----
                logoutButton.setText(bundle.getString("MainMenu.logoutButton.text"));
                logoutButton.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        logoutButtonMouseClicked(e);
                    }
                });
                manager.add(logoutButton);
                logoutButton.setBounds(560, 5, 78, logoutButton.getPreferredSize().height);

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

                //---- field_pwdgenPasswordLength ----
                field_pwdgenPasswordLength.setText(bundle.getString("MainMenu.field_pwdgenPasswordLength.text"));
                passwordGen.add(field_pwdgenPasswordLength);
                field_pwdgenPasswordLength.setBounds(190, 60, 290, field_pwdgenPasswordLength.getPreferredSize().height);
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

            //======== addPassword ========
            {
                addPassword.setLayout(null);

                //---- AddPasswordLabel ----
                AddPasswordLabel.setText(bundle.getString("MainMenu.AddPasswordLabel.text"));
                AddPasswordLabel.setFont(new Font("Grold Rounded Slim Medium", Font.PLAIN, 24));
                AddPasswordLabel.setHorizontalAlignment(SwingConstants.CENTER);
                addPassword.add(AddPasswordLabel);
                AddPasswordLabel.setBounds(0, 0, 650, 40);

                //---- Platform_Label ----
                Platform_Label.setText(bundle.getString("MainMenu.Platform_Label.text"));
                addPassword.add(Platform_Label);
                Platform_Label.setBounds(80, 65, 75, 30);
                addPassword.add(field_addPlatform);
                field_addPlatform.setBounds(155, 65, 330, field_addPlatform.getPreferredSize().height);

                //---- Username_Label ----
                Username_Label.setText(bundle.getString("MainMenu.Username_Label.text"));
                addPassword.add(Username_Label);
                Username_Label.setBounds(80, 105, 75, 30);
                addPassword.add(field_addUsername);
                field_addUsername.setBounds(155, 105, 330, field_addUsername.getPreferredSize().height);

                //---- Password_Label ----
                Password_Label.setText(bundle.getString("MainMenu.Password_Label.text"));
                addPassword.add(Password_Label);
                Password_Label.setBounds(80, 145, 75, 30);
                addPassword.add(field_addPassword);
                field_addPassword.setBounds(155, 145, 330, field_addPassword.getPreferredSize().height);

                //---- addButton ----
                addButton.setText(bundle.getString("MainMenu.addButton.text"));
                addButton.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        addButtonMouseClicked(e);
                    }
                });
                addPassword.add(addButton);
                addButton.setBounds(215, 215, 210, 30);

                //---- addErrorLabel ----
                addErrorLabel.setHorizontalAlignment(SwingConstants.CENTER);
                addPassword.add(addErrorLabel);
                addErrorLabel.setBounds(0, 180, 650, 30);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < addPassword.getComponentCount(); i++) {
                        Rectangle bounds = addPassword.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = addPassword.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    addPassword.setMinimumSize(preferredSize);
                    addPassword.setPreferredSize(preferredSize);
                }
            }
            tabbedPane1.addTab(bundle.getString("MainMenu.addPassword.tab.title"), addPassword);
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
    public JTabbedPane tabbedPane1;
    public JPanel manager;
    public JLabel PasswordManagerLabel;
    public JButton updateButton;
    public JScrollPane scrollPane1;
    public JList platformList;
    public JScrollPane scrollPane2;
    public JList usernameList;
    public JScrollPane scrollPane3;
    public JList passwordList;
    public JLabel loggedIn_Label;
    public JButton removeButton;
    public JButton logoutButton;
    public JPanel passwordGen;
    public JLabel passwordGenLabel;
    public JButton generateButton;
    public JTextField passwordOut;
    public JLabel passwordOutLabel;
    public JLabel passwordLengthLabel;
    public JTextField field_pwdgenPasswordLength;
    public JSeparator seperator;
    public JLabel errorLabel;
    public JPanel addPassword;
    public JLabel AddPasswordLabel;
    public JLabel Platform_Label;
    public JTextField field_addPlatform;
    public JLabel Username_Label;
    public JTextField field_addUsername;
    public JLabel Password_Label;
    public JPasswordField field_addPassword;
    public JButton addButton;
    public JLabel addErrorLabel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
