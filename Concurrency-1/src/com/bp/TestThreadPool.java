package com.bp;

import java.util.ConcurrentModificationException;
import java.util.concurrent.*;

public class TestThreadPool {

    static double myddd1;
    static double myddd2;

    public static void main2(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);//creating a pool of 5 threads
        for (int i = 0; i < 10; i++) {
            Runnable worker = new WorkerThread("" + i);
            executor.execute(worker);//calling execute method of ExecutorService
        }
        executor.shutdown();
        while (!executor.isTerminated()) {   }

        System.out.println("Finished all threads");
    }

    public static void main3(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10; i++) {
            executorService.execute(new Runnable() {
                public void run() {
                    System.out.println("Asynchronous task ");
                }
            });
        }

        executorService.shutdown();
    }


    public static void main(String[] args) {

        final double[] myd1 = {2.0};
        final double[] myd2 = {2.0};
        final double mydd;

        Runnable myRunnable1 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    computationMethod1();
                }
                myd1[0] = computationMethod1();
                myddd1 = computationMethod1();
                System.out.println("Asynchronous task #1 done : " + myd1[0]);
            }
        };

        Callable<Double> myCallable1 = new Callable<Double>() {
            @Override
            public Double call() throws Exception {
                for (int i = 0; i < 10; i++) {
                    computationMethod1();
                }
                return computationMethod1();
            }
        };

        Callable<Double> myCallable2 = new Callable<Double>() {
            @Override
            public Double call() throws Exception {
                for (int i = 0; i < 10; i++) {
                    computationMethod2();
                }
                return computationMethod2();
            }
        };

        Runnable myRunnable2 = new Runnable() {
            @Override
            public void run() {
                myd2[0] = computationMethod2();
                myddd2 = computationMethod2();
                System.out.println("Asynchronous task #2 done : " + myd2[0]);
            }
        };

        //executorService.execute(myRunnable1);
        //executorService.execute(myRunnable2);
        for (int i = 1; i<100001; i++) {

            System.out.println("Running experiement #"+i);
            ExecutorService executorService = Executors.newFixedThreadPool(1000);
            Future future1 = executorService.submit(myCallable1);
            Future future2 = executorService.submit(myCallable2);
            executorService.shutdown();
            try {
                if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                    executorService.shutdownNow();
                }
            } catch (InterruptedException ex) {
                executorService.shutdownNow();
                Thread.currentThread().interrupt();
            }

            System.out.println("Asynchronous task #1 AFTER done : " + myddd1);
            System.out.println("Asynchronous task #2 AFTER done : " + myddd2);
            try {
                System.out.println("future1.get() = " + future1.get());
                System.out.println("future2.get() = " + future2.get());
            } catch (InterruptedException ie) {
                //
            } catch (ExecutionException ee) {
                //
            }
            System.out.println("Asynchronous tasks are submitted ");
        }
    }

    public static double computationMethod1() {
        double sum = 0;
        for (int i = 0; i<1000; i++) {
            sum = sum + Math.cos(Math.cos(i)) + Math.cos(Math.cos(i));
        }
        return sum;
    }


    public static double computationMethod2() {
        double sum = 0;
        for (int i = 0; i<1000; i++) {
            sum = sum + Math.sin(Math.cos(i)) + Math.sin(Math.cos(i));
        }
        return sum;
    }
}