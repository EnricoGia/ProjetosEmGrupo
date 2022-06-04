import java.util.Objects;

public class BinaryTree {
    BinaryTreeNode root;
    Integer size;
    
    public void insert_root(Integer valor) {

        BinaryTreeNode node = new BinaryTreeNode(valor);
        this.root = node;
        this.size = 1;
    }

    public BinaryTreeNode ret_Root() {
        return (this.root);
    }

    public Integer size() {
        return this.size;
    }

    public boolean isEmpty() {
        if (this.size == 0)
            return true;
        else
            return false;
    }

    public static Integer verificaTamanho(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + verificaTamanho(root.left) + verificaTamanho(root.right);
    }

    public static Integer findMax(BinaryTreeNode node) {
        if (node == null)
            return Integer.MIN_VALUE;
 
        Integer res = node.item;
        Integer lres = findMax(node.left);
        Integer rres = findMax(node.right);
        if(res == null)
            res = Integer.MIN_VALUE;
        if (lres > res)
            res = lres;
        if (rres > res)
            res = rres;
        return res;
    }

    public static Integer findMin(BinaryTreeNode node) {
    if (node == null)
        return Integer.MAX_VALUE;
 
    Integer res = node.item;
    Integer lres = findMin(node.left);
    Integer rres = findMin(node.right);
    if(res == null)
        res = Integer.MAX_VALUE;
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
        Integer res = node.item;

        double lres = findAvg(node.left);
        double rres = findAvg(node.right);
        
        if(res == null)
            res = 0;
        if (lres < res)
            res = (int) lres;
        if (rres < res)
            res = (int) rres;
        soma += res;
        return (double)soma / (double)(verificaTamanho(node));
        }

    public static Integer somaNull = 0;
    public static Integer findNull(BinaryTreeNode node) {
        if (node == null)
            return Integer.MAX_VALUE;
     
        Integer res = node.item;
        Integer lres = findNull(node.left);
        Integer rres = findNull(node.right);
     
        if (res == null){
            res = lres;
            somaNull += 1;
            
        }
        if (rres == null){
            res = rres;
            somaNull += 1;
        }
        
        return somaNull;
    }
    static int findLeaves(BinaryTreeNode node)
    {
        if (node == null)
            return 0;
        if (node.left == null && node.right == null)
            return 1;
        else
            return findLeaves(node.left) + findLeaves(node.right);
    }
    public int findHeight(BinaryTreeNode node){  

        if(root == null) {  
             System.out.println("Arvore vazia");  
            return 0;  
        }  
        else {  
            int leftHeight = 0, rightHeight = 0;  
  
            if(node.left != null)  
                leftHeight = findHeight(node.left);  
  
            if(node.right != null)  
                rightHeight = findHeight(node.right);  
  
           
            int max = (leftHeight > rightHeight) ? leftHeight : rightHeight;  
  
            return (max + 1);  
        }  
     }  
}
