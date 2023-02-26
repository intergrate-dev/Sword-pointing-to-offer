package dividemerge;

public class Solution_16 {

    /**
     * 数值的整数次方
     * 
     * 
     * @param args args
     */
    public static void main(String[] args) {
        // double x = 3;
        // int n = 7;
        double x = -3;
        int n = 97;
        /* double x = 2;
        int n = -2147483648; */
        Double myPow = new Solution_16().myPow(x, n);
        Double ss = Math.pow(x, n);
        System.out.println(myPow);
        System.out.println(ss);
        System.out.println("equals: " + ss.equals(myPow));
    }

    public double myPow(double x, int n) {
        if (x == 0)
            return x;
        double num = 1.0;
        // 转换类型
        long l = n;
        // 负数次幂转换
        if (n < 0) {
            l = -l;
            x = 1 / x;
        }
        for (; l > 0; l >>= 1) {
            // 次幂太大，计算时用位运算转换
            if ((l & 1) == 1)
                num *= x;
            x *= x;
        }
        return num;
    }

}
