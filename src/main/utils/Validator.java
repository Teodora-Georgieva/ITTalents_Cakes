package main.utils;

public abstract class Validator {
    public static boolean isValidString(String s){
        return s != null && s.length() > 0;
    }

    public static boolean isValidPhoneNumber(String phoneNumber){
        return isValidString(phoneNumber) && phoneNumber.charAt(0) == '0' && containsOnlyNumbers(phoneNumber);
    }

    private static boolean containsOnlyNumbers(String s){
        for (int i = 0; i < s.length(); i++) {
            if(!(s.charAt(i) >= '0' && s.charAt(i) <= '9')){
                return false;
            }
        }

        return true;
    }
}