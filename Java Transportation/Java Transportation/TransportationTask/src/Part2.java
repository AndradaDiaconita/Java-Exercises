package TransportationTask.src;

import Aircrafts.Aircraft;
import Aircrafts.WorldWarTwoAircraft;
import Ferrys.Ferry;
import Metros.Metro;
import MonoWheels.MonoWheel;
import Trains.Train;
import Trams.Tram;
import WheeledTransportaions.WheeledTransportation;




/**
 * This class is used to test the classes in the project
 */
public class Part2 {

    /**
     * This method copies the objects in the array
     * @param objects the array of objects
     * @return the copied array
     */
    public static Object[] CopyTheObjects(Object[] objects){
        Object[] copyArray = new Object[objects.length];
        int idx = 0;
        for(Object obj: objects){
            copyArray[idx++] = obj;
        }
        return copyArray;
    }

    /**
     * This method finds the most and least expensive flights in the array
     * @param args the array of objects
     */
    public static void main(String[] args){
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

        Object [] cloneObjects = CopyTheObjects(objects);

        for(int i=0; i<objects.length; i++){
            System.out.println(objects[i] == cloneObjects[i]);
        }
    }
}
