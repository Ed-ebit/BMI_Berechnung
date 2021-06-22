import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in) ;
        double bmi=0;
        float aktGewicht=0;
        float gewicht=0;
        float groesse=0;
        float minBmi=0;
        float schrittGewicht=.5f;
        int anzWoche=0;

        System.out.println("BMI Rechner V 1.0");
        System.out.print("Bitte Ihren Namen : ");

        String name = scanner.nextLine();
        System.out.print("\nBitte Ihr Gewicht in [KG] : ");
        gewicht =  Float.parseFloat(scanner.nextLine());
        //int gewicht=  scanner.nextInt();
        System.out.print("\nBitte Ihre Groesse in [m] : ");
        groesse = (float)Double.parseDouble( scanner.nextLine());
        System.out.print("\nBitte Wunsch_BMi : ");
        minBmi = (float)Double.parseDouble( scanner.nextLine());
        System.out.print("\nBitte Abnahme pro Woche Gewicht in [Kg] (Default = 0.5Kg) : ");


        String eingabe="";
        eingabe = scanner.nextLine();
        if(! eingabe.isEmpty()){
            schrittGewicht = Float.parseFloat(eingabe);
        }
        aktGewicht=gewicht ;

        scanner.close();
        do {
            bmi = aktGewicht/ (groesse * groesse);
            String ergebnis=
                    bmi<19.0 ?
                        "Untergewicht" :
                    bmi>25 ?
                         "Übergewicht" :
                         "Normalgewicht";
            System.out.printf("%5s\t%3.2f\t%2.2f\t%s\n",
                    anzWoche== 0?" ":anzWoche,
                    aktGewicht,
                    bmi,ergebnis);
            aktGewicht -=  schrittGewicht;
            ++anzWoche; // anzWoche= anzWoche + 1 oder anzWoche += 1
        }while(bmi >= minBmi);

        System.out.println("Der WunschBMi wird nach "+ (anzWoche -1)+" Wochen erreicht");


    }
}
