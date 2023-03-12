package bitoperation;

/**
 * 找只出现一次的数字
 * 一个整型数组里除两个数字之外，其他数字都出现了两次。找出这两个数字，要求时间复杂度是O(n)，空间复杂度是O(1)。
 * （哈希表方式排除了）
 */
public class Solution_56 {

    public static void main(String[] args) {
        int[] nums = {1,2,10,4,1,4,3,3};
        int[] res = new Solution_56().searchSingleNumbers(nums);
        System.out.println(res[0] + ", " + res[1]);
    }

    public int[] searchSingleNumbers(int[] nums) {
        int xs = 0;
        for (int x : nums) {
            xs ^= x;
        }
        int lb = xs & - xs;
        int a = 0;
        for (int x : nums) {
            if ((x & lb) != 0) {
                a ^= x;
            }
        }
        int b = xs ^ a;
        return new int[] {a, b};
    }
}
