import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.Stack;

public class Test {

// Do you know the chess piece that looks like a horse? It's called a "Knight",
// and the "Knight's Tour" is a famous problem where you want the Knight to move
// around a chess board such that it visits every position on the board exactly once.
// Recall that the Knight can move in the shape of the letter "L" in any direction
// IMPORTANT: See our A2 handout for examples and more detailed instructions/hints!

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
        final KnightBoard temp1 = kb;
        temp1.printChessBoard();
        startingMoveMap.put(temp1, startingMove);


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
            System.out.println(moveType + " before loop");
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
                            System.out.println("Case 1");
                            System.out.println(copy + " ID of pushed plus starting value is " + startingMoveMap.get(copy));
                            System.out.println("added value " + copy.getMoveCount());
                            candidates.peek().printChessBoard();
                        }
                        break;
                    case 2:
                        if (copy.move(newX + 2, newY - 1)) {
                            startingMoveMap.put(copy, 0);
                            startingMoveMap.replace(kb,1);
                            candidates.push(copy);
                            moveType = 0;
                            notMoved = false;
                            System.out.println("Case 2");
                            System.out.println(copy + " ID of pushed plus starting value" + startingMoveMap.get(copy));
                            System.out.println("added value " + copy.getMoveCount());
                            candidates.peek().printChessBoard();
                        }
                        break;
                    case 3:
                        if (copy.move(newX - 2, newY + 1)) {
                            startingMoveMap.put(copy, 0);
                            startingMoveMap.replace(kb,2);
                            candidates.push(copy);
                            moveType = 0;
                            notMoved = false;
                            System.out.println("Case 3");
                            System.out.println(copy + " ID of pushed plus starting value" + startingMoveMap.get(copy));
                            System.out.println("added value " + copy.getMoveCount());
                            candidates.peek().printChessBoard();
                        }
                        break;
                    case 4:
                        if (copy.move(newX - 2, newY - 1)) {
                            startingMoveMap.put(copy, 0);
                            startingMoveMap.replace(kb,3);
                            candidates.push(copy);
                            moveType = 0;
                            notMoved = false;
                            System.out.println("Case 4");
                            System.out.println(copy + " ID of pushed plus starting value" + startingMoveMap.get(copy));
                            System.out.println("added value " + copy.getMoveCount());
                            candidates.peek().printChessBoard();
                        }
                        break;
                    case 5:
                        if (copy.move(newX + 1, newY + 2)) {
                            startingMoveMap.put(copy, 0);
                            startingMoveMap.replace(kb,4);
                            candidates.push(copy);
                            moveType = 0;
                            notMoved = false;
                            System.out.println("Case 5");

                            System.out.println(copy + " ID of pushed plus starting value" + startingMoveMap.get(copy));
                            System.out.println("added value " + copy.getMoveCount());
                            candidates.peek().printChessBoard();
                        }

                        break;
                    case 6:
                        if (copy.move(newX + 1, newY - 2)) {
                            startingMoveMap.put(copy, 0);
                            startingMoveMap.replace(kb,5);
                            candidates.push(copy);
                            moveType = 0;
                            notMoved = false;
                            System.out.println("Case 6");
                            System.out.println(copy + " ID of pushed plus starting value" + startingMoveMap.get(copy));
                            System.out.println("added value " + copy.getMoveCount());
                            candidates.peek().printChessBoard();
                        }
                        break;
                    case 7:
                        if (copy.move(newX - 1, newY + 2)) {
                            startingMoveMap.put(copy, 0);
                            startingMoveMap.replace(kb,6);
                            candidates.push(copy);
                            moveType = 0;
                            notMoved = false;
                            System.out.println("Case 7");
                            System.out.println(copy + " ID of pushed plus starting value" + startingMoveMap.get(copy));
                            System.out.println("added value " + copy.getMoveCount());
                            candidates.peek().printChessBoard();
                        }
                        break;
                    case 8:
                        if (copy.move(newX - 1, newY - 2)) {
                            startingMoveMap.put(copy, 0);
                            startingMoveMap.replace(kb,7);
                            candidates.push(copy);
                            moveType = 0;
                            notMoved = false;
                            System.out.println("Case 8");
                            System.out.println(copy + " ID of pushed plus starting value" + startingMoveMap.get(copy));
                            System.out.println("added value " + copy.getMoveCount());
                            candidates.peek().printChessBoard();
                        }
                        break;
                }
                if (moveType > 8) {
                    break;
                }
            }

            System.out.println(moveType+ " before pop");
            if (moveType > 8) {
                System.out.println("Chessboard before pop");
                candidates.peek().printChessBoard();
                System.out.println("Chessboard popped");
                candidates.pop().printChessBoard();
                if (candidates.isEmpty()) {
                    System.out.println(maxMoves + "aaaa");
                    break;
                }
                System.out.println("Chessboard after pop");
                candidates.peek().printChessBoard();
                System.out.println(candidates.peek());
                startingMoveMap.replace(candidates.peek(), startingMoveMap.get(candidates.peek()) + 1);
                System.out.println("Changed value of starting" + candidates.peek());
                startingMove = startingMoveMap.get(candidates.peek());
                System.out.println(startingMove + " Starting move");
                if (startingMoveMap.get(candidates.peek()) >= 7) {
                    System.out.println(candidates.search(temp1) + "WHASAAAA");
                    startingMoveMap.remove(candidates.peek());
                    System.out.println("level decreased");
                    candidates.pop();
                    startingMoveMap.replace(candidates.peek(), startingMoveMap.get(candidates.peek()) + 1);
                }
            }// backtracking and change starting move
            if((n == 3 && maxMoves == 8)||maxMoves >= n*n){
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
        int n = 7; // default board size if user didn't specify
        // pass in parameter n from command line
        if (args.length == 1) {
            n = Integer.parseInt(args[0].trim());
            if (n < 3) {
                System.out.println("Incorrect parameter (n must be >= 3)");
                System.exit(-1);
            }
        }
        long startTime = System.nanoTime();
        KnightBoard winner = Test.tour(n);
        long endTime = System.nanoTime();
        double delta = (endTime - startTime) / 1e6;
        // Display the solution you discovered:
        System.out.println("\nPossible Knight Tour with max #squares visited in this (" + n + "x" + n + ") board:");
        winner.printChessBoard();
        System.out.println("\n(Time to find this solution = " + delta + " milliseconds)");
    }
}

