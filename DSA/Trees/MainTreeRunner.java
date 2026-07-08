package Trees;

public class MainTreeRunner {
    public static void main(String[] args){
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insert(23);
        binaryTree.insert(12);
        binaryTree.insert(4);
        binaryTree.insert(5);
        binaryTree.insert(67);
        binaryTree.insert(20);
        binaryTree.inorder();
    }
}
