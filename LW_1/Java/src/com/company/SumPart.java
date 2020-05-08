package com.company;

import java.security.InvalidParameterException;
import java.util.concurrent.Callable;

public class SumPart implements Callable<Integer> {
    public long a;

    public SumPart (long h) {
        a = h;
    }

    public Integer call() {
        int sum = 0;
        int b = (int)a/2+1;
        for (int j=1; j < b; j++)
            if (a%j == 0)
                sum += j;
        return sum;
    }
}
