package com.company.threads.multiThreading.executorFramework;

public class ManualThreadPool {
    public static void main(String[] args) {
        long startTIme = System.currentTimeMillis();
        Thread[] threads = new Thread[10];
        for (int i = 1; i <= 10; i++) {
            // sychronous way
            //System.out.println(factorial(i));
            int finalI = i;
            threads[i - 1] = new Thread(
                    () -> {
                        long result = factorial(finalI);
                        System.out.println(result);
                    }
            );
            threads[i - 1].start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
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
