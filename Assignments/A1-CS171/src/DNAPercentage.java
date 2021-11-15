/*THIS CODE WAS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING CODE WRITTEN BY OTHER STUDENTS OR COPIED FROM ONLINE RESOURCES. Diego Bobrow*/
public class DNAPercentage {
    public static void main(String[] args) {
        try {
            //for Part 1 I would expect to see 0.25*0.25*0.25*1000 mers AAA which is near 16, and when it compiles it is normally around that number
            int amountOfAAA = DNArandomizer(1000, 0.25, 0.25, 0.25, 0.25); // Part 1

            // for Part 2 I would expect to see 0.12*0.12*0.12*1000 mers AAA which is near 2, and when it compiles it is normally around that number
            int amountOfAAA2 = DNArandomizer(1000, 0.12, 0.38, 0.39, 0.11);// Part 2

            int amountOfAAAExtra = DNArandomizer(747, 0.33, 0.33, 0.33, 0.20);// What would happen if chances sum more than 1
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static int DNArandomizer(int DNAnumber, double chanceA, double chanceC, double chanceG, double chanceT) throws Exception {  //Note that it is expected that the input be in %/100, such as 0.25, for chanceA
        if (chanceA + chanceC + chanceG + chanceT != 1) {
            throw new Exception("All mers chances don`t sum up to 100");
        }

        int countAAA = 0;
        String mers[] = new String[DNAnumber];
        for (int i = 0; i < DNAnumber; i++) {
            String mer = "";
            for (int j = 0; j < 3; j++) {
                double merRandomizer = Math.random() * 1;
                if (merRandomizer <= chanceA) {
                    mer += "A";
                } else if (merRandomizer <= (chanceA + chanceC)) {
                    mer += "C";
                } else if (merRandomizer <= (chanceA + chanceC + chanceG)) {
                    mer += "G";
                } else {
                    mer += "T";
                }
            }
            if (mer.equals("AAA")) {
                countAAA++;
            }
            mers[i] = mer;
            System.out.println(mer); // If you wish to see all mers printed, just uncomment this line
        }
        System.out.println("There was a total of " + countAAA + " mers AAA out of " + mers.length + " mers");
        return countAAA;
    }
}
