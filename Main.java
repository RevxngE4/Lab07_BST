public class Main {
    public static void main(String[] args) {
        Node f = new Node(1, null, null);
        Node g = new Node(4, null, null);
        Node h = new Node(7, null, null);
        Node i = new Node(3, null, null);
        Node d = new Node(14, i, null);
        Node e = new Node(6, g, h);
        Node c = new Node(10, null, d);
        Node b = new Node(3, f, e);
        Node a = new Node(8, b, c);


        BinarySearchTree tree = new BinarySearchTree(a);
        System.out.println("El que quieras = " + tree.getNumberOfNodes(f));
        System.out.println("todo = " + tree.numberOfNodes());
        System.out.println("Altura = " + tree.getDepth(a));
        System.out.println("es BST?  = " + tree.isBST(a));
        System.out.println("Por busqueda = " + tree.search(a,6));
        System.out.println("El mas pequeno = " + tree.getMin(a));
        System.out.println("El mas pequeno = " + tree.getMax(a) );
        tree.delete(1);
        System.out.println("se elimina la primera key F"  );
        tree.insert(5);
        System.out.println("se inserto una nueva key F");
        System.out.println("El que quieres otra vez = " + tree.getNumberOfNodes(f));

        BinarySearchTree treeFromFile = new BinarySearchTree();
        treeFromFile.readFromFile("src\\input.txt");
        System.out.println("cantidad de versinas = " + treeFromFile.numberOfNodes());
        int depth = treeFromFile.getDepth(treeFromFile.getRoot());
        System.out.println("Profundidad del árbol: " + depth);
        System.out.println("Es bts? = " + treeFromFile.isBST(treeFromFile.getRoot()));
        BinarySearchTree treeFromFile2 = new BinarySearchTree();
        treeFromFile2.readFromFile("src\\input2.txt");
        int[] keysToDelete = {4, 6, 3};
        treeFromFile2.deleteNodesWithKeys(keysToDelete);





    }
}