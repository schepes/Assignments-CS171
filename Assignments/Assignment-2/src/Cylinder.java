import java.util.LinkedList;
import java.util.PriorityQueue;

/*THIS CODE WAS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING CODE WRITTEN BY OTHER STUDENTS OR COPIED FROM ONLINE RESOURCES. Diego Bobrow*/
public class Cylinder extends Circle {
    private double z = 0.0;
    private double height;

    public Cylinder() {
        super();
        height = 1.0;
    }

    public Cylinder(double ex, double why, double r, double height) {
        super(r, ex, why);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double getArea() {
        return super.getArea() * 2 + this.getCircumference() * this.height;
    }

    public double getVolume() {
        return Math.PI * this.radius * this.radius * this.height;
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        pq.add(1);
        pq.add(10);
        System.out.print(pq.remove() + " ");
        pq.add(3);
        System.out.print(pq.peek() + " ");
        pq.add(20);
        pq.remove();
        System.out.println(pq.remove());
    }
}
