package authentication;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
  public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

  /*
    ^ asserts the position at the start of the string.
    [A-Z0-9._%+-]+ matches one or more characters that can be uppercase letters (A-Z), digits (0-9), dots (.), underscores (_), percent signs (%), plus signs (+), or hyphens (-).
    @ matches the literal "@" character.
    [A-Z0-9.-]+ matches one or more characters that can be uppercase letters (A-Z), digits (0-9), dots (.), or hyphens (-).
    \\. matches the literal dot (.) character.
    [A-Z]{2,6} matches between 2 and 6 uppercase letters (A-Z), representing the domain extension.
    $ asserts the position at the end of the string.
    Pattern.CASE_INSENSITIVE makes the pattern case-insensitive, allowing it to match both uppercase and lowercase letters.
  */

  public static final Pattern VALID_PASSWORD_REGEX =
    Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&+=])(?=\\S+$).{8,}$");

  /* Pattern explanation:
     ^ asserts position at start of the string
    (?=.*[0-9]) ensures at least one digit
    (?=.*[a-z]) ensures at least one lowercase letter
    (?=.*[A-Z]) ensures at least one uppercase letter
    (?=.*[!@#$%^&+=]) ensures at least one special character
    (?=\S+$) ensures no whitespace
    .{8,} ensures at least 8 characters
  */

  public static boolean validateEmail(String email) {

    Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
    return matcher.matches();
  }

  public static boolean validatePassword(String password) {
    Matcher matcher = VALID_PASSWORD_REGEX.matcher(password);
    return matcher.matches();
  }
}
