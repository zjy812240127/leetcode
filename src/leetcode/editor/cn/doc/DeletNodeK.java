package leetcode.editor.cn.doc;

import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author Joya Zou
 * @date 2021年10月01日 19:49
 */
public class DeletNodeK {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String[] strNum = str1.split(" ");
        int len = Integer.parseInt(strNum[0]);
        int k = Integer.parseInt(strNum[1]);
        //以字符串形式作为输入
        String str = scanner.nextLine();  //.toString()
       // int n=scanner.nextInt();
        //通过分隔符将其转为字符串数组
        String[] arr  = str.split(" ");
        //初始化一个整数数组
        int[] ints = new int[arr.length];
        //给整数数组赋值
        for(int j = 0; j<ints.length;j++) {
            ints[j] = Integer.parseInt(arr[j]);
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode head = new ListNode(0);
        ListNode p = head;
        //链表初始化并放入stack中
        for(int i = 0; i < ints.length; i++){
            p.next = new ListNode(ints[i]);
            p = p.next;
            stack.add(p);
        }
        head = head.next;
        //调用函数
        ListNode res=removeNthFromEnd(head,k);
        while (res != null) {
            if(res.next == null){
                System.out.print(res.val);
            }else{
                System.out.print(res.val + ",");
            }
            res = res.next;
        }
    }
    //主函数
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy= new ListNode(0,head);//首先创建一个前驱节点，固定的//这是固定套路
        ListNode cur=dummy;//接着就是创建一个cur指针，这个是可以移动的。//这是固定套路
        //借助栈的思想来解决
        Stack<ListNode> stack =new Stack<>();
        while(cur!=null){
            stack.push(cur);
            cur=cur.next;//都加进去栈里面了
        }
        for(int i=0;i<n;i++){
            stack.pop();//剩的栈顶的元素是待删除节点的前一个元素
        }
        ListNode pre1=stack.peek();
        pre1.next=pre1.next.next;//这是删除的固定套路
        return dummy.next;  //这是固定套路
    }
}

