package com.company;

import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
	// write your code here
        long st, en;

        Scanner num = new Scanner(System.in);
        System.out.println("Print amount of perfect numbers:");
        int n = num.nextInt();
        long a = 1;
        int per = 0;
        System.out.println("Print 1 to work in single tread or 2 to work in multithreaded or 3 to work in 4 treads:");
        int t = num.nextInt();
        int g = 0;
        if(t==2){
            System.out.println("Print number of treads:");
            g = num.nextInt();
        }
        st = System.nanoTime();
        while (per<n) {
            if (t == 1) {
                if (perfect2(a) == true)
                    per++;
                a++;
            } else if (t == 2) {
                if (perfect(a, g) == true)
                    per++;
                a++;
            } else if (t == 3) {
                MyThread thread1 = new MyThread(a);
                thread1.setName("First");
                thread1.start();

                MyThread thread2 = new MyThread(a+1);
                thread2.setName("Second");
                thread2.start();

                MyThread thread3 = new MyThread(a+2);
                thread3.setName("Third");
                thread3.start();

                MyThread thread4 = new MyThread(a+3);
                thread4.setName("Fourth");
                thread4.start();

                thread1.join();
                if (thread1.res) {
                    per++;
                    System.out.println("Perfect number:" + thread1.ResNum);
                }
                thread2.join();
                if (thread2.res) {
                    per++;
                    System.out.println("Perfect number:" + thread2.ResNum);
                }
                thread3.join();
                if (thread3.res) {
                    per++;
                    System.out.println("Perfect number:" + thread3.ResNum);
                }
                thread4.join();
                if (thread4.res) {
                    per++;
                    System.out.println("Perfect number:" + thread4.ResNum);
                }
                a = a + 4;
            }
        }
        en = System.nanoTime();
        double time = ((en-st)/1000000000.0);
        System.out.println("The end. Time = " + String.format("%,12f", time) + "секунд");
        return;
    }

    public static boolean perfect(long a, int b) throws ExecutionException, InterruptedException {
        int sum = 0;
        SumPart obj = new SumPart(a);
        ExecutorService es = Executors.newFixedThreadPool(b);
        Future<Integer> res = es.submit(obj);
        sum = res.get();
        if (sum == a) {
            System.out.println("Perfect number: " + a);
            return true;
        }
        return false;
    }

    public static boolean perfect2(long a) {
        long PartNum = (long) (Math.pow(2, a)-1);
        long ResNum = (long) (Math.pow(2, (a-1))*(Math.pow(2, a)-1));
        for (int i = 2; i < a; i++) {
            if (a % i == 0) {
                return false;
            }
        }
        if(a!=1) {
            System.out.println("Perfect number: " + ResNum);
            return true;
        }
        return false;

        /*
        if(a%100000==0){
            System.out.println("Checking number " + a);
        }
        long sum = 0;
        for (long j=1; j < a/2+1; j++)
            if (a%j == 0)
                sum += j;
        if (sum == a) {
            System.out.println("Perfect number: " + a);
            return true;
        }
        return false;*/
    }
}
