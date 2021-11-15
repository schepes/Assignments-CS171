/*THIS CODE WAS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING CODE WRITTEN BY OTHER STUDENTS OR COPIED FROM ONLINE RESOURCES. Diego Bobrow*/
public class ShapeTester {

    // !!!Important!!!
    // All methods in this class should be declared "static"

    // TODO: [2 pts] Write the method isLarger which takes as input two shapes
    // (a Circle first, then a Rectangle) and returns true if the area of
    // the circle is bigger than (or equal to) the area of the rectangle,
    // false otherwise.
    public static boolean isLarger(Circle circle, Rectangle rectangle) { // Professor, I wanted here to use an interface
        if (circle.getArea() > rectangle.area()) {      //shape, where circle and rectangle implemented it, however since
            return true;// the method names of getting area of circle and rectangle are different I thought it was un-wize
        }
        return Math.abs(circle.getArea() - rectangle.area()) < 0.0001;
    }

    // TODO: [2 pts] Write the method longerPerim which takes as input
    // a Circle object followed by a Rectangle object and returns
    // the length of the perimeter of the longer of the two objects.
    public static double longerPerim(Circle circle, Rectangle rectangle) {
        return circle.getCircumference() > rectangle.perimeter() ? circle.getCircumference() : rectangle.perimeter();
    }

    // TODO: [2 pts] Write another version of the method longerPerim which has the
    // same name and functionality but it takes as input a Rectangle object
    // followed by a Circle object. The method also returns the length of
    // the perimeter of the longer of the two objects.
    public static double longerPerim(Rectangle rectangle, Circle circle) {
        return circle.getCircumference() > rectangle.perimeter() ? circle.getCircumference() : rectangle.perimeter();
    }

    // TODO: [2 pts] Write the method largerArea which takes as input
    // a Circle object followed by a Rectangle object and returns
    // the area of the larger of the two objects.
    public static double largerArea(Circle circle, Rectangle rectangle) {
        return circle.getArea() > rectangle.area() ? circle.getArea() : rectangle.area();
    }

    // TODO: [2 pts] Writer another version of the method largerArea which has the
    // same name and functionality but it takes as input a Rectangle object
    // followed by a Circle object.
    public static double largerArea(Rectangle rectangle, Circle circle) {
        return circle.getArea() > rectangle.area() ? circle.getArea() : rectangle.area();
    }

    // TODO: [10 pts] Write the method containsCenter which takes as input two circles,
    // and returns true if the first circle contains the center of the second circle,
    // false otherwise.
    public static boolean containsCenter(Circle circle1, Circle circle2) {
        return circle1.containsPoint(circle2.x, circle2.y);
    }

    public static void main(String[] args) {
        Circle circle = new Circle(2, 2, 2);
        Rectangle rectangle = new Rectangle(Math.PI, 4, 1, 1);

        System.out.println(isLarger(circle, rectangle));
    }

}
