package com.yjz.leetcode;

/**
 * Description:计算幂函数
 * Author: yjz
 * CreateDate: 2018-12-19 11:46 AM
 **/
public class Le50_ComputePow {

    /**
     * 直接循环相乘效率低，会超时
     */
    public double myPow(double base,int exponent) {
        //0的n次方还是0，1的n次方
        if(base == 0 || base == 1) {
            return base;
        }
        //如果幂次为负数，结果要取反
        if (exponent < 0)
            return 1 / power2(base,-exponent);
        else
            return power2(base,exponent);
    }

    /**
     * 递归求解，因为x^n其实为x^ern/2结果求平方，节省大量计算
     */
    private double power(double base,int exponent) {

        if(exponent == 0) {
            return 1;
        }
        //为什么使用移位运算会造成堆栈溢出？
        //double result = power(base,exponent >> 1 );
        double result = power(base,exponent / 2 );
        if(exponent % 2 == 0 ){
            return result * result;
        } else {
            return result * result * base;
        }
    }

    /**
     * 不适用递归，快速幂
     */
    private double power2(double base, int exponent) {
        double result = 1;
        while (exponent > 0) {
            if((exponent % 2) == 1) {
                result *= base;
            }
            base *= base;
            exponent >>= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        Le50_ComputePow computePow = new Le50_ComputePow();
        System.out.println(computePow.myPow(2.00000,10));
        System.out.println(computePow.myPow(2.10000,3));
        System.out.println(computePow.myPow(2.00000,-2));
        System.out.println(computePow.myPow(1.00001,123456));
        System.out.println(computePow.myPow(2,-2147483648));
    }
}
