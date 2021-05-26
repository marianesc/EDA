import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PredecessorBST {

    private Node root;
    List<Integer> path;

    public PredecessorBST() {
        this.path = new ArrayList<>();
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public void insert(int element) {

        if (isEmpty())
            this.root = new Node(element);
        else {

            Node auxNode = this.root;

            while (auxNode != null) {

                if (element < auxNode.value) {
                    if (auxNode.left == null) {
                        Node newNode = new Node(element);
                        auxNode.left = newNode;
                        newNode.parent = auxNode;
                        return;
                    }

                    auxNode = auxNode.left;
                } else {
                    if (auxNode.right == null) {
                        Node newNode = new Node(element);
                        auxNode.right = newNode;
                        newNode.parent = auxNode;
                        return;
                    }

                    auxNode = auxNode.right;
                }
            }
        }

    }

    public Node search(int element) {

        Node auxNode = this.root;

        while (auxNode != null) {
            if (auxNode.value == element) return auxNode;
            if (element < auxNode.value) auxNode = auxNode.left;
            if (element > auxNode.value) auxNode = auxNode.right;
        }

        return null;
    }

    public Node max(Node node) {
        if (isEmpty()) return null;

        this.path.add(node.value);

        while(node.right != null) {
            path.add(node.right.value);
            node = node.right;
        }

        return node;
    }

    public void predecessor(int element) {
        Node node = search(element);

        if (node == null) return;

        this.path.add(node.value);

        if (node.left != null)
            max(node.left);
        else {
            Node auxNode = node.parent;

            while (auxNode != null && auxNode.value > node.value) {
                this.path.add(auxNode.value);
                auxNode = auxNode.parent;
            }

            if (auxNode != null)
                this.path.add(auxNode.value);
        }
    }

    public String predecessorArray(int element) {
        predecessor(element);
        Integer[] array = this.path.toArray(new Integer[this.path.size()]);
        return Arrays.toString(array);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] elements = sc.nextLine().split(" ");
        int element = sc.nextInt();
        sc.nextLine();

        int[] elementsInt = new int[elements.length];
        PredecessorBST bst = new PredecessorBST();
        for(int i = 0; i < elements.length; i++) {
            elementsInt[i] = Integer.parseInt(elements[i]);
            bst.insert(elementsInt[i]);
        }

        System.out.println(bst.predecessorArray(element));

    }
}

class Node {

    int value;
    Node left;
    Node right;
    Node parent;

    Node(int v) {
        this.value = v;
    }

}
