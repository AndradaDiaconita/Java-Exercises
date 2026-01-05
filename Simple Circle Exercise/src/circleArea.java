
public class circleArea {

	public static void main(String[] args) {
		 
        if (args.length == 0) {
            System.out.println("Give argument");
            return;
        }

        
        double radius = Double.parseDouble(args[0]);

        
        double area = Math.PI * Math.pow(radius, 2);
        double perimeter = 2 * Math.PI * radius;

        
        System.out.println("Radius: " + radius);
        System.out.println("Area: " + area);
        System.out.println("Perimeter: " + perimeter);

	}

}
