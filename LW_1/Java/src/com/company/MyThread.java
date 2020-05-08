package com.company;

import java.math.BigInteger;

public class MyThread extends Thread {
    long TestNum = 0;
    long ResNum = 0;
    boolean res = false;
    public MyThread(long h) {
        TestNum = h;
    }
    @Override
    public void run() {
        long PartNum = (long) (Math.pow(2, TestNum)-1);
        ResNum = (long) (Math.pow(2, (TestNum-1))*(Math.pow(2, TestNum)-1));
            for (int i = 2; i < TestNum; i++) {
                if (TestNum % i == 0) {
                    return;
                }
            }
            if(TestNum!=1)
                res = true;
        /*
        if(TestNum%100000==0){
            System.out.println("Checking number " + TestNum);
        }
        long sum = 0;
        long b = TestNum/2+1;
        for (long j=1; j < b; j++)
            if (TestNum%j == 0) {
                sum += j;
            }
        if(sum==TestNum) {
            res = true;
        }
         */

    }
}
