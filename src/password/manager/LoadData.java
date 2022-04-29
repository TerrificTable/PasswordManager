package password.manager;

import encryption.decoder.Base85Decoder;
import encryption.encoder.Base64Encoder;
import password.Main;

import java.io.*;

public class LoadData {
    private static File _ConfigFile;
    // TODO: Add something to save/load master accounts

    public static void load() throws IOException {
        _ConfigFile = new File(System.getenv("APPDATA") + "\\PasswordManager\\");

        File logins_file = new File(_ConfigFile.getAbsolutePath(), Base64Encoder.Companion.Base64Encode("Logins") + ".txt");
        FileInputStream logins_fstream = new FileInputStream(logins_file.getAbsolutePath());
        DataInputStream logins_in = new DataInputStream(logins_fstream);
        BufferedReader logins_br = new BufferedReader(new InputStreamReader(logins_in));

        String line;
        while ((line = logins_br.readLine()) != null) {
            String[] content = line.split("<_:_>");

            String platform = content[0];
            String username = content[1];
            String password = content[2];

            platform = Base85Decoder.Base85Decode(platform);
            username = Base85Decoder.Base85Decode(username);
            password = Base85Decoder.Base85Decode(password);

            Main.platformList.add(platform);
            Main.usernameList.add(username);
            Main.passwordList.add(password);

            Main.window.platformList.setListData(Main.platformList);
            Main.window.usernameList.setListData(Main.usernameList);
            Main.window.passwordList.setListData(Main.passwordList);
        }

        logins_br.close();
    }
}
