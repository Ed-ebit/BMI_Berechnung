import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in) ;
    static double[] bmiWerte=new double[1000];
    static  float aktGewicht=0;
    static float gewicht=0;
    static float groesse=0;
    static float minBmi=0;
    static float schrittGewicht=.5f;
    static int anzWoche=0;

    public static void main(String[] args) {
        eingabeBmiWerte();
        berechnungUndSpeicherungBmiWerte();
        ausgabeBmiWerte();
      }

    private static void ausgabeBmiWerte() {
        System.out.println("Der WunschBMi wird nach "+ (anzWoche -1)+" Wochen erreicht");

        for (int i=0 ; i < bmiWerte.length ;i++){
            if(bmiWerte[i] != 0.0) {
                System.out.printf("%-10s\t %5.2f \n", i==0?"Start": "Woche "+i, bmiWerte[i]);
            }
        }
    }

    private static void berechnungUndSpeicherungBmiWerte() {
        double  bmi=0;
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
            //++anzWoche; // anzWoche= anzWoche + 1 oder anzWoche += 1
            bmiWerte[anzWoche++]=bmi;
        }while(bmi >= minBmi);
    }

    private static void eingabeBmiWerte() {
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
    }
}
