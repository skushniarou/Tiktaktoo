package skushniarou.View;

public class OtherView {
    public static void displayInvalidInputInt() {
        System.out.println("Ungültige Eingabe! Bitte geben Sie eine ganze Zahl ein.");
    }

    public static void displayInvalidInputOverall(){
        System.out.println("Diese Eingabe ist ungültig, geben Sie bitte neu ein!");
    }

    public static void displayInvalidInputSpecified(String text){
        System.out.println("Diese" + text + "ist ungültig, geben Sie bitte neu ein!");
    }

    public static void displayInvalidInputChoice(){
        System.out.println("Auswahl ist ungültig. Geben Sie bitte neu ein.");
    }

    public static void displayInvalidInputBetweenTwoInt(int value1, int value2){
        System.out.println("Ungültige Eingabe. Bitte wählen Sie eine Zahl zwischen " + value1 + " und " + value2 + ".");
    }

    public static void displayInvalidAttribute(String attribute){
        System.out.println("Unbekanntes Attribut: " + attribute);
    }

    public static void printOneLineInfo(String text){
        System.out.println(text);
    }

    public static void printOneLineInfoException(String e){
        System.err.println(e);
    }
}

