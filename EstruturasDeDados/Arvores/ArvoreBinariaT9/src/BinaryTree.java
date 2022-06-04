
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

    public static int verificaTamanho(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + verificaTamanho(root.left) + verificaTamanho(root.right);
    }

    public static int findMax(BinaryTreeNode node) {
        if (node == null)
            return Integer.MIN_VALUE;
 
        int res = node.item;
        int lres = findMax(node.left);
        int rres = findMax(node.right);
 
        if (lres > res)
            res = lres;
        if (rres > res)
            res = rres;
        return res;
    }

    public static int findMin(BinaryTreeNode node) {
    if (node == null)
        return Integer.MAX_VALUE;
 
    int res = node.item;
    int lres = findMin(node.left);
    int rres = findMin(node.right);
 
    if (lres < res)
        res = lres;
    if (rres < res)
        res = rres;
    return res;
    }

    public static float soma = 0;
    public static double findAvg(BinaryTreeNode node) {
        if (node == null)
            return Integer.MAX_VALUE;
     
        double res = node.item;
        double lres = findAvg(node.left);
        double rres = findAvg(node.right);
     
        if (lres < res)
            res = lres;
        if (rres < res)
            res = rres;
        soma += res;
        return soma / (double)(verificaTamanho(node));
        }

}
