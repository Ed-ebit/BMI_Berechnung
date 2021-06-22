import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("BMI Rechner V 1.0");
        System.out.print("Bitte Ihren Namen : ");
        Scanner scanner = new Scanner(System.in) ;
        String name = scanner.nextLine();

        System.out.print("\nBitte Ihr Gewicht in [KG] : ");
        int gewicht =  Integer.parseInt(scanner.nextLine());
        //int gewicht=  scanner.nextInt();
        System.out.print("\nBitte Ihre Groesse in [m] : ");

        float groesse = (float)Double.parseDouble( scanner.nextLine());

        double bmi = gewicht/ (groesse * groesse);

        if (bmi <19.0) {
            System.out.println("Untergewicht");
        }else{
            if (bmi>25){
                System.out.println("Übergewicht");
            } else{
                System.out.println("Normalgewicht");
            }
        }


        // Ausgabe
        System.out.printf("Ihr BMI betraegt %.2f",  bmi);

    }
}
