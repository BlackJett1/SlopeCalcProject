import java.util.Scanner;


public class LinearEquationLogic {
    private Scanner scanner;




    public LinearEquationLogic() {
        scanner = new Scanner(System.in);
    }


    public void start() {


        boolean continueLoop = true;


        while (continueLoop) {
            int[] coordinates = getCoordinates();
            LinearEquation equation = new LinearEquation(coordinates[0], coordinates[1], coordinates[2], coordinates[3]);
            System.out.println(equation.lineInfo());




            System.out.print("Enter a value for x: ");
            double xValue = scanner.nextDouble();
            System.out.println("\n"+"The point of the line is: " + equation.coordinateForX(xValue));


            System.out.print("\n"+"Would you like to enter another pair of coordinates? (yes/no):");
            String response = scanner.next().toLowerCase();
            continueLoop = response.equals("yes");
        }


        System.out.println("Thank you for using the slope Calculator, goodbye!!!");
    }


    private int[] getCoordinates() {
        System.out.print("Enter the first coordinate: ");
        String firstPoint = scanner.nextLine();
        System.out.print("Enter the second coordinate: ");
        String secondPoint = scanner.nextLine();


        int x1 = Integer.parseInt(firstPoint.substring(1, firstPoint.indexOf(',')));
        int y1 = Integer.parseInt(firstPoint.substring(firstPoint.indexOf(',') + 2, firstPoint.length() - 1));
        int x2 = Integer.parseInt(secondPoint.substring(1, secondPoint.indexOf(',')));
        int y2 = Integer.parseInt(secondPoint.substring(secondPoint.indexOf(',') + 2, secondPoint.length() - 1));


        return new int[]{x1, y1, x2, y2};
    }
}
