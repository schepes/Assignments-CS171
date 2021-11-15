/*THIS CODE WAS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING CODE WRITTEN BY OTHER STUDENTS OR COPIED FROM ONLINE RESOURCES. Diego Bobrow*/
public class GoodNumbers {
    public int countGoodNumbers(long n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {//since it cannot have leading zeros, the only possibility for the firs digit where it can have 5 choices is when n =1, that is why this case is separated.
            return 5;
        } else if (n % 2 == 0) {
            return (int) (4 * (Math.pow(4, n / 2)) * (Math.pow(5, (n - 2) / 2)));
        }
        return (int) (4 * Math.pow(4, n / 2) * Math.pow(5, n / 2));

    }

    public static void main(String[] args) {
        GoodNumbers test = new GoodNumbers();
        for (int i = 0; i < 10; i++) {
            System.out.println(test.countGoodNumbers(i));
        }
    }
}
