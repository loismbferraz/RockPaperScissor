package com.rps.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputHandler {

    public static boolean usernameIsValid(String username){
        boolean retVal = false;
        String pattern = "\\w{3,10}";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(username);
        retVal = m.matches();
        return retVal;
    }

    public static boolean profileIsValid(String profile)  {
        boolean retVal = false;
        String upperProf = profile.toUpperCase();
        retVal = switch (upperProf) {
            case "R", "AR", "AP", "AS" -> true;
            default -> false;
        };
        return retVal;
    }

    public static boolean nrRoundsIsValid(String nrRounds){
        boolean retVal = false;
        String pattern = "\\d";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(nrRounds);
        retVal = m.matches() && !"0".equals(nrRounds);
        return retVal;
    }

}
