package password;

import password.manager.LoadData;
import password.manager.window.Login;
import password.manager.window.MainMenu;

import javax.swing.*;
import java.io.IOException;
import java.util.Vector;

public class Main {

    public static MainMenu window = new MainMenu();
    public static Login login = new Login();

    public static Vector platformList = new Vector();
    public static Vector passwordList = new Vector();
    public static Vector clear_passwordList = new Vector();
    public static Vector usernameList = new Vector();
    public static boolean loggedIn = false; // debug
    public static String account;

    public static void init() throws IOException {
        window.loggedIn_Label.setText("Logged In: " + Main.account);
        LoadData.load();

        login.setVisible(true);
    }

    public static boolean correct(JTextField username, JPasswordField password) {
        if (username.getText().equals("admin") && password.getText().equals("test")){
            Main.account = username.getText();
            return true;
        }
        return false;
    }
}
