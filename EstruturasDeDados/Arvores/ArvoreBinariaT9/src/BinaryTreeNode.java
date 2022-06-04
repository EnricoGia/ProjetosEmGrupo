public class BinaryTreeNode {

    Integer item;
    BinaryTreeNode parent;
    BinaryTreeNode left;
    BinaryTreeNode right;
    public BinaryTreeNode(){
        this.item = null;
        this.parent = null;
        this.left = null;
        this.right = null;
    }
    public BinaryTreeNode(Integer item) {

        this.item = item;
        this.parent = null;
        this.left = null;
        this.right = null;

    }

    public BinaryTreeNode left() {
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

    public BinaryTreeNode right() {
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

    public void binaryPreorder() {

        System.out.println(this.item);
        if (this.isLeft())
            this.left.binaryPreorder();
        if (this.isRight())
            this.right.binaryPreorder();
    }

    public void binaryPostorder() {

        if (this.isLeft())
            this.left.binaryPostorder();
        if (this.isRight())
            this.right.binaryPostorder();
        System.out.println(this.item);

    }

    public void binaryInorder() {

        if (this.isLeft())
            this.left.binaryInorder();
        System.out.println(this.item);
        if (this.isRight())
            this.right.binaryInorder();
    }

    public void presente(Integer valor) {
        if(this.item==valor)
            System.out.println("Valor achado! ("+valor+")");

        if (this.isLeft()){
            this.left().presente(valor);
        }
        
        if (this.isRight()){
            this.right().presente(valor);
        }


        
    }
    
}