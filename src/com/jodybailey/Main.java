/*
* Jody Bailey
* CSC 413 - Algorithms
* 03/27/2019
* The purpose of this program is to demonstrate various operations used on binary search trees.
* */

package com.jodybailey;
public class Main {

	private static TreeTraversals traversals = new TreeTraversals();

	public static void main(String[] args) {
		// Values to be used for creating the binary tree
		int[] values = {15, 6, 18, 17, 20, 3, 7, 2, 4, 13, 9};

		Tree tree = new Tree(values);

		// This was the original way that I added values to the tree
		// and found it quite redundant so I switched to passing
		// in an array as seen above.
//	    Tree tree = new Tree(new Node(10));
//	    tree.addNode(new Node(5));
//	    tree.addNode(new Node(3));
//	    tree.addNode(new Node(7));
//	    tree.addNode(new Node(9));
//	    tree.addNode(new Node(12));
//	    tree.addNode(new Node(17));
//	    tree.addNode(new Node(11));
//	    tree.addNode(new Node(10));

		// Showing the output from running the in-order traversal
		System.out.println("In-order traversal of initial binary tree: " + traversals.inOrderTraversal(tree.getRoot()));

		// Showing the output from searching for a particular node
		// This can produce a null pointer exception and I would catch it if
		// this program accepted user input. Since it is hardcoded, I will
		// leave as is
		System.out.println("Searching for key 9 returns: " + traversals.treeSearch(tree.getRoot(), 9).getValue());

		// Showing the output from running the findMax() method
		System.out.println("Max value: " + traversals.findMax(tree.getRoot()).getValue());

		// Showing the output from running the findMin() method
		System.out.println("Min value: " + traversals.findMin(tree.getRoot()).getValue());

		// Showing the output from several calls to the findSuccessor() method.
		// My reason for making several calls was to make sure it would work
		// no matter what position the node was in, in the tree.
		System.out.println("Successor of 6 is: " + traversals.findSuccessor(traversals.treeSearch(tree.getRoot(), 6)).getValue());
		System.out.println("Successor of 9 is: " + traversals.findSuccessor(traversals.treeSearch(tree.getRoot(), 9)).getValue());
		System.out.println("Successor of 13 is: " + traversals.findSuccessor(traversals.treeSearch(tree.getRoot(), 13)).getValue());

		// Showing the tree after deleting a node
		// This can produce a null pointer exception and I would catch it if
		// this program accepted user input. Since it is hardcoded, I will
		// leave as is
		traversals.deleteNode(tree, traversals.treeSearch(tree.getRoot(), 9));

		// Must clear the ArrayList before running the next in-order traversal.
		traversals.clearValues();

		// Showing the binary tree once again to make it clear that a
		// node was deleted.
		System.out.println("In-order traversal after deleting 9: " + traversals.inOrderTraversal(tree.getRoot()));

		// Showing the addition of a new node.
		tree.addNode(new Node(12));

		// Clear the ArrayList once again
		traversals.clearValues();

		// Show the tree after adding a node with the value of 12
		System.out.println("In-order traversal after adding 12: " + traversals.inOrderTraversal(tree.getRoot()));
	}
}
