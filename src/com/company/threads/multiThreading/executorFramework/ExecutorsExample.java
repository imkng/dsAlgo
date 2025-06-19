package com.company.threads.multiThreading.executorFramework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorsExample {
    public static void main(String[] args) {
        long startTIme = System.currentTimeMillis();
        // Thread[] threads = new Thread[10];
        ExecutorService executorService = Executors.newFixedThreadPool(9);
        for (int i = 1; i <= 10; i++) {
            int finalI = i;
            //1. sychronous way
            //System.out.println(factorial(i));

//2.            threads[i - 1] = new Thread(
//                    () -> {
//                        long result = factorial(finalI);
//                        System.out.println(result);
//                    }
//            );
//            threads[i - 1].start();
            executorService.submit(() -> {
                long result = factorial(finalI);
                System.out.println(result);
            });
        }
//        for (Thread thread : threads) {
//            try {
//                thread.join();
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(100, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Total TIme: " + (System.currentTimeMillis() - startTIme));
    }

    private static long factorial(int n) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long ans = 1;
        for (int i = 1; i <= n; i++) {
            ans *= i;
        }
        return ans;
    }
}
