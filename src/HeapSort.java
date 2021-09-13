public class HeapSort {

    /**
     *  LUR 算法
     *  组成部分：
     *      1. adjustHeap:构建（从arr.length/2 -1号节点开始，向上遍历到头节点0） + 调整堆（从最后一个节点arr.length -1 开始向上遍历到头节点的第一个子节点1）
     *      2. swap：调整堆时每轮都要先将堆顶元素与当前节点交换，然后重新调整堆顶元素更新后的新堆
     *      3. sort排序：先调用adjustHeap构建堆（得到的堆顶元素是最大值），然后调用 swap + adjustHeap 依次从最后一个节点遍历到第一个子节点
     *
     */

    public static void main(String[] args) {
        int[] arr = {7,6,7,11,5,12,3,0,1};
        sort(arr);
        for(int num: arr){
            System.out.println(num);
        }

    }

    public static void sort(int[] arr){
        // 从arr.length /2 -1 开始向上到0构建大顶堆
        for(int i= arr.length/2 -1; i>=0; i--){
            adjustHeap(arr,i,arr.length);
        }
        // 从arr.length -1 开始向上到1遍历排序
        for(int i=arr.length -1; i>0; i--){
            swap(arr,i,0);
            adjustHeap(arr,0,i);  // 前面排好序的都放到了末尾，下一轮不在参加排序
        }
    }


    public static void adjustHeap(int[] arr, int root, int len){
        // 先保存当前父节点的值，便于之后与子节点交换
        int tmp = arr[root];
        // 遍历该节点的子节点，找到子节点中的最大值，for循环每轮向下找一个子节点，该子节点作为下一轮的父节点，任然找他的子节点中的最大值
        for(int k = 2* root +1; k<len; k = 2*k+1 ){  // 每一轮以上一轮的子节点作为新一轮的父节点
            // 每次找到一层中最大的节点，就将祖父节点的值设置为该最大值，并且将祖父节点的下标设为该下标
            if(k+1 < len && arr[k] <arr[k+1]){
                k++;  // 如果右子节点比左子节点大就指向右子节点，表示找到一个更大的值
            }

            if(arr[k] > tmp){  // 如果当前节点值比祖父节点要大，那就交换（交换过程完成一半）
                arr[root] = arr[k];
                root = k;  // 缩小范围，祖父节点往下更新
            }else break;
        }
        // 将当前祖父节点的值设置为tmp，完成调整（执行后半部分交换过程）
        arr[root] = tmp;

    }

    public static void swap(int[] arr, int a, int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;

    }



}
