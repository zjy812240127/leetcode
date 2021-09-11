public class quickSort {
    public static void main(String[] args) {
        int[] nums = {3 ,2 ,1, 5, 6, 4};
        int k = 2;
        quickSort qc = new quickSort();
        int res  = qc.findKthLargest(nums,k);
        System.out.println(res);
    }

    public int findKthLargest(int[] nums, int k) {
        // 快速排序

        quickSort(nums, 0, nums.length-1);
        return nums[nums.length-1];


    }

    public void quickSort(int[] nums, int lPoint, int rPoint){
        if(lPoint > rPoint) return;
        int p = lPoint;
        int q = rPoint;
        int tmp = nums[lPoint];

        while(p != q){
            while(nums[p] <= tmp && q > p){
                p++;
            }
            while(nums[q] >= tmp && q >p){
                q--;
            }

            if(p < q){
                int tmpNum = nums[p];
                nums[p] = nums[q];
                nums[q] = tmpNum;
            }
        }

        nums[lPoint] = nums[p];
        nums[p] = tmp;


        quickSort(nums, lPoint, p-1);
        quickSort(nums, p+1, rPoint);

    }
}
