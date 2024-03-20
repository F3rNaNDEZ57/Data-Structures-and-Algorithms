import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

class treeNode {
    int data;
    treeNode left;
    treeNode right;
}

class BST {
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


    public treeNode deleteNode(treeNode root, int data){
        if (root == null){
            return null;
        }

        if (data < root.data){
            root.left = deleteNode(root.left, data);
        } else if (data > root.data) {
            root.right = deleteNode(root.right, data);
        }else {

            if (root.left == null){
                return root.right;
            }else if (root.right == null){
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


    public treeNode searchNode(treeNode root, int data){
        if (root == null || root.data == data){
            return root;
        }

        if (data < root.data){
            return searchNode(root.left, data);
        }else {
            return searchNode(root.right, data);
        }
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
            inOrderTraversal(root.left);
            inOrderTraversal(root.right);
        }
    }

    public void postOrderTraversal(treeNode root){
        if (root != null){
            inOrderTraversal(root.left);
            inOrderTraversal(root.right);
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


    // CHECK RELATIVITY OF GIVEN TWO OR MORE NODES AND IF THEY ARE RELATED RETURN THE ANCESTORS
    private boolean findPath(treeNode root,ArrayList<Integer> path,int k){
        // base case
        if (root == null){
            return false;
        }

        // add the node to the path because it is part of the path
        path.add(root.data);

        // if the node is same as the k then return true
        if (root.data == k){
            return true;
        }

        // if the node is not same as the k then check the left and right subtree
        if (findPath(root.left, path, k) || findPath(root.right, path, k)){
            return true;
        }

        // if the node is not part of the path then remove it from the path
        path.removeLast();
        return false;
    }

    public List<Integer> findLCA(treeNode root, int n1, int n2){
        // to store paths to n1 and n2 from the root
        ArrayList<Integer> path1 = new ArrayList<>();
        ArrayList<Integer> path2 = new ArrayList<>();

        // if the paths are not found then return null
        if (!findPath(root, path1, n1) || !findPath(root, path2, n2)){
            return null;
        }

        // if the paths are found then return the common ancestor
        int i;
        for (i = 0; i < path1.size() && i < path2.size(); i++){
            if (!path1.get(i).equals(path2.get(i))){// if the nodes are not same then break
                break;
            }
        }

        return path1.subList(0, i);
    }


    //DRAWING
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


        System.out.println("In Order Traversal -:");
        a.inOrderTraversal(root);
        System.out.println();
        System.out.println("Pre Order Traversal -:");
        a.preOrderTraversal(root);
        System.out.println();
        System.out.println("Post Order Traversal -:");
        a.postOrderTraversal(root);
        System.out.println();
        System.out.println("In Order Traversal Descending -:");
        a.inOrderTraversalDescending(root);


        List<Integer> lca = a.findLCA(root, 34, 999);
        System.out.println("\nCommon Ancestors" + lca);
        System.out.println("Lowest Common Ancestor -:"+lca.getLast());




//        System.out.println();
//        root = a.searchNode(root,22);
//        if (root != null){
//            System.out.println("NODE that have value "+ root.data +" is FOUND!!");
//        }else {
//            System.out.println("NODE is NOTFOUND!!");
//        }
//
//        root = a.searchNode(root,121);
//        if (root != null){
//            System.out.println("NODE that have value "+ root.data +" is FOUND!!");
//        }else {
//            System.out.println("NODE is NOTFOUND!!");
//        }
//
//
//        // this is the tree that we use to so any changes
//        treeNode root1 = null;
//        BST b = new BST();
//        root1 = b.insert(root1,10);
//        root1 = b.insert(root1,20);
//        root1 = b.insert(root1,5);
//        root1 = b.insert(root1,6);
//        root1 = b.insert(root1,4);
//        root1 = b.insert(root1,15);
//        root1 = b.insert(root1,25);
//        root1 = b.insert(root1,35);
//        root1 = b.insert(root1,1);
//        root1 = b.insert(root1,2);
//        root1 = b.insert(root1,21);
//        root1 = b.insert(root1,34);
//        root1 = b.insert(root1,22);
//        root1 = b.insert(root1,0);
//        root1 = b.insert(root1,999);
//        root1 = b.insert(root1,11);
//        root1 = b.insert(root1,3);
//
//        root1 = b.deleteNode(root1, 20);
//        root1 = b.deleteNode(root1, 5);
//        b.draw(root1);
    }
}