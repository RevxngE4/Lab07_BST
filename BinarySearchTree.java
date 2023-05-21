import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BinarySearchTree {
    private Node root;

    public BinarySearchTree(){
      root = null;
    }
    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }
    public BinarySearchTree(Node root){
        this.root = root;
    }
    public int numberOfNodes(){
        return getNumberOfNodes(root);
    }
    //a
    public int getNumberOfNodes(Node node){
      if (node == null) {
          return 0;
      }else {
          return 1 + getNumberOfNodes(node.getLeft()) + getNumberOfNodes(node.getRight());
      }
    }
    //b
    public int getDepth(Node node){
        if (node == null){
            return 0;
        }else {
            int leftHeight =  getDepth(node.getLeft());
            int rightHeight = getDepth(node.getRight());
            return Math.max(leftHeight,rightHeight) + 1;

        }

    }
    //c
    public boolean isBST(Node node){
        return isBST(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBST(Node node, int minValue, int maxValue) {
        if (node == null){
            return true;
        }
        if ((node.getKey() <= minValue) || (node.getKey() >= maxValue )){
            return false;
        }
        return isBST(node.getLeft(), minValue, node.getKey()) && isBST(node.getRight(), node.getKey(), maxValue);

    }
    //d
    public Node search(Node node, int key){
        if (node == null || node.getKey() == key){
            return node;
        }
        if (node.getKey() < key){
            return search(node.getRight(),key);
        }
        return search(node.getLeft(), key);
    }
    //f
    public Node getMin(Node node){
        while (node.getLeft() != null)
            node = node.getLeft();
        return node;
    }
    //g
    public Node getMax(Node node){
        while (node.getRight() != null)
            node = node.getRight();
        return node;
    }
    //h
    public void delete(int key) {
        root = deleteNode(root, key);
    }

    private Node deleteNode(Node node, int key) {
        if (node == null)
            return null;

        if (key < node.getKey()) {
            node.setLeft(deleteNode(node.getLeft(), key));
        } else if (key > node.getKey()) {
            node.setRight(deleteNode(node.getRight(), key));
        } else {

            if (node.getLeft() == null)
                return node.getRight();
            else if (node.getRight() == null)
                return node.getLeft();

            Node successor = getMin(node.getRight());

            node.setKey(successor.getKey());

            node.setRight(deleteNode(node.getRight(), successor.getKey()));
        }

        return node;
    }


    //i
    public void insert(int key) {
        root = insertNode(root, key);
    }
    private Node insertNode(Node node, int key) {
        if (node == null)
            return new Node(key);

        if (key < node.getKey())
            node.setLeft(insertNode(node.getLeft(), key));
        else if (key > node.getKey())
            node.setRight(insertNode(node.getRight(), key));

        return node;
    }



    //j
    public void readFromFile(String path){
      try(Scanner scanner = new Scanner(new File(path))){
          int n = scanner.nextInt();
          Node [] nodes = new Node[n];
          for (int i = 0; i < n; i++) {
              nodes[i] = new Node();
          }
          for (int i = 0; i < n  ; i++) {
              nodes[i].setKey(scanner.nextInt());
              int left = scanner.nextInt();
              int right = scanner.nextInt();
              if (left != 0){
                  nodes[i].setLeft(nodes[left - 1]);
                  nodes[left - 1].setParent(nodes[i]);
              }
              if (right != 0){
                  nodes [i].setRight(nodes[right -1]);
                  nodes [right -1].setParent(nodes[i]);
              }
          }
          root = nodes [0];
      }catch (FileNotFoundException e){
          throw new RuntimeException(e);
      }
    }
    public void deleteNodesWithKeys(int[] keys) {
        for (int key : keys) {
            deleteNodeWithKey(root, key);
            System.out.println("Número de vértices restantes después de eliminar la clave " + key + ": " + numberOfNodes());
        }
    }

    private Node deleteNodeWithKey(Node node, int key) {
        if (node == null)
            return null;

        if (key < node.getKey()) {
            node.setLeft(deleteNodeWithKey(node.getLeft(), key));
        } else if (key > node.getKey()) {
            node.setRight(deleteNodeWithKey(node.getRight(), key));
        } else {
            if (node.getLeft() == null)
                return node.getRight();
            else if (node.getRight() == null)
                return node.getLeft();

            Node successor = getMin(node.getRight());

            node.setKey(successor.getKey());

            node.setRight(deleteNodeWithKey(node.getRight(), successor.getKey()));
        }

        return node;
    }


}
