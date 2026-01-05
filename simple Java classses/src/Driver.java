



public class Driver {
    public static void main(String[] args) {
    	
        // maximum speed limits from args
        int carMax = Integer.parseInt(args[0]);
        int truckMax = Integer.parseInt(args[1]);

        // car1 via default ctor, then set year/make/speed to Toyota 2021 with speed 15
        Car car1 = new Car();
        car1.setYear(2021);
        car1.setMake("Toyota");
        car1.setSpeed(15);

        
        // car2 via two-arg ctor for Ford 2022; initial speed should be 0
        Car car2 = new Car(2022, "Ford");

        // Print car1 and car2
        System.out.println(car1.toString());
        System.out.println(car2.toString());

        
        // accelerate car2 ten times with max limit = args[0]
        for (int t = 0; t < 10; t++) {
            car2.accelerate(carMax);
        }

        
        // print car2
        System.out.println(car2.toString());

        
        
        // car3 via copy constructor from car1
        Car car3 = new Car(car1);

        
        
        // equals() check: car1 vs car3
        if (car1.equals(car3)) {
            System.out.println("car1 is same as car3");
        } else {
            System.out.println("car1 is not same as car3");
        }

        
        // equals() check: car1 vs car2
        if (car1.equals(car2)) {
            System.out.println("car1 is same as car2");
        } else {
            System.out.println("car1 is not same as car2");
        }

        
        
        // set car3 speed to 88
        car3.setSpeed(88);

        // truck1 via 3-arg ctor for GMC 2022, initial speed 25
        Truck truck1 = new Truck(2022, "GMC", 25);

        // truck2 via default ctor, set to Volvo 2023, initial speed 0
        Truck truck2 = new Truck();
        truck2.setYear(2023);
        truck2.setMake("Volvo");
        truck2.setSpeed(0);

        
        // print trucks before acceleration
        System.out.println(truck1.toString());
        System.out.println(truck2.toString());

        
        
        // accelerate both trucks four times with max limit = args[1]
        for (int t = 0; t < 4; t++) {
            truck1.accelerate(truckMax);
            truck2.accelerate(truckMax);
        }

        
        
        // create Vehicle array with the three cars and two trucks
        Vehicle[] all = new Vehicle[5];
        all[0] = car1;
        all[1] = car2;
        all[2] = car3;
        all[3] = truck1;
        all[4] = truck2;

        
        
        // call brake() three times for all Vehicle objects (polymorphic)
        for (int k = 0; k < 3; k++) {
            for (Vehicle v : all) {
                v.brake();
            }
        }

        
        
        // print all Vehicle objects
        for (Vehicle v : all) {
            System.out.println(v.toString());
        }
    }
}
