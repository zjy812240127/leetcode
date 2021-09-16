package leetcode.editor.cn;

public class Node {
    int val;
    Node left;
    Node right;
    Node next;
    Node(){}
    Node(int val){
        this.val = val;
    }
    Node(int val, Node left, Node right, Node next){
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }
}
