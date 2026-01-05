

public class CCCS300A1 {
    public static void main(String[] args) {
        
        final double RUNNING6MPH_METS = 10.0;
        final double BASKETBALL_METS = 8.0;
        final double SLEEPING_METS = 1.0;

        
        int runningWeightPounds = Integer.parseInt(args[0]);
        int basketballWeightPounds = Integer.parseInt(args[1]);
        int sleepingWeightPounds = Integer.parseInt(args[2]);

       
        double runningWeightKg = runningWeightPounds / 2.2;
        double basketballWeightKg = basketballWeightPounds / 2.2;
        double sleepingWeightKg = sleepingWeightPounds / 2.2;

        
        double runningCalories = 0.0175 * RUNNING6MPH_METS * runningWeightKg * 30;
        double basketballCalories = 0.0175 * BASKETBALL_METS * basketballWeightKg * 60;
        double sleepingCalories = 0.0175 * SLEEPING_METS * sleepingWeightKg * 360;

        
        runningCalories = ((int)(runningCalories * 100)) / 100.0;
        basketballCalories = ((int)(basketballCalories * 100)) / 100.0;
        sleepingCalories = ((int)(sleepingCalories * 100)) / 100.0;

        
        System.out.println("Welcome to the calorie calculator!");
        System.out.println("A " + runningWeightPounds + "LB person burned an estimated " + runningCalories + " calories by Running");
        System.out.println("A " + basketballWeightPounds + "LB person burned an estimated " + basketballCalories + " calories by playing Basketball");
        System.out.print("A " + sleepingWeightPounds + "LB person burned an estimated " + sleepingCalories + " calories by Sleeping");
    }
}
