package dividemerge;
/**
 *  数组中的逆序对
 * 
 */

public class Solution_51 {
    int[] nums, tmp;

    public static void main(String[] args) {
        Solution_51 instance = new Solution_51();
        int[] arr = {7,3,2,6,0,1,5,4};
        int res = instance.reversePairs(arr);
        System.out.println(res);
    }

    public int reversePairs(int[] nums) {
        this.nums = nums;
        tmp = new int[nums.length];
        return mergeSort(0, nums.length - 1);
    }

    private int mergeSort(int l, int r) {
        // 终止条件
        if (l >= r)
            return 0;
        // 递归划分
        int m = (l + r) / 2;
        int res = mergeSort(l, m) + mergeSort(m + 1, r);
        // 合并阶段
        int i = l, j = m + 1;
        for (int k = l; k <= r; k++)
            tmp[k] = nums[k];
        for (int cur = l; cur <= r; cur++) {
            if (i == m + 1)
                // 左子数组已合并完，添加右子数组当前元素，j+1
                nums[cur] = tmp[j++];
            else if (j == r + 1 || tmp[i] <= tmp[j])
                // 右子数组已合并完(没合并完时tmp[i] <= tmp[j])，添加左子数组当前元素，i+1
                nums[cur] = tmp[i++];
            else {
                // tmp[i] > tmp[j]，添加右子数组当前元素，j+1
                nums[cur] = tmp[j++];
                res += m - i + 1; // 统计逆序对
            }
        }
        return res;
    }

}

