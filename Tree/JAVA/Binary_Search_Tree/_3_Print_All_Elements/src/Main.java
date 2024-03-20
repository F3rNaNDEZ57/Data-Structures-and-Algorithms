import javax.swing.*;
import java.awt.*;

class treeNode {
    int data;
    treeNode left;
    treeNode right;
}

class BST {

    private treeNode createNewNode(int data){
        treeNode node = new treeNode();
        node.data = data;
        node.left = null;
        node.right = null;
        return node;
    }
    public treeNode insert(treeNode root, int data){
        if (root == null){
            return createNewNode(data);
        }

        if (data < root.data){
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        }

        return root;
    }

    public treeNode deleteNode(treeNode root, int data){
        if (root == null){
            return null;
        }

        if (data < root.data){
            root.left = deleteNode(root.left, data);
        } else if (data > root.data) {
            root.right = deleteNode(root.right, data);
        }else{

            if (root.left == null){
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            root.data = minValue(root.right);
            root.right = deleteNode(root.right,root.data);

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
}

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        treeNode root = null;
        BST a = new BST();

        root = a.insert(root,10);
        root = a.insert(root,20);
        root = a.insert(root,5);
        root = a.insert(root,6);
        root = a.insert(root,4);
        root = a.insert(root,15);
        root = a.insert(root,25);
        root = a.insert(root,35);
        root = a.insert(root,1);
        root = a.insert(root,2);
        root = a.insert(root,21);
        root = a.insert(root,34);
        root = a.insert(root,22);
        root = a.insert(root,0);
        root = a.insert(root,999);
        root = a.insert(root,11);
        root = a.insert(root,3);
        a.draw(root);

        treeNode root1 = null;
        BST b = new BST();
        root1 = b.insert(root1,10);
        root1 = b.insert(root1,20);
        root1 = b.insert(root1,5);
        root1 = b.insert(root1,6);
        root1 = b.insert(root1,4);
        root1 = b.insert(root1,15);
        root1 = b.insert(root1,25);
        root1 = b.insert(root1,35);
        root1 = b.insert(root1,1);
        root1 = b.insert(root1,2);
        root1 = b.insert(root1,21);
        root1 = b.insert(root1,34);
        root1 = b.insert(root1,22);
        root1 = b.insert(root1,0);
        root1 = b.insert(root1,999);
        root1 = b.insert(root1,11);
        root1 = b.insert(root1,3);

        root1 = b.deleteNode(root1, 20);
        b.draw(root1);
    }
}