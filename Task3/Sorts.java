package Task3;

import java.util.Arrays;
import java.util.Random;

public class Sorts {
    public static void main(String[] args) {
        int[] randomArray = generateRandomArray(1000);
        int[] treeSortedArray = Arrays.copyOf(randomArray, randomArray.length);
        int[] bucketSortedArray = Arrays.copyOf(randomArray, randomArray.length);

        long treeSortIterations = treeSort(treeSortedArray);
        long bucketSortIterations = bucketSort(bucketSortedArray);

        System.out.println("Кол-во итераций Tree Sort: " + treeSortIterations);
        System.out.println("Кол-во итераций Bucket Sort: " + bucketSortIterations);

        if (treeSortIterations < bucketSortIterations) {
            System.out.println("У Tree Sort меньшее кол-во итераций");
        } else if (treeSortIterations > bucketSortIterations) {
            System.out.println("У Bucket Sort меньшее кол-во итераций");
        } else {
            System.out.println("У сортировок одмнаковое количество итераций");
        }
    }

    public static int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(10000); // Генерируем случайные числа от 0 до 9999
        }
        return arr;
    }

    public static long treeSort(int[] arr) {
        long iterations = 0;
        for (int i = 0; i < arr.length; i++) {
            iterations++;
            int current = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > current) {
                iterations++;
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = current;
        }
        return iterations;
    }

    public static long bucketSort(int[] arr) {
        long iterations = 0;
        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();
        int range = max - min + 1;
        int bucketCount = Math.min(range, arr.length);
        int[] buckets = new int[bucketCount];

        for (int num : arr) {
            int index = (num - min) * (bucketCount - 1) / range;
            buckets[index]++;
            iterations++;
        }

        int index = 0;
        for (int i = 0; i < bucketCount; i++) {
            for (int j = 0; j < buckets[i]; j++) {
                arr[index++] = i + min;
                iterations++;
            }
        }
        return iterations;
    }
}
