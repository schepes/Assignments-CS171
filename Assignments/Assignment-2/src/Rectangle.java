/*THIS CODE WAS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING CODE WRITTEN BY OTHER STUDENTS OR COPIED FROM ONLINE RESOURCES. Diego Bobrow*/
// This class represents a rectangle shape
public class Rectangle {

    private double L; // the length of the rectangle
    private double H; // the height of the rectangle
    private double x; // the x coordinate of the  bottom left corner of the rectangle
    private double y; // the y coordinate of the bottom left corner of the rectangle

    // TODO: [3 pts] Write a basic constructor that creates a rectangle with
    // side lengths 1 whose bottom left corner is at (0.0,0.0)

    public Rectangle() {
        L = 1.0;
        H = 1.0;
        x = 0.0;
        y = 0.0;
    }


    // TODO: [3 pts] Now write a constructor that takes all four inputs,
    // named Ell, Eich, Ex, and Why for L, H, x, and y, respectively.

    public Rectangle(double Ell, double Eich, double Ex, double Why) {
        L = Ell;
        H = Eich;
        x = Ex;
        y = Why;
    }


    // TODO: [2 pts] Write a method called getLength which returns the length.

    public double getLength() {
        return L;
    }


    // TODO: [2 pts] Write a method called getHeight which returns the height.
    public double getHeight() {
        return H;
    }


    // TODO: [2 pts] Write a method called setLength which takes as input a double
    // called Ell and uses it to set the length of the rectangle.
    public void setLength(double Ell) {
        L = Ell;
    }

    // TODO: [2 pts] Write a method called setHeight which takes as input a double
    // called Eich and uses it to set the height of the rectangle.

    public void setHeight(double Eich) {
        H = Eich;
    }

    // TODO: [2 pts] Write a method called perimeter which computes and returns
    // the perimeter of the rectangle.
    public double perimeter() {
        return 2 * L + 2 * H;
    }

    // TODO: [2 pts] Write a method called area which computes and returns the
    // area of the rectangle.
    public double area() {
        return L * H;
    }
    // TODO: [2 pts] Override the method equals which is inherited from class Object
    // (similar to what we did in class Employee), and make it return true if the
    // two rectangles have equal areas, false otherwise
    // Important: Use the @Override annotation

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Rectangle) {
            return Math.abs(this.area() - ((Rectangle) obj).area()) < 0.0001;
        }
        return false;
    }

}
