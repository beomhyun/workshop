package BST;

public class BST {

	public static void main(String[] args) {
		Node root = new Node(0);
		//시작노드를 0을 가지는 데이터로 초기화 했음 
		BST bst = new BST();
		bst.addNode(root, new Node(1));
		bst.addNode(root, new Node(2));
		bst.addNode(root, new Node(3));
		bst.addNode(root, new Node(4));
		search(root, new Node(1));
		search(root, new Node(5));
		print(root);
	}
	public static void print(Node node) {
		System.out.print(node.data+" ");
		if(node.left != null) {
			print(node.left);
			if(node.right!=null){
				print(node.right);
			}
		}
		if(node.right != null) {
			print(node.right);
			if(node.left!=null){
				print(node.left);
			}
		}
	}
	public static void search(Node node,Node newnode) {
		if(node.data == newnode.data) {
			System.out.println("찾았다");
			return;
		}else if(node.right!=null && node.data < newnode.data) {
			search(node.right,newnode);
		}else if(node.left != null && node.data > newnode.data) {
			search(node.left,newnode);
		}
	}
	public void addNode(Node node, Node newnode) {
		//System.out.println(node.data);
		if(node == null ) {
			node = newnode;
			return;
		}
		if(node.data < newnode.data) {
			if(node.right == null) {
				node.right = newnode;
				return;
			}else {
				addNode(node.right,newnode);
			}
		}else if(node.data > newnode.data) {
			if(node.left ==null) {
				node.left = newnode;
				return;
			}else {
			addNode(node.left,newnode);
			}
		}
	}
}
class Node{
	int data;
	Node left;
	Node right;
	
	public Node(int data) {
		this.data = data;
	}
}