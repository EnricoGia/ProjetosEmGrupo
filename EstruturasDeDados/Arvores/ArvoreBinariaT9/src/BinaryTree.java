
public class BinaryTree {
    BinaryTreeNode root;
    int size;

    public BinaryTree() {

        this.root = null;
        this.size = 0;
    }

    public void insert_root(int valor) {

        BinaryTreeNode node = new BinaryTreeNode(valor);
        this.root = node;
        this.size = 1;
    }

    public BinaryTreeNode ret_Root() {
        return (this.root);
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        if (this.size == 0)
            return true;
        else
            return false;
    }

    public int verificaTamanho(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + verificaTamanho(root.left) + verificaTamanho(root.right);
    }

    

}
