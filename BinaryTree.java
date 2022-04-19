import java.util.Scanner;

public class BinaryTree {
Node head=new Node();//for queue
   Node top;
   int size;
    Node root;

    public void addNode(int key, String name,String meaning) {

       

        Node newNode = new Node(key, name,meaning);

    

        if (root == null) {

            root = newNode;

        } else {

            

            Node focusNode = root;

            

            Node parent;

            while (true) {

               

                parent = focusNode;

                

                if (key < focusNode.key) {

                   

                    focusNode = focusNode.leftChild;

                   

                    if (focusNode == null) {

                       

                        parent.leftChild = newNode;
                        return;

                    }

                } else { 

                    focusNode = focusNode.rightChild;

                   
                    if (focusNode == null) {

                        
                        parent.rightChild = newNode;
                        return; 

                    }

                }

            }
        }

    }

  

    public void inOrderTraverseTree(Node focusNode) {

        if (focusNode != null) {

          

            inOrderTraverseTree(focusNode.leftChild);

  

            System.out.println(focusNode);

            

            inOrderTraverseTree(focusNode.rightChild);

        }

    }

    public void preorderTraverseTree(Node focusNode) {

        if (focusNode != null) {

            System.out.println(focusNode);

            preorderTraverseTree(focusNode.leftChild);
            preorderTraverseTree(focusNode.rightChild);

        }

    }

    public void postOrderTraverseTree(Node focusNode) {

        if (focusNode != null) {

            postOrderTraverseTree(focusNode.leftChild);
            postOrderTraverseTree(focusNode.rightChild);

            System.out.println(focusNode);

        }

    }

    public Node findNode(int key) {

        // Start at the top of the tree

        Node focusNode = root;

        // While we haven't found the Node
        // keep looking

        while (focusNode.key != key) {

            // If we should search to the left

            if (key < focusNode.key) {

                // Shift the focus Node to the left child

                focusNode = focusNode.leftChild;

            } else {

                // Shift the focus Node to the right child

                focusNode = focusNode.rightChild;

            }

            // The node wasn't found

            if (focusNode == null)
                return null;

        }

        return focusNode;

    }
    public  Node deleteNode(Node root, int value) {
        if (root == null)
            return null;
        if (root.key >value) {
            root.leftChild = deleteNode(root.leftChild, value);
        } else if (root.key < value) {
            root.rightChild = deleteNode(root.rightChild, value);
 
        } else {
            // if nodeToBeDeleted have both children
            if (root.leftChild != null && root.rightChild != null) {
                Node temp = root;
                // Finding minimum element from right
            Node minNodeForRight = minimumElement(temp.rightChild);
                // Replacing current node with minimum node from right subtree
                root.key = minNodeForRight.key;
                // Deleting minimum node from right now
                root.rightChild = deleteNode(root.rightChild, minNodeForRight.key);
 
            }
            // if nodeToBeDeleted has only left child
            else if (root.leftChild != null) {
                root = root.leftChild;
            }
            // if nodeToBeDeleted has only right child
            else if (root.rightChild != null) {
                root = root.rightChild;
            }
            // if nodeToBeDeleted do not have child (Leaf node)
            else
                root = null;
        }
        return root;
    }
    public Node minimumElement(Node root) {
        if (root.leftChild == null)
            return root;
        else {
            return minimumElement(root.leftChild);
        }
    }

   
//add in queue
public void add( int obj,String name,String meaning) {
	
    // Node i=head;
    if (this.head.next == null) {
        head.next.data = obj;
        head.prev = head.next;
        ++size;
    } else {
        head.prev = head.prev.next = new Node(obj, name,meaning,head, head.prev);
        ++size;
        
    }
}
public void display() {
    for (Node p = head.next; p != head; p = p.next) {
        System.out.print("\n"+p.data+"\n"+p.name+"\n"+p.meaning+"\n\n\n");
    }
}
//search in queue

public void search( int d) {
    Node s = head.next;

    boolean find = false;
    for (Node i = s; i != head; i = i.next) {
        if (d == i.data) {
            find = true;
            break;
        }
    }
    if (find) {
        System.out.print("element is find ");
    } else {
        System.out.print("element is not find ");

    }
}

