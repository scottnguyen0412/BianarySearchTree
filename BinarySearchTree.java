package Week4.java;

import java.util.LinkedList;
import java.util.Queue;

class Node
	{
		int data; 		//store data 
		Node left; 		//pointer point to left sub-tree
		Node right;		//pointer point to right sub-tree
		Node()			//contructor
		{
			
		}
		Node (int x) 	//create a node with data x
		{
			data =x;
			left = right = null; //left and right Sub-tree are empty
		}
	}
public class BinarySearchTree {
	static Node root;  		//declare a root of tree
	BinarySearchTree()
	{
		root = null;	//create an empty tree
	}
	Node Insert(int x, Node Tr) // Insert x into tree Tr
	{
		if(Tr ==null)
		{
			Tr = new Node(x); 	//x is the root of Tr
		}
		else
		{
			if(x <Tr.data) //x<root then insert x into the left sub-tree
			{
				Tr.left = Insert(x, Tr.left); //call the insert function recursively
			}
			else
			{
				if(x> Tr.data) //x > root then insert x into the right sub-tree
				{
					Tr.right = Insert(x,Tr.right);
				}
				else
				{
					System.out.printf("%d is existed on the tree!! ", x);
				}
				
			}
		}
		return Tr;
	}
	void CreateTree() //method insert data for tree
	{
		root = Insert(8, root);
		root = Insert(6, root);
		root = Insert(10, root);
		root = Insert(5, root);
		root = Insert(7, root);
		root = Insert(9, root);
		root = Insert(11, root);
		root = Insert(12, root);
		
	}
	void PreOrder(Node Tr)  //Root, Left, Right
	{
		if (Tr!= null)
		{
			System.out.print(Tr.data+ " "); 
			PreOrder(Tr.left);
			PreOrder(Tr.right);
		}
	}
	void InOrder(Node Tr)	//Left, Root, Right
	{
		if(Tr != null)
		{
			InOrder(Tr.left);
			System.out.print(Tr.data+ " ");
			InOrder(Tr.right);
		}
	}
	void PostOrder(Node Tr) //Left, Right, Root
	{
		if(Tr != null)
		{
			PostOrder(Tr.left);
			PostOrder(Tr.right);
			System.out.print(Tr.data+ " ");
			
		}
	}
	void BFT()
	{
		if(root != null)
		{
		Queue <Node> Q = new LinkedList<Node>(); //create queue Q
		Q.add(root);		//add root to Q
		while(Q.isEmpty() == false)
		{
			Node x = (Node) Q.poll(); //take out a node from Q
			if(x.left != null)			//left node
			{			
				Q.add(x.left);			//add the left child to the Q
			}
			if(x.right != null)	//right node
			{
				Q.add(x.right); //add the right child to the Q
			}
			System.out.print(x.data + " ");
		}
		}
	}
	static boolean find(Node root, int x)
	{
		if(root == null)
		{
			return false;
		}
		Queue <Node> Q = new LinkedList<>(); //create queue Q
		Q.add(root); //add root to Q
		while(Q.size() >0)
		{
			Node node = Q.peek();
			if(node.data == x)
			{
				return true;
			}
			Q.remove(); //remove node current and enqueue its children
			if(node.left != null) //node left is empty then add the left child to the Q
			{
				Q.add(node.left);
			}
			if(node.right != null) //node right is empty then add the right child to the Q
			{
				Q.add(node.right);
			}
		}
		return false;
	}
	public Node delete(Node root, int x)
	{
		if(root == null) //root is empty then return null
		{
			return null;
		}
		if(x <root.data) //x < data then delete left node of root 
		{
			root.left = delete(root.left, x);
		}
		else if (x >root.data) //x >data then delete right node of root
		{
			root.right = delete(root.right, x);
		}
		else
		{
			if(root.left == null)
			{
				return root.right;
			}
			if(root.right ==null)
			{
				return root.left;
			}
			
		}
		return root;
		
	}
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.CreateTree();
		System.out.println("Pre-Order: ");
		bst.PreOrder(bst.root);
		System.out.println("\nInOrder: ");
		bst.InOrder(bst.root);
		System.out.println("\nPostOrder: ");
		bst.PostOrder(bst.root);
		System.out.println("\nBFT: ");
		bst.BFT();
		System.out.print("\nFind x when x = 12: ");
		System.out.print((bst.find(root, 12) ? "Found \n" : "Not Found"));
		System.out.print("Find x when x = 1 :");
		System.out.print((bst.find(root, 1) ? " Found \n" : " Not Found"));
		System.out.println("\nDelete 12 in InOrder: ");
		bst.delete(root, 12);
		bst.InOrder(bst.root);
		System.out.println("\nDelete 11 in InOrder: ");
		bst.delete(root, 11);
		bst.InOrder(bst.root);
		
	}

}
