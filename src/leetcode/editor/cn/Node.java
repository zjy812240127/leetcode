package leetcode.editor.cn;

public class Node {
    int val;
    Node left;
    Node right;
    Node next;
    Node random;
    Node(){}
    Node(int val){
        this.val = val;
    }
    Node(int val, Node left, Node right, Node next, Node random){
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
        this.random = random;
    }
}
