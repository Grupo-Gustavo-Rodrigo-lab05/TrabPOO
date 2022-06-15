package pt.trabFinal;

public class AppJogo {
    private static String DIR = AppJogo.class.getResource(".").getPath();

    public static void main(String args[]) {
        new JanelaMenu(DIR + "teste.jpg");
    }
}
