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

         short ergebnis= 1;//(short) (bmi<19.0 ?1 : bmi>25 ?3 : 2);
         switch (ergebnis){
             case 1 :
                 System.out.println("Untergewicht");break;
             case 2:
                 System.out.println("Normalgewicht"); break;
             case 3 :
                 System.out.println("Übergewicht"); break;
             default:
                 System.out.println("Keine Ahnung ;-)"); break;
         }


        // Ausgabe
        System.out.printf("Ihr BMI betraegt %.2f",  bmi);

    }
}
