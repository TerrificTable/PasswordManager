package password.manager;

import encryption.encoder.Base64Encoder;
import password.Main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SaveData {
    private static File _ConfigFile;
    private static int rnd;
    private File ConfigFile;

    public static void save() throws IOException {
        _ConfigFile = new File(System.getenv("APPDATA") + "\\PasswordManager\\");

        rnd = (int) Math.floor(Math.random() * 2);

        File save_file = new File(_ConfigFile.getAbsolutePath(), Base64Encoder.Companion.Base64RotEncode("Logins", rnd) + "-#12" + rnd + ".txt");
        BufferedWriter save_out = new BufferedWriter(new FileWriter(save_file));

        // TODO
        // for (int i=0; i<Main.usernames.size(); i++) {
        //     save_out.write(Main.platforms.get(i) + "<_:_>" + Main.usernames.get(i) + "<_:_>" + Main.passwords.get(i));
        //     save_out.write("\r\n");
        // }

        save_out.close();
    }
}
