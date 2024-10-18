package org.group08.util;

import java.util.regex.Pattern;

/**
 * @author boosterLEL
 * @apiNote
 * @since 2024/10/18
 */
public class RegEX {
    public static boolean isEmail(String input) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(input).matches();
    }

    public static boolean isValidEmail(String input) {
        String emailRegex = "^[a-zA-Z]+\\.[a-zA-Z]+@university\\.com$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(input).matches();
    }
}
