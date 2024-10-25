public class LinearEquation {
    private int x1, y1, x2, y2;




    public LinearEquation(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }




    public double distance() {
        return Math.round(Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)) * 100.0) / 100.0;
    }




    public double yIntercept() {
        double slope = slope();
        return y1 - slope * x1;


    }




    public double slope() {
        if (isVertical()) {
            throw new ArithmeticException("It's a vertical line.");


        }
        return Math.round((double)(y2 - y1) / (x2 - x1)* 100.0) /100.0;




    }




    public String equation() {
        if (isVertical()) {
            return "x = " + x1;
        }




        double m = slope();
        double b = yIntercept();


        if (m == 0) {
            return "y = " + String.format("%.2f", b);
        } else {
            String slopeStr = String.format("%.2f", m);
            String interceptStr = String.format("%.2f", b);
            return "y = " + slopeStr + "x + " + interceptStr;
        }
    }




    public String lineInfo() {
        return  "\n"+"The two points are: "+"("+x1+", "+y1+")" + " "+"("+x2+", "+y2+")"+"\n"+
                "The distance between the two points is: " + distance() + "\n" +
                "The slope of the line is: " + (isVertical() ? "undefined, it's a vertical line." : slope()) + "\n" +
                "The Y-Intercept of the line is: " + (isVertical() ? "undefined, it's a vertical line." : yIntercept()) + "\n" +
                "The equation of the line is: " + equation()+"\n";
    }




    public boolean isVertical() {
        return x1 == x2;
    }




    public String coordinateForX(double x) {
        if (isVertical()) {
            return "undefined, it's a vertical line.";
        }
        double y = slope() * x + yIntercept();
        return String.format("(%s, %.2f)", x, y);
    }
}


