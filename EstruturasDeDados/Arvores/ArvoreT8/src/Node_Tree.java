public class Node_Tree {
    Integer item;
    Node_Tree parent;
    Node_Tree firstChild;
    Node_Tree next;

    public Node_Tree(Integer item) {
        this.item = item;
        this.parent = null;
        this.firstChild = null;
        this.next = null;
    }

    public Node_Tree parent() {
        if (this.parent == null)
            return null;
            else return (this.parent );
        }
        
    public void imprime_Parent() {
        if (this.parent != null)
            System.out.println("Pai: " + this.parent.item );
        else
            System.out.println("Este nó é root, não tem pai...");
        } 

    public void imprimeFilhos() {
        if (this.firstChild == null)
            System.out.println("Node nao tem filhos....");
        else {
            Node_Tree trab = this.firstChild;
            while (trab != null ) {
                System.out.println(trab.item);
                trab = trab.next;
            }
        }
    }

    public int dept() {
        if (this.parent == null)
            return 0;
        else return ( 1 + this.parent.dept() );
    }
    
    public int height() {
        if (this.firstChild == null )
            return 0;
        int h=0;
        Node_Tree trab = this.firstChild;
        while (trab.next != null ) {
            h = Math.max(h , trab.next.height());
            trab = trab.next;
        }
            return 1 + h;
        }

    public void preorder() {
        System.out.println(this.item );
        Node_Tree trab = this.firstChild;
        while (trab != null ) {
            trab.preorder();
            trab = trab.next;
        }
    }

    public void posorder() {
        Node_Tree trab = this.firstChild;
        while (trab != null ) {
            trab.posorder();
            trab = trab.next;
        }
        System.out.println(this.item );
    }

    public boolean EhInterno(){
        return (this.firstChild != null ? true : false);
    }

    public void DobraFilhos() {
        if (this.firstChild == null)
            System.out.println("Node nao tem filhos....");
        else {
            
            Node_Tree trab = this.firstChild;

            while (trab != null ) {
                trab.item *= 2;
                trab = trab.next;
            }
        }
    }

    public void DobraPai(){

        Node_Tree trab = this.parent();
        
        if(trab == null)
            System.out.println("Sem Pai");
        else
            trab.item *= 2;
        
    }
}