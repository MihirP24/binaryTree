/**
 * CSCI 2110 Lab 6
 * By Mihir Patel
 * B00915555
 *
 * This is the main class for the BinaryTree class,which takes input from the user
 * I have used ArrayList and basic java OOPs concept in this class
 */

import java.util.ArrayList;
import java.util.*;

public class Exercise2 {
    public static void main(String[] args) {

        // initialize a scanner class
        Scanner kb = new Scanner(System.in);

        // taking input from user
        System.out.print("Enter name or done:");
        String name = kb.nextLine();

        // creating ArrayList and BinaryTree
        ArrayList<BinaryTree<String>> input = new ArrayList<>();
        BinaryTree<String> B;

        // while loop to take input until user type 'done' and store all inputs in the ArrayList
        while (!name.equals("done")) {
            B = new BinaryTree<String>();
            B.makeRoot(name);
            input.add(B);
            System.out.print("Enter name or done:");
            name = kb.nextLine();
        }

        // created another BinaryTree to make the BinaryTree
        BinaryTree<String> C = new BinaryTree<String>();

        // assigning the first tree in the binary tree from ArrayList
        // if condition to check whether have more elements or not and do accordingly
        C.makeRoot(input.get(0).getData());
        if (input.size() >= 2) {
            C.attachLeft(input.get(1));
            if (input.size() >= 3) {
                C.attachRight(input.get(2));
            }
        }


        // for loop to attach the left and right element as needed
        // if condition to check that the index number doesn't go out of bound
        for (int i = 1; i <= input.size(); i++) {
            if ((i + (i + 1)) < input.size()) {
                input.get(i).attachLeft(input.get(i + (i + 1)));
                if ((i + (i + 2) < input.size())) {
                    input.get(i).attachRight(input.get(i + (i + 2)));
                }
            }
        }

        // printing the output
        System.out.printf("\nHeight of the tree is: %d\n", BinaryTree.height(C));

        System.out.printf("Number of nodes in the tree is: %d\n", BinaryTree.nodes(C));

        System.out.println();

        System.out.print("Inorder:\t\t");
        BinaryTree.inorder(C);
        System.out.println();

        System.out.print("Preorder:\t\t");
        BinaryTree.preorder(C);
        System.out.println();

        System.out.print("Postorder:\t\t");
        BinaryTree.postorder(C);
        System.out.println();

        System.out.print("Level order:\t\t");
        BinaryTree.levelOrder(C);
        System.out.println();
        System.out.println();



    }
}
