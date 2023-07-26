package ss19_string_regex.validate_class;

public class ClassesName {
    private static final String VALIDATE_NAME_CLASSES = "^[CAP]\\d{4}[GHIK]$";
    public static boolean validateNameClasses(String nameClass){
        return nameClass.matches(VALIDATE_NAME_CLASSES);
    }
}
