public class App {
    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();
        tree.insert_root(0);

        BinaryTreeNode no_1 = new BinaryTreeNode(1);
        BinaryTreeNode no_2 = new BinaryTreeNode(2);
        BinaryTreeNode no_3 = new BinaryTreeNode(3);
        BinaryTreeNode no_4 = new BinaryTreeNode(4);
        BinaryTreeNode no_5 = new BinaryTreeNode(5);
        BinaryTreeNode no_6 = new BinaryTreeNode(6);

        tree.root.left = no_1;
        tree.root.right = no_2;
        no_2.left = no_3;
        no_2.right = no_4;
        no_3.left = no_5;
        no_3.right = no_6;

        System.out.println("PreOrder");
        tree.root.binaryPreorder();
        System.out.println("PostOrder");
        tree.root.binaryPostorder();
        System.out.println("InOrder");
        tree.root.binaryInorder();

        System.out.println("Valor 5 na arvore?");
        tree.root.presente(4);
        
        System.out.println(tree.verificaTamanho(tree.root));
        
        


    }
}