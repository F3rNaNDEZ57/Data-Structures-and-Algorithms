
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    // this is the tree node class and this is the structure of the binary tree node
    private class treeNode {
        private int data;
        private treeNode left;
        private treeNode right;

        public treeNode(int data) {
            this.data = data;
        }
    }

    // this is the root of the binary tree
    private treeNode root;

    // this is the method to insert the data into the binary tree
    public void createBinaryTree(){
        treeNode first = new treeNode(1);
        treeNode second = new treeNode(2);
        treeNode third = new treeNode(3);
        treeNode fourth = new treeNode(4);
        treeNode fifth = new treeNode(5);

        root = first; // root --> first
        first.left = second;
        first.right = third; // second <-- first --> third
        second.left = fourth;
        second.right = fifth; // fourth <-- second --> fifth
    }

    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}