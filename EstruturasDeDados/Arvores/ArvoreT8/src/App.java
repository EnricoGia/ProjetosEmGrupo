

public class App {
    public static void main(String[] args) throws Exception {
        Tree tree = new Tree();
        tree.insert_root(5);
        Node_Tree no_0 = new Node_Tree(0);
        Node_Tree no_1 = new Node_Tree(1);
        Node_Tree no_2 = new Node_Tree(2);
        Node_Tree no_3 = new Node_Tree(3);
        Node_Tree no_4 = new Node_Tree(4);
        Node_Tree no_6 = new Node_Tree(6);
        Node_Tree no_7 = new Node_Tree(7);
        Node_Tree no_8 = new Node_Tree(8);
        Node_Tree no_12 = new Node_Tree(12);
        Node_Tree no_21 = new Node_Tree(21);

        tree.root.firstChild = no_4;

        no_4.parent = tree.root;
        no_3.parent = tree.root;
        no_7.parent = tree.root;

        no_4.next = no_3;
        no_3.next = no_7;
        
        no_4.firstChild = no_1;

        no_1.next = no_2;

        no_1.parent = no_4;
        no_2.parent = no_4;

        no_3.firstChild = no_8;

        no_8.parent = no_3;

        no_7.firstChild = no_0;
        no_0.next = no_6;

        no_0.parent = no_7;
        no_6.parent = no_7;
        
        no_8.firstChild = no_21;
        
        no_21.next = no_12;
        
        no_21.parent = no_8;
        no_12.parent = no_8;
        
        tree.root.preorder();
        System.out.println("\n\n");
        tree.root.posorder();
        System.out.println ("");    
        
        System.out.println(tree.root.EhInterno());
        System.out.println(no_8.EhInterno());

        no_8.DobraFilhos();
        no_8.imprimeFilhos();

        no_2.DobraPai();
        no_2.imprime_Parent();
    }
}
