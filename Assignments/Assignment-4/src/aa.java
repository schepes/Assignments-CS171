import javax.swing.*;
import java.util.Stack;

public class aa {
    public static void main(String[] args) {
        Stack<Integer> a = new Stack<>();
        a.push(1);
        a.push(2);
        a.push(3);
        a.push(4);
        a.push(5);
        a.push(6);
        a.push(7);
        a.push(8);
        System.out.println(a.peek());
        a.pop();
        a.pop();
        a.pop();
        a.pop();
        System.out.println(a.peek());

        KnightBoard n = new KnightBoard(3);

        if(n.move(1,2)){
            n.printChessBoard();
        }
    }
}
