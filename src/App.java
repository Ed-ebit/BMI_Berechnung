import java.util.Scanner;

public class App {

     class Patient{
         String name;
         double[] bmiWerte=new double[1000];
         float aktGewicht=0;
         float gewicht=0;
         float groesse=0;
         float minBmi=0;
         float schrittGewicht=.5f;
         int anzWoche=0;
    }

   static Scanner scanner = new Scanner(System.in) ;


    public static void main(String[] args) {
        App bmiProgramm = new App();
        Patient patient1= bmiProgramm.new Patient();
        Patient patient2= bmiProgramm.new Patient();

        bmiProgramm.eingabeBmiWerte(patient1);
        bmiProgramm.eingabeBmiWerte(patient2);
        bmiProgramm.berechnungUndSpeicherungBmiWerte(patient1);
        bmiProgramm.ausgabeBmiWerte(patient1);
        scanner.close();
      }

    private  void ausgabeBmiWerte(Patient p) {

        System.out.println("Der WunschBMi wird nach "+ (p.anzWoche -1)+" Wochen erreicht");

        for (int i=0 ; i < p.bmiWerte.length ;i++){
            if(p.bmiWerte[i] != 0.0) {
                System.out.printf("%-10s\t %5.2f \n", i==0?"Start": "Woche "+i, p.bmiWerte[i]);
            }
        }
    }

    private  void berechnungUndSpeicherungBmiWerte(Patient p) {
        double  bmi=0;
        do {
            bmi = p.aktGewicht/ Math.pow(p.groesse ,2);
            String ergebnis=
                    bmi<19.0 ?
                            "Untergewicht" :
                            bmi>25 ?
                                    "Übergewicht" :
                                    "Normalgewicht";
            System.out.printf("%5s\t%3.2f\t%2.2f\t%s\n",
                    p.anzWoche== 0?" ":p.anzWoche,
                    p.aktGewicht,
                    bmi,ergebnis);


            p.aktGewicht -=  p.schrittGewicht;
            p.bmiWerte[p.anzWoche++]=bmi;
        }while(bmi >= p.minBmi);
    }

    private void eingabeBmiWerte(Patient p) {

        System.out.println("BMI Rechner V 1.0");
        System.out.print("Bitte Ihren Namen : ");
        p.name = scanner.nextLine();
        System.out.print("\nBitte Ihr Gewicht in [KG] : ");
        p.gewicht =  Float.parseFloat(scanner.nextLine());
        System.out.print("\nBitte Ihre Groesse in [m] : ");
        p.groesse = (float)Double.parseDouble( scanner.nextLine());
        System.out.print("\nBitte Wunsch_BMi : ");
        p.minBmi = (float)Double.parseDouble( scanner.nextLine());
        System.out.print("\nBitte Abnahme pro Woche Gewicht in [Kg] (Default = 0.5Kg) : ");

        String eingabe="";
        eingabe = scanner.nextLine();
        if(! eingabe.isEmpty()){
            p.schrittGewicht = Float.parseFloat(eingabe);
        }
        p.aktGewicht=p.gewicht ;

    }
}
