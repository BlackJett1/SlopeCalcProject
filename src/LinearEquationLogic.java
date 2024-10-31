import java.util.Scanner;

public class LinearEquationLogic {
    private Scanner scanner;

    public LinearEquationLogic() {
        scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Welcome to the Linear Equation Calculator!");

        while (true) {
            System.out.print("Enter the first coordinate: ");
            String point1 = scanner.nextLine();
            System.out.print("Enter the second coordinate: ");
            String point2 = scanner.nextLine();

            int x1 = parsePoint(point1)[0];
            int y1 = parsePoint(point1)[1];
            int x2 = parsePoint(point2)[0];
            int y2 = parsePoint(point2)[1];

            LinearEquation equation = new LinearEquation(x1, y1, x2, y2);
            System.out.println(equation.lineInfo());

            if (equation.isVertical()) {
                System.out.println("This line is vertical (x = " + x1 + ").");
            } else {
                System.out.print("\n"+"Enter an x value for y: ");
                double xValue = Double.parseDouble(scanner.nextLine());
                System.out.println("\n"+"The point on the line is: " + equation.coordinateForX(xValue));
            }

            System.out.print("\n"+"Would you like to enter another pair of points? (yes/no): ");
            if (!scanner.nextLine().equalsIgnoreCase("yes")) {
                break;
            }
        }
        System.out.println("Thank you for using the slope calculator, goodbye!");
        scanner.close();
    }

    private int[] parsePoint(String point) {
        point = point.replace("(", "").replace(")", "").trim();
        String[] coordinates = point.split(", ");
        return new int[]{Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1])};
    }
}
