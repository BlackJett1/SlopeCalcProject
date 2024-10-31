public class LinearEquation {
    private int x1, y1, x2, y2;


    public LinearEquation(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }


    public double distance() {
        return roundedToHundredth(Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)));
    }


    public double yIntercept() {
        return roundedToHundredth(y1 - slope() * x1);
    }


    public double slope() {
        if (x1 == x2) {
            return Double.NaN;
        }
        return roundedToHundredth((double) (y2 - y1) / (x2 - x1));
    }


    public String equation() {
            if (x1 == x2) {
                return "x = " + x1;
            }
            if (y1 == y2){
                return "y = " + y1;
            }

            double m = slope();
            double b = yIntercept();

            String slopeString = formatSlope(m);
            String interceptString = (b == 0) ? "" : (b > 0 ? " + " : " - ") + Math.abs(b);

            String equation = "y = " + (m == 0 ? interceptString.trim() : slopeString + "x" + interceptString);
            return equation.trim();
    }


    public String coordinateForX(double x) {
        double y = slope() * x + yIntercept();
        return "(" + roundedToHundredth(x) + ", " + roundedToHundredth(y) + ")";
    }


    public String lineInfo() {
        String lineInfo = "\n"+"The two points are: (" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2 + ")\n";
        lineInfo += "The equation of the line between these points is: " + equation() + "\n";
        lineInfo += "The y-intercept of this line is: " + yIntercept() + "\n";
        lineInfo += "The slope of this line is: " + slope() + "\n";
        lineInfo += "The distance between these points is: " + distance();
        return lineInfo;
    }


    public boolean isVertical() {
        return x1 == x2;
    }


    private double roundedToHundredth(double toRound) {
        return Math.round(toRound * 100.0) / 100.0;
    }


    private String formatSlope(double m) {
        if (m == 0) {
            return "";
        }




        int numerator = (int) (y2 - y1);
        int denominator = (int) (x2 - x1);




        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }


        // Simplify the fraction
        int gcd = gcd(Math.abs(numerator), Math.abs(denominator));
        numerator /= gcd;
        denominator /= gcd;




        String fraction = numerator + "/" + denominator;




        if (m == 1) {
            return "";
        } else if (m == -1) {
            return "-";
        }


        return fraction;
    }


    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}