    public static void main(String[] args) {

        BinaryTree theTree = new BinaryTree();


//queue
// theTree.add(32, "cow","c");
// theTree.add(39, "bat","b");
// theTree.add(42, "colour","c");
// theTree.add(66, "garden","g");
// theTree.add(21, "mango","m");
// theTree.display();

// theTree.search(32);

//
System.out.println("\n\n\t\t\tDICTIONARY IN BINARY SEARCH TREE\t\t\n\n\n");


        theTree.addNode(50, "Abaft"," behind the stern of a ship");

        theTree.addNode(25, "Abase","Behave in away that belittlies or degrades");

        theTree.addNode(15, "Abduct","Take away by deception or force(kidnap)");

        theTree.addNode(30, "Abridge","Shorten without losing the sense");

        theTree.addNode(75, "Farther","Physical distance");

        theTree.addNode(85, "Further","Abstract idea");
     // System.out.println(theTree.search(theTree.root, 75));
        Scanner scan=new Scanner(System.in);

int choice=0;
while(choice!=4){
    System.out.println("WHAT DO YOU WANT TO DO?\n\n\n");
    System.out.println("press 1  for inserting \n press 2 for traversing \n press 3 for for deleting \n press 4 for exit \n Press 5 for searching in BST\n Press 6 for searching in QUEUE");
   choice=scan.nextInt();
   if(choice==1){
    System.out.println(" Inserting a node");
    String n;
    String m;
    int k;
    
    System.out.println("enter name");
    n=scan.next();
    System.out.println(" enter meaning");
    m=scan.next();
    System.out.println(" enter key");
    k=scan.nextInt();
    theTree.addNode(k,n,m);
theTree.add(k, n, m);    
   }
   if(choice==2){
System.out.println("Traversing in Binary Search Tree");
    theTree.inOrderTraverseTree(theTree.root);
   }
   if(choice==3){
       int k;
       k=scan.nextInt();
    theTree.deleteNode(theTree.root,k);

   }
   if(choice ==4){
    System.out.println("thankyou!!!!!!!");   
    return;
   }
   if(choice==5){
       System.out.println("search any record by key");
       int find;
       find=scan.nextInt();
System.out.println("find :"+theTree.findNode(find));

System.out.println();
System.out.println("\n\n\nIt is defined as the number of times a particular instruction set is executed rather than the total time is taken. It is because the total time took also depends on some external factors like the compiler used, processor’s speed, etc.O(log N)\n\n\n");
    }
//searching in queue
    if(choice==6){
        System.out.println("search any record by key");
        int find;
        find=scan.nextInt();

 theTree.search(find);
 
 System.out.println();
 System.out.println("\n\n\nIt is defined as the number of times a particular instruction set is executed rather than the total time is taken. It is because the total time took also depends on some external factors like the compiler used, processor’s speed, etc.:	O(N)\n\n");
 
     }
}
       


    }

   
   
}

class Node {

    int key;
    String name;
    String meaning;
    Node leftChild;
    Node rightChild;
    
    Node prev = this;

    
    Node next=this;
    int data;
Node(){

}
    Node(int key, String name,String meaning) {

        this.key = key;
        this.name = name;
this.meaning=meaning;
     } //for queue
Node( int data, String name,String meaning,Node next, Node prev) {
    this.data = data;
    this.name=name;
    this.meaning=meaning;
    this.next = next;
    this.prev = prev;

}

    private void Node() {
    }
    public String toString() {

        return "\n"+name + "\n has the key   :" + key+"\n  meaning   :"+  meaning+"\n\n";

        /*
         * return name + " has the key " + key + "\nLeft Child: " + leftChild +
         * "\nRight Child: " + rightChild + "\n";
         */

    }

}
