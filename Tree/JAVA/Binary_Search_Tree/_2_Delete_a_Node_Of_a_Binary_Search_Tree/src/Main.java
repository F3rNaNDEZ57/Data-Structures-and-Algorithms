
class treeNode {
    int data;
    treeNode left;
    treeNode right;
}

class BST {
    public treeNode createNewNode(int k) {
        treeNode a = new treeNode();
        a.data = k;
        a.left = null;
        a.right = null;
        return a;
    }

    public treeNode insert(treeNode root, int data) {
        if( root == null) {
          return createNewNode(data);
        }

        if(data < root.data){
            root = insert(root.left,data);
        }
    }

}
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}