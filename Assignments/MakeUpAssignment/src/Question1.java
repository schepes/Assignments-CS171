/*THIS CODE WAS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING CODE WRITTEN BY OTHER STUDENTS OR COPIED FROM ONLINE RESOURCES. Diego Bobrow*/
import java.util.*;

public class Question1 {
    final double ZERO = 0.001;

    public boolean judgePoint24(int[] cards) {
        List<Double> cardsList = new ArrayList<Double>();
        for (int i = 0; i < cards.length; i++) {
            double convertDouble = cards[i];
            cardsList.add(convertDouble);
        }
        return canReach24(cardsList);
    }

    private boolean canReach24(List<Double> cardsList) { // Recursion method with DFS needs flexibility of Array list, that is why I converted
        if (cardsList.size() == 1) {  // Base case
            if (Math.abs(cardsList.get(0) - 24) < ZERO) {
                return true;
            }
            return false;
        }

        for (int i = 0; i < cardsList.size() - 1; i++) {
            for (int j = i + 1; j < cardsList.size(); j++) {
                double card1 = cardsList.get(i);
                double card2 = cardsList.get(j);
                cardsList.remove(j);
                cardsList.remove(i);

                List<Double> possibleOperations = new ArrayList<>();
                possibleOperations.add(card1 + card2);
                possibleOperations.add(card1 - card2);
                possibleOperations.add(card2 - card1);
                possibleOperations.add(card1 * card2);
                possibleOperations.add(card1 / card2);
                possibleOperations.add(card2 / card1);

                for (int z = 0; z < possibleOperations.size(); z++) {
                    cardsList.add(possibleOperations.get(z));
                    if (canReach24(cardsList)) { // Recursion here
                        return true;
                    }
                    cardsList.remove(cardsList.size() - 1);
                }
                cardsList.add(i, card1); //Return cards
                cardsList.add(j, card2);
            }
        }
        return false;
    }
}

