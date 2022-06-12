public class BinarySearchTree {
    BinarySearchTreeNode root;
    Integer size;

    public void insert_root(BinarySearchTreeNode node) {

        BinarySearchTreeNode newNode = new BinarySearchTreeNode(node.key);
        this.root = newNode;
        this.size = 1;
    }
    
    public void addNode(Integer chave) {
        BinarySearchTreeNode newNode = new BinarySearchTreeNode(chave);
        if (root == null)
            this.insert_root(newNode);
        else {
            BinarySearchTreeNode NodeTrab = this.root;
            while (true) {
                if(chave == null){
                    NodeTrab = NodeTrab.right;
                }
                else 
                if (chave < NodeTrab.key) {
                    if (NodeTrab.left == null) {
                        NodeTrab.left = newNode;
                        newNode.parent = NodeTrab;

                        return;
                    } else
                        NodeTrab = NodeTrab.left;
                } else {
                    if (NodeTrab.right == null) {
                        NodeTrab.right = newNode;
                        newNode.parent = NodeTrab;

                        return;
                    } else
                        NodeTrab = NodeTrab.right;
                }
            }
        }
    }

    public BinarySearchTreeNode search_key(Integer key) {
        BinarySearchTreeNode nodeTrab = this.root; // inicia pela raiz
        while (nodeTrab != null && nodeTrab.key != key) {
            if (key < nodeTrab.key)
                nodeTrab = nodeTrab.left;
            else
                nodeTrab = nodeTrab.right;
        }
        return nodeTrab;
    }

    
    public BinarySearchTreeNode ret_Root() {
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

    public static Integer verificaTamanho(BinarySearchTreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + verificaTamanho(root.left) + verificaTamanho(root.right);
    }

    public static Integer findMax(BinarySearchTreeNode node) {
        if (node == null)
            return Integer.MIN_VALUE;

        Integer res = node.key;
        Integer lres = findMax(node.left);
        Integer rres = findMax(node.right);
        if (res == null)
            res = Integer.MIN_VALUE;
        if (lres > res)
            res = lres;
        if (rres > res)
            res = rres;
        return res;
    }

    public static Integer findMin(BinarySearchTreeNode node) {
        if (node == null)
            return Integer.MAX_VALUE;

        Integer res = node.key;
        Integer lres = findMin(node.left);
        Integer rres = findMin(node.right);
        if (res == null)
            res = Integer.MAX_VALUE;
        if (lres < res)
            res = lres;
        if (rres < res)
            res = rres;
        return res;
    }

    public static float soma = 0;

    public static double findAvg(BinarySearchTreeNode node) {
        if (node == null)
            return Integer.MAX_VALUE;
        Integer res = node.key;

        double lres = findAvg(node.left);
        double rres = findAvg(node.right);

        if (res == null)
            res = 0;
        if (lres < res)
            res = (int) lres;
        if (rres < res)
            res = (int) rres;
        soma += res;
        return (double) soma / (double) (verificaTamanho(node));
    }

    public static Integer somaNull = 0;

    public static Integer findNull(BinarySearchTreeNode node) {
        if (node == null)
            return Integer.MAX_VALUE;

        Integer res = node.key;
        Integer lres = findNull(node.left);
        Integer rres = findNull(node.right);

        if (res == null) {
            res = lres;
            somaNull += 1;

        }
        if (rres == null) {
            res = rres;
            somaNull += 1;
        }

        return somaNull;
    }

    static Integer findLeaves(BinarySearchTreeNode node) {
        if (node == null)
            return 0;
        if (node.left == null && node.right == null)
            return 1;
        else
            return findLeaves(node.left) + findLeaves(node.right);
    }

    public Integer findHeight(BinarySearchTreeNode node) {

        if (root == null) {
            System.out.println("Arvore vazia");
            return 0;
        } else {
            Integer leftHeight = -1, rightHeight = -1;

            if (node.left != null)
                leftHeight = findHeight(node.left);

            if (node.right != null)
                rightHeight = findHeight(node.right);

            Integer max = (leftHeight > rightHeight) ? leftHeight : rightHeight;

            return (max + 1);
        }
    }
}
