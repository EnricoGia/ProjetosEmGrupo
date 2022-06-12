public class App {
    public static void main(String[] args) throws Exception {

        BinarySearchTree tree = new BinarySearchTree();

        Integer[] arrayArvore = { 3, 7, 8, 9, 10, 5 };
        for (Integer valor : arrayArvore) {
            tree.addNode(valor);
        }

        Integer k = 72;
        tree.addNode(k);
        System.out.println("-- Travesias -- ");
        System.out.println("PreOrder");
        tree.root.binarySearchPreorder();
        System.out.println("PostOrder");
        tree.root.binarySearchPostorder();
        System.out.println("InOrder");
        tree.root.binarySearchInorder();

        Integer valorSecreto = 42;
        tree.root.presente(valorSecreto);

        tree.root.presente(k);

        int minimo, tamanho, altura;
        double media;

        minimo = BinarySearchTree.findMin(tree.root);
        System.out.println("Achando minimo: " + minimo);

        tamanho = BinarySearchTree.verificaTamanho(tree.root);
        System.out.println("Achando tamanho: " + tamanho);

        media = BinarySearchTree.findAvg(tree.root);
        System.out.println("Achando media: " + media);

        altura = tree.findHeight(tree.search_key(5));
        System.out.println("Achando altura: " + altura);

        System.out.println("Multiplos de 2");

        tree.root.findMultiples();

        System.out.println("soma = " + tree.root.findSum());

        

        // acha o numero de chaves null da árvore
        int numeroNulls = BinarySearchTree.findNull(tree.root);
        System.out.println("numero de nulls = " + numeroNulls);
    }
}
