package TransportationTask.src;

import Aircrafts.Aircraft;
import Aircrafts.WorldWarTwoAircraft;
import Ferrys.Ferry;
import Metros.Metro;
import Trains.Train;
import Trams.Tram;




/**
 * This class is used to test the classes in the project
 */
public class Part1 {

    /**
     * This method finds the most and least expensive flights in the array
     * @param obj the array of objects
     */
    public static void findLeastAndMostExpensiveFlights(Object[] obj) {

        Aircraft bestAircraft = new Aircraft();
        bestAircraft.setPrice(Integer.MIN_VALUE);
        Aircraft worstAircraft = new Aircraft();
        worstAircraft.setPrice(Integer.MAX_VALUE);

        boolean foundAircraft = false;

       for(Object o : obj){
           if(o.getClass().equals(Aircraft.class)){
               Aircraft aircraft = ((Aircraft) o);
               if(aircraft.getPrice() > bestAircraft.getPrice()){
                   bestAircraft = aircraft;
               }
                if(aircraft.getPrice() < worstAircraft.getPrice()){
                     worstAircraft = aircraft;
                }
               foundAircraft = true;
           }
       }

        System.out.println("\n**************");

       if(!foundAircraft){
           System.out.println("No aircrafts found");
       }else{

           if(bestAircraft.equals(worstAircraft)){

               System.out.println("best and worst aircraft are the same");
               System.out.println(bestAircraft.toString());

           }else{
               System.out.println("Best Aircraft");
               System.out.println(bestAircraft.toString());
               System.out.println("Worst Aircraft");
               System.out.println(worstAircraft.toString());
           }

       }

    }

    /**
     * This method finds the most and least expensive flights in the array
     * @param args the command line arguments
     */
    public static void main(String[] args) {


        Object[] objects = new Object[16];
        objects[0] = new Train();
        objects[1] = new WorldWarTwoAircraft(10, 10, false);
        objects[2] = new Aircraft(20, 10);
        objects[3] = new Aircraft(20, 10);
        objects[4] = new Ferry(10, 15);
        objects[5] = new WorldWarTwoAircraft(10, 10, false);
        objects[6] = new Aircraft(10, 10);
        objects[7] = new WorldWarTwoAircraft(16, 10, false);
        objects[8] = new Ferry(10, 15);
        objects[9] = new Ferry(10, 15);
        objects[10] = new Aircraft(20, 10);
        objects[11] = new WorldWarTwoAircraft(16, 10, false);
        objects[12] = new Train();
        objects[13] = new Train();
        objects[14] = new Aircraft(20, 10);
        objects[15] = new WorldWarTwoAircraft(16, 10, false);

        int idx = 1;
        for(Object o : objects){
            if (idx == 15){
                idx = 1;
            }
            if(o.equals(objects[idx])){
                System.out.println("both objects are equal");
            }else{
                System.out.println("both objects are not equal");
            }
            idx+=1;
        }
        findLeastAndMostExpensiveFlights(objects);

        Object[] objects2 = new Object[16];
        objects2[0] = new Train();
        objects2[1] = new Tram(10,"somewhere1","destnation1", 2001);
        objects2[2] = new Metro(20, "somewhere2", "destination2");
        objects2[3] = new Metro(20, "somewhere3", "destination3");
        objects2[4] = new Ferry(10, 15);
        objects2[5] = new Tram(10,"somewhere4","destnation4", 2001);
        objects2[6] = new Metro(10, "somewhere5", "destination5");
        objects2[7] = new Metro(16, "somewhere6", "destination6");
        objects2[8] = new Ferry(10, 15);
        objects2[9] = new Ferry(10, 15);
        objects2[10] = new Metro(20, "somewhere7", "destination7");
        objects2[11] = new Tram(16,"somewhere8","destnation8", 2001);
        objects2[12] = new Train();
        objects2[13] = new Train();
        objects2[14] = new Metro(20, "somewhere9", "destination9");
        objects2[15] = new Tram(16,"somewhere10","destnation10", 2001);
        /**
         * This method finds the most and least expensive flights in the array
         * @param args
         */
        findLeastAndMostExpensiveFlights(objects2);
    }
}