public class DoublePoint {

    public static void main(String[] args) {
        String str = "a good   example";
        str.trim();
        DoublePoint dp = new DoublePoint();
        String reverseWords = dp.reverseWords(str);
        System.out.println(reverseWords);
    }

    public String reverseWords(String s) {
        s = s.trim();
        String[] nums = s.split(" ");
        int lPoint = 0;
        int rPoint = nums.length -1;

        while(lPoint != rPoint && lPoint < rPoint){
            String tmp = nums[lPoint];
            nums[lPoint] = nums[rPoint];
            nums[rPoint] = tmp;
            lPoint ++;
            rPoint --;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<nums.length -1; i++){
            if(nums[i] != ""){
                nums[i] = nums[i].trim();
                sb.append(nums[i]+ " ");
            }else{
                continue;
            }

        }

        sb.append(nums[nums.length -1].trim());
        String res = sb.toString();
        return res;

    }

}
