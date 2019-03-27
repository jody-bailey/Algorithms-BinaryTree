package com.jodybailey;

public class Node {

    private Node left;
    private Node right;
    private Node parent;
    private int value;

    Node getLeft() {
        return left;
    }

    void setLeft(Node left) {
        this.left = left;
    }

    Node getRight() {
        return right;
    }

    void setRight(Node right) {
        this.right = right;
    }

    void setParent(Node parent) {
        this.parent = parent;
    }

    Node getParent() {
        return this.parent;
    }

    int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    Node(int value) {
        this.left = null;
        this.right = null;
        this.value = value;
    }

    public Node(Node left, Node right, int value) {
        this.left = left;
        this.right = right;
        this.value = value;
    }
}
