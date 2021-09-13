package leetcode.editor.cn;

public class Reverse {

    public static void main(String[] args) {
        Reverse reverse = new Reverse();
        boolean flag = reverse.isPalindrome(121);
        System.out.println(flag);
    }

    public boolean isPalindrome(int x) {
        if(x <0) return false;
        int reverse = 0;

        while(x!=0){
            int tmp = x % 10;
            reverse = reverse *10 + tmp;
            x /= 10;
        }

        if(reverse == x) return true;
        return false;

    }
}
