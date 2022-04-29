package password.generator

import encryption.encoder.RotEncoder


object PasswordGen {
    private val alphabet = "QWERTZUIOPASDFGHJKLYXCVBNMqwertzuiopasdfghjklyxcvbnm1234567890!+*#-_:;§$%&/()=?@"

    @JvmStatic
    fun Generate(length: Int): String {
        var password = ""
        for (i in 0 until length) {
            var rand: Int = Math.floor(Math.random() * 2 * alphabet.length).toInt()
            while (rand > alphabet.length) rand -= alphabet.length
            if (rand <= 0) rand = 1

            password += alphabet[rand - 1]
        }
        return RotEncoder.RotEncode(password, Math.floor(Math.random() * 7).toInt())
        // return Base85Encoder.Base85RotEncoder(password, (Math.random() * 2).toInt())
    }

}
