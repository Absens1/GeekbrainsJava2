package lesson5;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        nonThreadMethod();
        threadMethod();
    }

    public static void nonThreadMethod() {
        System.out.println("---Non thread method started!---");
        final int size = 10000000;
        float[] arr = new float[size];
        Arrays.fill(arr, 1);
        long time = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5.0f) * Math.cos(0.2f + i / 5.0f) * Math.cos(0.4f + i / 2.0f));
        }
        System.out.println("Operation time: " + (System.currentTimeMillis() - time) + "ms");
        System.out.println("---Non thread method ended!---\n");
    }

    public static void threadMethod() {
        System.out.println("---Thread method started!---");
        final int size = 10000000;
        final int h = size / 2;
        float[] arr = new float[size];
        Arrays.fill(arr, 1);
        long time = System.currentTimeMillis();

        float[] a1 = new float[h];
        float[] a2 = new float[h];

        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);

        Runnable task1 = () -> {
            for (int i = 0; i < a1.length; i++) {
                a1[i] = (float)(a1[i] * Math.sin(0.2f + i / 5.0f) * Math.cos(0.2f + i / 5.0f) * Math.cos(0.4f + i / 2.0f));
            }
        };
        Runnable task2 = () -> {
            for (int i = 0; i < a2.length; i++) {
                a2[i] = (float)(a2[i] * Math.sin(0.2f + (i+h) / 5.0f) * Math.cos(0.2f + (i+h) / 5.0f) * Math.cos(0.4f + (i+h) / 2.0f));
            }
        };

        Thread thread1 = new Thread(task1);
        thread1.start();
        Thread thread2 = new Thread(task2);
        thread2.start();
        try{
            thread1.join();
            thread2.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);

        System.out.println("Operation time: " + (System.currentTimeMillis() - time) + "ms");
        System.out.println("---Thread method ended!---\n");

    }
}
