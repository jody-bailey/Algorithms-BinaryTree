package com.jodybailey;

import java.util.ArrayList;

class TreeTraversals {
    // ArrayList to store the values from the binary tree
    private ArrayList<Integer> values = new ArrayList<>();

    // Method to perform the in-order traversal of the binary tree.
    // This method uses recursion to first search all left nodes
    // of the tree and then move to the right side of the tree.
    // While finding the values in order, I'm storing the values
    // into the values ArrayList so that they can be displayed
    // easily from the main program.
    ArrayList<Integer> inOrderTraversal(Node node) {

        if (node != null) {
            inOrderTraversal(node.getLeft());
            this.values.add(node.getValue());
            inOrderTraversal(node.getRight());
        }
        return this.values;
    }

    // Method to search the tree for a node that has the key passed in.
    // Using recursion to narrow down where the node is that we are
    // looking for. Once the node is found that has the corresponding
    // value then that node is returned
    Node treeSearch(Node node, int key) {
        if (node == null || key == node.getValue()) {
            return node;
        }
        if (key < node.getValue()) {
            return treeSearch(node.getLeft(), key);
        } else {
            return treeSearch(node.getRight(), key);
        }
    }

    // Traverses the tree all the way to the left until it reaches
    // a node that does not have a left child. This node will be the
    // minimum value in the tree.
    Node findMin(Node node) {
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
    }

    // Traverses the tree all the way to the right until it reaches
    // a node that does not have a right child. This node will be the
    // maximum value in the tree
    Node findMax(Node node) {
        while (node.getRight() != null) {
            node = node.getRight();
        }
        return node;
    }

    // Method to find the successor of the node passed in.
    // This works by taking the right sub-tree of the node,
    // if not null, and find the smallest value in that
    // sub-tree. This node will be the successor. If the
    // node does not have a right sub-tree then it will travers back up
    // until it finds the nodes successor.
    Node findSuccessor(Node node) {
        if (node.getRight() != null) {
            return findMin(node.getRight());
        }
        Node newNode = node.getParent();
        while (newNode != null && node == newNode.getRight()) {
            node = newNode;
            newNode = newNode.getParent();
        }
        return newNode;
    }

    // Method to swap a node with a replacement node.
    private void transplant(Tree tree, Node node, Node replacement) {
        if (node.getParent() == null) {
            tree.setRoot(replacement);
        } else if (node == node.getParent().getLeft()) {
            node.getParent().setLeft(replacement);
        } else node.getParent().setRight(replacement);

        if (replacement != null) {
            replacement.setParent(node.getParent());
        }
    }

    // Method to delete a node from the binary tree.
    // I check to see if either the right or left child is null
    // and if one of them are then I swap the node with the child
    // so that it can be removed. If the node has two children,
    // I check for the smallest value in the right sub-tree to
    // replace the current node so that it can be deleted.
    void deleteNode(Tree tree, Node node) {
        if (node.getLeft() == null) {
            transplant(tree, node, node.getRight());
        } else if (node.getRight() == null) {
            transplant(tree, node, node.getLeft());
        } else {
            Node newNode = findMin(node.getRight());
            if (newNode.getParent() != node) {
                transplant(tree, newNode, newNode.getRight());
                newNode.setRight(node.getRight());
                newNode.getRight().setParent(newNode);
            }
            transplant(tree, node, newNode);
            newNode.setLeft(node.getLeft());
            newNode.getLeft().setParent(newNode);
        }
    }

    // Clear the values in the values ArrayList so get ready for new values.
    void clearValues() {
        this.values.clear();
    }
}
