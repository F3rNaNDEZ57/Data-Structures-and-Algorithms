import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

class treeNode {
    int data;
    treeNode left;
    treeNode right;
}

class BST {
    // Task 1 start
    private treeNode createNode(int data){
        treeNode node = new treeNode();
        node.data = data;
        node.left = null;
        node.right = null;
        return node;
    }

    public treeNode insert(treeNode root, int data){
        if (root == null){
            return createNode(data);
        }

        if (data < root.data){
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        }

        return root;
    }

    public void inOrderTraversal(treeNode root){
        if (root != null){
            inOrderTraversal(root.left);
            System.out.print(root.data+" ");
            inOrderTraversal(root.right);
        }
    }

    public void preOrderTraversal(treeNode root){
        if (root != null){
            System.out.print(root.data+" ");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }

    public void postOrderTraversal(treeNode root){
        if (root != null){
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.print(root.data+" ");
        }
    }

    public void inOrderTraversalDescending(treeNode root){
        if (root != null){
            inOrderTraversalDescending(root.right);
            System.out.print(root.data+" ");
            inOrderTraversalDescending(root.left);
        }
    }
    // Task 1 end

    // Task 3 start
    public treeNode deleteNode(treeNode root, int value){
        if (root == null){
            return null;
        }

        if (value < root.data){
            root.left = deleteNode(root.left, value);
        } else if (value > root.data) {
            root.right = deleteNode(root.right, value);
        }else {

            if (root.left == null){
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            root.data = minValue(root.right);
            root.right = deleteNode(root.right, root.data);
        }
        return root;
    }

    private int minValue(treeNode root){
        int minValue = root.data;
        while(root.left != null){
            root = root.left;
            minValue = root.data;
        }
        return minValue;
    }

    // Task 3 end

    // EXTRA task SEARCH and TASK 4 start

    public treeNode searchNode(treeNode root ,int value){
        if (root == null || root.data == value){
            return root;
        }

        if ( value < root.data){
            return searchNode(root.left, value);
        }else {
            return searchNode(root.right, value);
        }
    }

    public int maxValue(treeNode root) {
        int maxValue = root.data;
        while(root.right != null){
            root = root.right;
            maxValue = root.data;
        }
        return maxValue;
    }

    // EXTRA task SEARCH and TASK 4 end


    // TASK 5 started





    // TASK 6 START
    public void draw(treeNode root) {
        JFrame frame = new JFrame("Binary Search Tree");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawTree(g, root, 400, 50, 200);
            }
        };

        frame.add(panel);
        frame.setVisible(true);
    }

    private void drawTree(Graphics g, treeNode node, int x, int y, int offsetX) {
        if (node != null) {
            g.setColor(Color.GREEN); // Set color for node circle
            g.fillOval(x - 10, y - 10, 20, 20); // Draw node circle

            g.setColor(Color.BLACK); // Set color for the text to ensure visibility
            g.drawString(Integer.toString(node.data), x - 5, y + 5); // Display the value in black

            if (node.left != null) {
                int xLeft = x - offsetX;
                int yLeft = y + 50;
                g.drawLine(x, y, xLeft, yLeft); // Line color already set to black
                drawTree(g, node.left, xLeft, yLeft, offsetX / 2);
            }

            if (node.right != null) {
                int xRight = x + offsetX;
                int yRight = y + 50;
                g.drawLine(x, y, xRight, yRight); // Line color already set to black
                drawTree(g, node.right, xRight, yRight, offsetX / 2);
            }
        }
    }
    // TASK 6 END


}
public class Main {
    public static void main(String[] args) {
        // Task 1 & 2 START
        ArrayList<Integer> dragonAgesList = new ArrayList<>();
        int[] dAges = {24, 17, 31, 13, 19, 29, 40, 11, 22, 21, 56};
        for (int age : dAges){
            dragonAgesList.add(age);
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter dragon ages as int or enter 'end' to finish -: ");

        while(scanner.hasNext()){
            String input = scanner.next();
            if("end".equalsIgnoreCase(input)){
                break;
            }else {
                try{
                    int age = Integer.parseInt(input);
                    dragonAgesList.add(age);
                }catch (NumberFormatException e){
                    System.out.println("Please enter a valid number or 'end' to finish.");
                }
            }
        }

        int[] dragonAges = dragonAgesList.stream().mapToInt(i -> i).toArray();
        BST treeOfWisdom = new BST();
        treeNode root = null;
        for (int age : dragonAges) {
            root = treeOfWisdom.insert(root, age);
        }

        treeOfWisdom.draw(root);
        System.out.print("InOrderTraversal -: ");
        treeOfWisdom.inOrderTraversal(root);
        System.out.println();
        System.out.print("PreOrderTraversal -: ");
        treeOfWisdom.preOrderTraversal(root);
        System.out.println();
        System.out.print("PostOrderTraversal -: ");
        treeOfWisdom.postOrderTraversal(root);
        System.out.println();
        System.out.print("InOrderTraversalDescending -: ");
        treeOfWisdom.inOrderTraversalDescending(root);
        System.out.println();

        // Task 1 and 2 END

        // Task 3 START
        Scanner scanner1 = new Scanner(System.in);
        System.out.print("Enter dragon ages as int or enter 'end' to finish -: ");

        while(scanner1.hasNext()){
            String input = scanner1.next();
            if("end".equalsIgnoreCase(input)){
                break;
            }else{
                try{
                    int age = Integer.parseInt(input);
                    root = treeOfWisdom.deleteNode(root,age);
                }catch (NumberFormatException e){
                    System.out.println("Please enter a valid number or 'end' to finish.");
                }
            }
        }

        treeOfWisdom.draw(root);
        // Task 3 end

        // Task 4 start
        treeNode oldestDragonEgg = treeOfWisdom.searchNode(root,treeOfWisdom.maxValue(root));
        if (oldestDragonEgg != null){
            System.out.println("Oldest dragon egg("+oldestDragonEgg.data+" years old) is exist");
        }else {
            System.out.println("Oldest dragon egg does not exist");
        }
        // Task 4 end


    }
}