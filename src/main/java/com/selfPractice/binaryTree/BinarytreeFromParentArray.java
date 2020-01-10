package com.selfPractice.binaryTree;
//createTree(parent[], n)
//
//Create an array of pointers say created[0..n-1]. The value of created[i] is NULL if node for index i is not created, else value is pointer to the created node.
//Do following for every index i of given array
//createNode(parent, i, created)
//
//
//createNode(parent[], i, crated[])
//
//If created[i] is not NULL, then node is already created. So return.
//Create a new node with value ‘i’.
//If parent[i] is -1 (i is root), make created node as root and return.
//Check if parent of ‘i’ is created (We can check this by checking if created[parent[i]] is NULL or not.
//If parent is not created, recur for parent and create the parent first.
//Let the pointer to parent be p. If p->left is NULL, then make the new node as left child. Else make the new node as right child of parent.



// Java program to construct a binary tree from parent array
  
// A binary tree node  
class BinarytreeFromParentArray 
{
    BinaryTreeNodeZ root;
  
    // Creates a node with key as 'i'.  If i is root, then it changes
    // root.  If parent of i is not created, then it creates parent first
    void createNode(int parent[], int i, BinaryTreeNodeZ created[])
    {
        // If this node is already created
        if (created[i] != null)
            return;
  
        // Create a new node and set created[i]
        created[i] = new BinaryTreeNodeZ(i);
  
        // If 'i' is root, change root pointer and return
        if (parent[i] == -1) 
        {
            root = created[i];
            return;
        }
  
        // If parent is not created, then create parent first
        if (created[parent[i]] == null)
            createNode(parent, parent[i], created);
  
        // Find parent pointer
        BinaryTreeNodeZ p = created[parent[i]];
  
        // If this is first child of parent
        if (p.left == null)
            p.left = created[i];
        else // If second child
          
            p.right = created[i];
    }
  
    /* Creates tree from parent[0..n-1] and returns root of 
       the created tree */
    BinaryTreeNodeZ createTree(int parent[], int n)
    {    
        // Create an array created[] to keep track
        // of created nodes, initialize all entries
        // as NULL
        BinaryTreeNodeZ[] created = new BinaryTreeNodeZ[n];
        for (int i = 0; i < n; i++) 
            created[i] = null;
  
        for (int i = 0; i < n; i++)
            createNode(parent, i, created);
  
        return root;
    }
  
    //For adding new line in a program
    void newLine() 
    {
        System.out.println("");
    }
  
    // Utility function to do inorder traversal
    void inorder(BinaryTreeNodeZ node)
    {
        if (node != null) 
        {
            inorder(node.left);
            System.out.print(node.data + " ");
            inorder(node.right);
        }
    }
  
    // Driver method
    public static void main(String[] args) 
    {
  
    	BinarytreeFromParentArray tree = new BinarytreeFromParentArray();
        int parent[] = new int[]{-1, 0, 0, 1, 1, 3, 5};
        int n = parent.length;
        BinaryTreeNodeZ node = tree.createTree(parent, n);
        System.out.println("Inorder traversal of constructed tree ");
        tree.inorder(node);
        tree.newLine();
    }
}
  
// This code has been contributed by Mayank Jaiswal(mayank_24)