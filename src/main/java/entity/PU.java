package entity;

public class PU {

    private static String PU_NAME = "pu_development";

    public static void setPU_Name(String s) {
        PU_NAME = s;
    }

    public static String getPersistenceUnitName() {
        return PU_NAME;
    }
}
