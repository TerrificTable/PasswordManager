package password.manager;

import encryption.encoder.Base64Encoder;
import password.Main;

import java.io.*;

public class GetData {
    public static String masterPasswd = "test";
    private static File _ConfigFile;
    public static String master = "admin";
    private static int rnd;


    public static void getData() throws IOException {
        _ConfigFile = new File(System.getenv("APPDATA") + "\\PasswordManager\\");
        File[] directoryListing = _ConfigFile.listFiles();
        if (directoryListing != null) {
            for (File file : directoryListing) {
                String pre_rnd = file.getName().split("-#12")[1];
                rnd = Integer.parseInt(pre_rnd.split("\\.")[0]);
            }
        } else { SaveData.save(); getData(); }

        String filename = Base64Encoder.Companion.Base64RotEncode("Logins", rnd);
        File logins_file = new File(_ConfigFile.getAbsolutePath(), filename + "-#12" + rnd + ".txt");
        FileInputStream logins_fstream = new FileInputStream(logins_file.getAbsolutePath());
        DataInputStream logins_in = new DataInputStream(logins_fstream);
        BufferedReader logins_br = new BufferedReader(new InputStreamReader(logins_in));

        String line;
        while ((line = logins_br.readLine()) != null) {
            String[] content = line.split("<_:_>");

            // String platform = content[0];
            // String username = content[1];
            // String password = content[2];

            // Main.platforms.add(platform);
            // Main.usernames.add(username);
            // Main.passwords.add(password);
        }

        logins_br.close();
    }
}
