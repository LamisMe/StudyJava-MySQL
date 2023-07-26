package ss19_string_regex.validate_phone_number;

public class PhoneNumber {
    private static final String VALIDATE_PHONE_NUMBER = "^\\d{2}-\\d{9,10}|0\\d{9}$";
    public static boolean validateNameClasses(String phoneNUmber){
        return phoneNUmber.matches(VALIDATE_PHONE_NUMBER);
    }
}
