import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("BMI Rechner V 1.0");
        System.out.print("Bitte Ihren Namen : ");
        Scanner scanner = new Scanner(System.in) ;
        String name = scanner.nextLine();
        System.out.print("\nBitte Ihr Gewicht in [KG] : ");
        float gewicht =  Float.parseFloat(scanner.nextLine());
        //int gewicht=  scanner.nextInt();
        System.out.print("\nBitte Ihre Groesse in [m] : ");
        float groesse = (float)Double.parseDouble( scanner.nextLine());
        System.out.print("\nBitte Abbruch BMi : ");
        float maxBmi = (float)Double.parseDouble( scanner.nextLine());
        System.out.print("\nBitte Schrittweite Gewicht in [Kg] (Default = 1Kg) : ");
        float schrittGewicht=1.0f;
        String eingabe="";
        eingabe = scanner.nextLine();
        if(! eingabe.isEmpty()){
            schrittGewicht = Float.parseFloat(eingabe);
        }
        double bmi=0;
        float aktGewicht=gewicht ;
        while (bmi <= maxBmi){

            bmi = aktGewicht/ (groesse * groesse);
            String ergebnis="Normalgewicht";

            switch ((short) (bmi<19.0 ?1 : bmi>25 ?3 : 2)){
                case 1 :
                    ergebnis= "Untergewicht";break;
                case 2: break;
                case 3 :
                    ergebnis="Übergewicht"; break;
                default:
                    ergebnis="Keine Ahnung ;-)"; break;
            }
            System.out.printf("%3.2f\t%2.2f\t%s\n",aktGewicht,bmi,ergebnis);
            aktGewicht= aktGewicht + schrittGewicht;
        }


    }
}
