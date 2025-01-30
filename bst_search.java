import java.util.Scanner;
class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
class BST{
    TreeNode root;
    public void insert_TreeNode(int data){
        root  = insert_rec(data,root);
    }
    public TreeNode insert_rec(int data,TreeNode root){
        if(root==null){
            root = new TreeNode(data);
            return root;
        }
        else if(data>root.data){
            
            root.right = insert_rec(data, root.right);
        }
        else if(data<root.data){
            
            root.left = insert_rec(data, root.left);
        }
        return root;
    }
    public int  search(int key){
        return search_rec(root,key,0);
    }
    public int  search_rec(TreeNode root, int key,int level){
        if(root==null){
            return -1;
        }
        if(root.data==key){
            return level;
        }
        if(root.data>key){
            return search_rec(root.left,key,level+1);
            
        }
        return search_rec(root.right, key,level+1);
    }
}

public class bst_search {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number you want to search:");
        int n = sc.nextInt();
        BST obj = new BST();
        obj.insert_TreeNode(5);
        obj.insert_TreeNode(6);
        obj.insert_TreeNode(10);
        obj.insert_TreeNode(1);
        obj.insert_TreeNode(0);
        sc.close();
        System.out.println("The key is found at level: "+obj.search(n));
    }
    
}