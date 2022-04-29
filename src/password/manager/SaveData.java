package password.manager;

import encryption.encoder.Base64Encoder;
import encryption.encoder.Base85Encoder;
import password.Main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SaveData {
    private static File _ConfigFile;
    private static int rnd;

    public static void save() throws IOException {
        _ConfigFile = new File(System.getenv("APPDATA") + "\\PasswordManager\\");

        File save_file = new File(_ConfigFile.getAbsolutePath(), Base64Encoder.Companion.Base64Encode("Logins") + ".txt");
        BufferedWriter save_out = new BufferedWriter(new FileWriter(save_file));

        for (int i = 0; i < Main.usernameList.size(); i++) {
            String platform = (String) Main.platformList.get(i);
            String username = (String) Main.usernameList.get(i);
            String password = (String) Main.clear_passwordList.get(i);

            platform = Base85Encoder.Base85Encode(platform);
            username = Base85Encoder.Base85Encode(username);
            password = Base85Encoder.Base85Encode(password);

            save_out.write(platform + "<_:_>" + username + "<_:_>" + password);
            save_out.write("\r\n");
        }

        save_out.close();
    }
}
