import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class Patient{
    private  String name;
    private List<Double> bmiWerte = new ArrayList<>();
//    private double[] bmiWerte=new double[1000];
    private  float aktGewicht=0;
    private float gewicht=0;
    private float groesse=0;
    private float minBmi=0;
    private  float schrittGewicht=.5f;
    private int anzWoche=0;

    public  Patient(String name) {
       this.name=name;
    }

    public  void ausgabeBmiWerte() {

        System.out.println("Der WunschBMi wird nach "+ (bmiWerte.size() -1)+" Wochen erreicht");

        for (int i=0 ; i < bmiWerte.size() ;i++){

                System.out.printf("%-10s\t %5.2f \n", "Woche ", bmiWerte.get(i), i);

        }
    }
    public  void berechnungUndSpeicherungBmiWerte() {
        double  bmi=0;
        do {
            bmi = aktGewicht/ Math.pow(groesse ,2);
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
            bmiWerte.add(bmi);
        }while(bmi >= minBmi);
    }
    public void eingabeBmiWerte(Scanner scanner) {

        System.out.println("Hallo " + this.name);
        System.out.print("\nBitte Ihr Gewicht in [KG] : ");
        gewicht =  Float.parseFloat(scanner.nextLine());
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

public class App {

    public static void main(String[] args) {
        App bmiProgramm = new App();
        Patient patient1= new Patient("Bruno");
        Patient patient2= new Patient("Susi");

        patient1.eingabeBmiWerte(new Scanner(System.in));
        patient1.berechnungUndSpeicherungBmiWerte();
        patient1.ausgabeBmiWerte();
        patient2.eingabeBmiWerte(new Scanner(System.in));

      }






}
