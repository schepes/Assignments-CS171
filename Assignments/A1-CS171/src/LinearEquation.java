/*THIS CODE WAS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING CODE WRITTEN BY OTHER STUDENTS OR COPIED FROM ONLINE RESOURCES. Diego Bobrow*/
public class LinearEquation {
    private double a;
    private double b;
    private double c;
    private double d;
    private double e;
    private double f;

    public LinearEquation(double a, double b, double c, double d, double e, double f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public double getD() {
        return d;
    }

    public double getE() {
        return e;
    }

    public double getF() {
        return f;
    }

    public boolean isSolvable() {
        if (a * d - b * c != 0) {
            return true;
        }
        return false;
    }

    public double getX() throws Exception {
        if (!isSolvable()) {
            throw new Exception("Function is not solvable");
        }
        return (e * d - b * f) / (a * d - b * c);
    }

    public double getY() throws Exception {
        if (!isSolvable()) {
            throw new Exception("Function is not solvable");
        }
        return (a * f - e * c) / (a * d - b * c);
    }

    public static void main(String[] args) {    // testing if it finds correct value and if non-solvable solutions print the error message;
        LinearEquation test = new LinearEquation(1, 2, 0, 4, 4, 4);
        LinearEquation test2 = new LinearEquation(1, 2, 1, 2, 4, 5);
        try {
            System.out.println("X is " + test.getX() + " and Y is " + test.getY());
            System.out.println("X is " + test2.getX() + " and Y is " + test2.getY());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
