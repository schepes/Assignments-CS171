/*THIS CODE WAS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING CODE WRITTEN BY OTHER STUDENTS OR COPIED FROM ONLINE RESOURCES. Diego Bobrow*/

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// Do you know the chess piece that looks like a horse? It's called a "Knight",
// and the "Knight's Tour" is a famous problem where you want the Knight to move
// around a chess board such that it visits every position on the board exactly once.
// Recall that the Knight can move in the shape of the letter "L" in any direction
// IMPORTANT: See our A2 handout for examples and more detailed instructions/hints!

public class KnightTour {
    // TODO: Implement and print a Knight's Tour solution, using
    // the chess board defined in class KnightBoard. Your solution must
    // use a Stack to keep track of different possible sequences of moves
    // for the Knight, in order to discover and return a valid tour.

    // NOTE: There can be several distinct valid tours; your job is to find
    // and print only one valid tour (the first valid one you discover).
    // Please do NOT attempt to discover all possible valid tours! To get
    // a sense of how many valid board configurations exist for different
    // board sizes, see "The Knight's Paths" table here:
    // http://www.behnel.de/knight.html

    /**
     * tour method is where you add your code for implementing
     * a Knight Tour's solution for an n*n chess board
     *
     * @param n size of the board
     * @return KnightBoard object with a valid Knight Tour
     */

    public static KnightBoard tour(int n) {
        // Your solution must utilize the stack "candidates" below,
        // to keep track of different possible sequences of Knight moves
        Stack<KnightBoard> candidates = new Stack<KnightBoard>();
        KnightBoard kb = new KnightBoard(n); // create initial board of size n*n
        candidates.push(kb); // push the initial board onto the stack
        int moveType = 0;
        int startingMove = 0;
        int maxMoves = 0;
        Map<KnightBoard, Integer> startingMoveMap = new HashMap<>();
        KnightBoard temp = kb;
        startingMoveMap.put(kb, startingMove);


        //while (startingMoveMap.get(temp1)<9) {
        // candidates.push(temp1);
        while (!candidates.isEmpty()) {
            kb = candidates.peek();
            if (kb.getMoveCount() > maxMoves) {
                maxMoves = kb.getMoveCount();
                temp = kb;
            }
            boolean notMoved = true;
            int newX = kb.getCurrentX();
            int newY = kb.getCurrentY();

            moveType = startingMoveMap.get(candidates.peek());
            while (notMoved) {
                moveType++;
                KnightBoard copy = kb.copyBoard();
                switch (moveType) {
                    case 1:
                        if (copy.move(newX + 2, newY + 1)) {
                            startingMoveMap.put(copy, 0);
                            startingMoveMap.replace(kb,0);
                            candidates.push(copy);
                            moveType = 0;
                            notMoved = false;
                        }
                        break;
                    case 2:
                        if (copy.move(newX + 2, newY - 1)) {
                            startingMoveMap.put(copy, 0);
                            startingMoveMap.replace(kb,1);
                            candidates.push(copy);
                            moveType = 0;
                            notMoved = false;
                        }
                        break;
                    case 3:
                        if (copy.move(newX - 2, newY + 1)) {
                            startingMoveMap.put(copy, 0);
                            startingMoveMap.replace(kb,2);
                            candidates.push(copy);
                            moveType = 0;
                            notMoved = false;
                        }
                        break;
                    case 4:
                        if (copy.move(newX - 2, newY - 1)) {
                            startingMoveMap.put(copy, 0);
                            startingMoveMap.replace(kb,3);
                            candidates.push(copy);
                            moveType = 0;
                            notMoved = false;
                        }
                        break;
                    case 5:
                        if (copy.move(newX + 1, newY + 2)) {
                            startingMoveMap.put(copy, 0);
                            startingMoveMap.replace(kb,4);
                            candidates.push(copy);
                            moveType = 0;
                            notMoved = false;
                        }

                        break;
                    case 6:
                        if (copy.move(newX + 1, newY - 2)) {
                            startingMoveMap.put(copy, 0);
                            startingMoveMap.replace(kb,5);
                            candidates.push(copy);
                            moveType = 0;
                            notMoved = false;
                        }
                        break;
                    case 7:
                        if (copy.move(newX - 1, newY + 2)) {
                            startingMoveMap.put(copy, 0);
                            startingMoveMap.replace(kb,6);
                            candidates.push(copy);
                            moveType = 0;
                            notMoved = false;
                        }
                        break;
                    case 8:
                        if (copy.move(newX - 1, newY - 2)) {
                            startingMoveMap.put(copy, 0);
                            startingMoveMap.replace(kb,7);
                            candidates.push(copy);
                            moveType = 0;
                            notMoved = false;
                        }
                        break;
                }
                if (moveType > 8) {
                    break;
                }
            }

            if (moveType > 8) {
                candidates.pop();
                if (candidates.isEmpty()) {
                    break;
                }
                startingMoveMap.replace(candidates.peek(), startingMoveMap.get(candidates.peek()) + 1);
                if (startingMoveMap.get(candidates.peek()) >= 7) {
                    startingMoveMap.remove(candidates.peek());
                    candidates.pop();
                    startingMoveMap.replace(candidates.peek(), startingMoveMap.get(candidates.peek()) + 1);
                }
            }
            if(((n == 3|| n == 4) && maxMoves == n*n-1)||maxMoves >= n*n){
                return temp;
            }

            if (candidates.isEmpty()) {
                return temp;
            }
        }
        //}
        // TODO: ...... Add your solution code here ..... //

        return temp; //TODO: return a KnightBoard object with a valid Knight Tour
    }


    // Do NOT modify this main method. If you need to add code for
    // testing your solution, just make sure to comment it out before submission
    public static void main(String[] args) {
        int n = 8; // default board size if user didn't specify
        // pass in parameter n from command line
        if (args.length == 1) {
            n = Integer.parseInt(args[0].trim());
            if (n < 3) {
                System.out.println("Incorrect parameter (n must be >= 3)");
                System.exit(-1);
            }
        }
        long startTime = System.nanoTime();
        KnightBoard winner = KnightTour.tour(n);
        long endTime = System.nanoTime();
        double delta = (endTime - startTime) / 1e6;
        // Display the solution you discovered:
        System.out.println("\nPossible Knight Tour with max #squares visited in this (" + n + "x" + n + ") board:");
        winner.printChessBoard();
        System.out.println("\n(Time to find this solution = " + delta + " milliseconds)");
    }
}






