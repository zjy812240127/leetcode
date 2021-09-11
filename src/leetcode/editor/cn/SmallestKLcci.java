//设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
//
// 示例：
//
// 输入： arr = [1,3,5,7,2,4,6,8], k = 4
//输出： [1,2,3,4]
//
//
// 提示：
//
//
// 0 <= len(arr) <= 100000
// 0 <= k <= min(100000, len(arr))
//
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 156 👎 0

package leetcode.editor.cn;
public class SmallestKLcci {
    public static void main(String[] args) {
        Solution solution = new SmallestKLcci().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] smallestK(int[] arr, int k) {

        int[] res = new int[k];
        if(k==0) return res;
        quickSort(arr,0,arr.length-1,k);
        for(int i=0; i<k;i++){
            res[i] = arr[i];
        }
        return res;
    }

    public void quickSort(int[] arr, int start, int end, int k){
        if(start >= end) return;
        int tmp = arr[start];  // 比较位
        int i = start;
        int j = end;

        while(i != j){
            while(i<j && arr[j] >= tmp){
                j--;
            }
            while(i<j && arr[i] <= tmp){
                i++;
            }
            if(i<j){
                int tmpNum = arr[i];
                arr[i] = arr[j];
                arr[j] = tmpNum;
            }
        }

        arr[start] = arr[i];
        arr[i] = tmp;

        if(i == k) return;
        if(i<k) quickSort(arr,i+1,end,k);
        else quickSort(arr,start,i-1,k);

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
