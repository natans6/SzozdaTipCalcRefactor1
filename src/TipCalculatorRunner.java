import java.util.Scanner;
import java.text.DecimalFormat;
public class TipCalculatorRunner {
    public static void main(String[] args) {
        System.out.println("Welcome to the tip calculator!");
        Scanner scan = new Scanner(System.in);
        System.out.print("How many people are in your group? ");
        int numPeople = scan.nextInt();
        System.out.print("What's the tip percentage (0 - 100): ");
        int tipPercentage = scan.nextInt();
        System.out.print("Enter a cost in dollars and cents, (-1 to end): ");
        double cost1 = scan.nextDouble();
        TipCalculator tipCalc = new TipCalculator(numPeople, tipPercentage);
        tipCalc.addMeal(cost1);
        while (cost1 != -1.0) {
            System.out.print("Enter a cost in dollars and cents, (-1 to end): ");
            double cost = scan.nextDouble();
            if (cost == -1.0) {
                cost++;
                break;
            }
            tipCalc.addMeal(cost);
        }

        DecimalFormat x = new DecimalFormat("##.00");

        System.out.println("{-----------------------------------------}");
        System.out.println("Total Bill Before Tip: " + tipCalc.getTotalBillBeforeTip());
        System.out.println("Tip Percentage: " + tipCalc.getTipPercentage());
        System.out.println("Total Tip: " + x.format(tipCalc.tipAmount()));
        System.out.println("Total Bill With Tip: " + x.format(tipCalc.totalBill()));
        System.out.println("Per Person Cost Before Tip: " + x.format(tipCalc.perPersonCostBeforeTip()));
        System.out.println("Tip Per Person: " + x.format(tipCalc.perPersonTipAmount()));
        System.out.println("total Cost Per Person: " + x.format(tipCalc.perPersonTotalCost()));
    }
}
