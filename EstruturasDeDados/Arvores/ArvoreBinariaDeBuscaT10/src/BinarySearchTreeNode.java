public class BinarySearchTreeNode {

    Integer key;
    BinarySearchTreeNode parent;
    BinarySearchTreeNode left;
    BinarySearchTreeNode right;
    public BinarySearchTreeNode(){
        this.key = null;
        this.parent = null;
        this.left = null;
        this.right = null;
    }
    public BinarySearchTreeNode(Integer key) {

        this.key = key;
        this.parent = null;
        this.left = null;
        this.right = null;

    }

    public BinarySearchTreeNode left() {
        if (this.left == null)
            return null;
        else
            return this.left;
    }

    public boolean isLeft() {
        if (this.left == null)
            return false;
        else
            return true;
    }

    public BinarySearchTreeNode right() {
        if (this.right == null)
            return null;
        else
            return this.right;
    }

    public boolean isRight() {
        if (this.right == null)
            return false;
        else
            return true;
    }

    public void binarySearchPreorder() {

        System.out.println(this.key);
        if (this.isLeft())
            this.left.binarySearchPreorder();
        if (this.isRight())
            this.right.binarySearchPreorder();
    }

    public void binarySearchPostorder() {

        if (this.isLeft())
            this.left.binarySearchPostorder();
        if (this.isRight())
            this.right.binarySearchPostorder();
        System.out.println(this.key);

    }

    public void findMultiples() {

        if (this.isLeft())
            this.left.findMultiples();
        if (this.isRight())
            this.right.findMultiples();
        if(key % 2 == 0)
            System.out.println(key + " eh multiplo de 2");

    }

    public static Integer soma = 0;
    public Integer findSum() {

        if (this.isLeft())
            this.left.findSum();
        if (this.isRight())
            this.right.findSum();
        soma += this.key;
        
        return soma;
    }

    public void binarySearchInorder() {

        if (this.isLeft())
            this.left.binarySearchInorder();
        System.out.println(this.key);
        if (this.isRight())
            this.right.binarySearchInorder();
    }

    public void presente(Integer valor) {
        if(this.key==valor)
            System.out.println("Valor achado! ("+valor+")");
        else
            System.out.println("valor nao achado, tentando novamente..." + "(" + valor + ")");
        if (this.isLeft()){
            this.left().presente(valor);
        }
        
        if (this.isRight()){
            this.right().presente(valor);
        }
    }
        
}