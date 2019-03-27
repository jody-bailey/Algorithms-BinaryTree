package com.jodybailey;

public class Tree {

    private Node root;

    public Tree() {
        this.root = null;
    }

    public Tree(Node root) {
        this.root = root;
    }

    Tree(int[] values) {
        for (int value: values) {
            addNode(new Node(value));
        }
    }

    Node getRoot() {
        return root;
    }

    void setRoot(Node root) {
        this.root = root;
    }

    // Method to add a new node to the tree.
    // If the tree is currently empty then the first node passed in
    // will become the root node. Every subsequent node to be passed in
    // will be checked to see if its value is greater than or less than
    // the root and every other sub-tree that it encounters until its
    // place in the tree is found. If a duplicate value is passed in,
    // that node will be discarded because I do not allow duplicates in
    // the tree.
    public void addNode(Node node) {

        if (this.root == null) {
            this.root = node;
            return;
        }
        Node current = this.root;

        while (current != null) {
            if(node.getValue() < current.getValue()) {
                if (current.getLeft() == null) {
                    current.setLeft(node);
                    node.setParent(current);
                    break;
                } else {
                    current = current.getLeft();
                }
            } else if (node.getValue() > current.getValue()) {
                if (current.getRight() == null) {
                    current.setRight(node);
                    node.setParent(current);
                    break;
                } else {
                    current = current.getRight();
                }
            } else {
                System.out.println(current.getValue() + " is a duplicate. Not adding.");
                break;
            }
        }
    }
}
