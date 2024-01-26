package utils;

public class ValidateFacility {
    private static final String VALIDATE_CODE_VILLA = "^SVVL-\\d{4}$";
    private static final String VALIDATE_CODE_HOUSE = "^SVHO-\\d{4}$";
    private static final String VALIDATE_CODE_ROOM = "^SVRO-\\d{4}$";
    private static final String VALIDATE_NAME_FACILITY = "^[A-Z][a-z]{0,6}(\\s[A-Z][a-z]{1,6}){1,8}$";

    public static boolean checkValidateCodeVilla(String code) {
        return code.matches(VALIDATE_CODE_VILLA);
    }

    public static boolean checkValidateCodeHouse(String code) {
        return code.matches(VALIDATE_CODE_HOUSE);
    }

    public static boolean checkValidateCodeRoom(String code) {
        return code.matches(VALIDATE_CODE_ROOM);
    }public static boolean checkValidateName(String name) {
        return name.matches(VALIDATE_NAME_FACILITY);
    }
}
