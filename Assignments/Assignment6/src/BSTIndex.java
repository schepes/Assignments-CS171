/*THIS CODE WAS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING CODE WRITTEN BY OTHER STUDENTS OR COPIED FROM ONLINE RESOURCES. Diego Bobrow*/
public class BSTIndex {
    private class Node {
        private String key;
        private MovieInfo data;
        private Node left, right;

        public Node(MovieInfo info) {
            data = info;
            key = data.shortTitle;
        }
    }

    private Node root;

    public BSTIndex() {
        root = null;
    }

    // --------- [DO NOT MODIFY!] public BST methods  --------- //
    /* Important: Notice that each public method here calls another private method while passing it a reference to the tree root. This is a common way of structuring BST functions such that external client code will not have direct access to the tree root. You will be implementing the code in the private methods, not the public ones. */

    /* Calculate and return the height of the current tree. */
    public int calcHeight() {
        return calcNodeHeight(this.root);
    }

    /* Insert the given data element into the proper place in the BST structure. */
    public void insertMovie(MovieInfo data) {
        root = insertMovie(data, this.root);
    }

    /* Find and return the data element (i.e. the MovieInfo object)
    of the node where the movie's shortTitle matches the given key.
    Return null if the movie is not found. */
    public MovieInfo findMovie(String key) {
        return findMovie(this.root, key);
    }

    /* Print out all movies in the database whose shortTitle begins with
    the passed prefix string. If no movies match the given prefix, nothing
    will be printed. The order of printing does not matter, but make sure
    to print each match in a separate line. */
    public void printMoviesPrefix(String prefix) {
        printMoviesPrefix(this.root, prefix);
    }
    // ----------------- end of public methods ------------------ //


    // ------------- [TODO] private BST methods --------------- //
    private int calcNodeHeight(Node t) {
        if (t == null) {
            return 0;
        }

        int left = calcNodeHeight(t.left);
        int right = calcNodeHeight(t.right);
        if (left > right) {
            return left + 1;
        }
        return right + 1;
    }


    private Node insertMovie(MovieInfo data, Node t) {
        if (t == null) {
            t = new Node(data);
            t.key = data.shortTitle;
            return t;
        }

        if (t.data == data) {
            return null;
        }

        if (data.ID < t.data.ID) {
            t.left = insertMovie(data, t.left);
        }
        t.right = insertMovie(data, t.right);

        return t;

    }

    private MovieInfo findMovie(Node t, String key) {
        if (t == null) {
            return null;
        }
        if (t.key.equals(key)) {
            return t.data;
        }
        MovieInfo left = findMovie(t.left, key);
        MovieInfo right = findMovie(t.right, key);
        if (left != null) {
            return left;
        }
        return right;
    }

    private void printMoviesPrefix(Node t, String prefix) {

        if (t.key.startsWith(prefix.substring(0,prefix.length()-1))) {
            System.out.println(t.key);
        }
        if (t.left != null) {
            printMoviesPrefix(t.left, prefix);
        }
        if (t.right != null) {
            printMoviesPrefix(t.right, prefix);
        }


    }

}
