package com.codeup.adlister.util;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//import com.github.ankurpathak.password.bean.constraints.ContainDigit;
//import com.github.ankurpathak.password.bean.constraints.ContainSpecial;
//import com.github.ankurpathak.password.bean.constraints.NotContainWhitespace;
//import com.github.ankurpathak.password.bean.constraints.PasswordMatches;
import org.mindrot.jbcrypt.BCrypt;

//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.Size;

public class Password {
    private Pattern pattern;
    private Matcher matcher;
    private static final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20})";

    private static final int ROUNDS = 12;

    public static String hash(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt(ROUNDS));
    }

    public static boolean check(String password, String hash) {
        return BCrypt.checkpw(password, hash);
    }

    public Password(){
        pattern = Pattern.compile(PASSWORD_PATTERN);
    }

    public boolean validate(final String password){

        matcher = pattern.matcher(password);
        return matcher.matches();

    }

    //possible use to make restrictions on the users password.. Still need to figure out how to
    //implement this.
//    @PasswordMatches
//    public class PasswordDto {
//        @Size(min = 8, max = 30)
//        @NotContainWhitespace
//        @ContainSpecial
//        @ContainDigit
//        private String password;
//        @NotBlank
//        private String confirmPassword;
//    }
}
