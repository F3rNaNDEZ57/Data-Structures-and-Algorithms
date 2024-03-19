//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class treeNode {
    int data;
    treeNode left;
    treeNode right;
}

class BST {
    public treeNode createNewNode(int data){
        treeNode a = new treeNode();
        a.data = data;
        a.left = null;
        a.right = null;
        return a;
    }
    public treeNode insert(treeNode root, int data){
        if(root == null){
            return createNewNode(data);
        }

        if(data < root.data){
            root.left = insert(root.left, data);
        }
        else if(data > root.data){
            root.right = insert(root.right, data);
        }

        return root;
    }
}


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        BST a = new BST();
        treeNode root = null;

        root = a.insert(root, 10);
        root = a.insert(root, 20);
        root = a.insert(root, 5);
        root = a.insert(root, 6);
        root = a.insert(root, 15);
        root = a.insert(root, 25);
        root = a.insert(root, 8);
        root = a.insert(root, 7);
        root = a.insert(root, 26);
        root = a.insert(root,10);

    }
}