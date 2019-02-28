package com.yjz.datastructure.recursion;

/**
 * Description: 递归
 * Author: yjz
 * CreateDate: 2019-02-27 9:22 PM
 **/
public class RecursionDemo {

    /**
     * 递归阶乘
     */
    public int factorial(int n) {
        if(n == 1)
            return 1;
        else if(n == 0)
            return 0;
        return n * factorial(n-1);
    }

    public void hanoi(int n,char fromPeg,char toPeg,char auxPeg ){
        if(n == 1) {
            System.out.println("move " + n + " from " + fromPeg + " to " + toPeg);
        }
        //将n-1的碟子从源柱移动到辅助柱上
        hanoi(n - 1,fromPeg,auxPeg,toPeg);
        //将第n个盘子移动到目标柱上
        System.out.println("move " + n + " from " + fromPeg + " to " + toPeg);
        //将辅助柱上面的n-1个盘子移动到目标柱上
        hanoi(n - 1,auxPeg,toPeg,fromPeg);
    }
}
