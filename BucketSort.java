package semestrovka;
import java.util.Random;

public class BucketSort {
    public static void main(String[] args) {
        int[] arr = new int[10000000];
        int n = arr.length;
        Random random = new Random();
        for (int i = 0; i <n; i++) {
            arr[i] =  random.nextInt(99999);
        }
        long start = System.nanoTime();
        bucketSort(arr, n);
        long finish = System.nanoTime();
        long elapsed = finish - start;
        System.out.println(elapsed / 1000);

    }

    static void bucketSort(int arr[], int n) {
        int i, j, k, SIZE =n;

        int buckets[] = new int[SIZE];

        for (i = 0; i < SIZE; ++i)
            buckets[i] = 0;

        for (i = 0; i < n; ++i)
            ++buckets[arr[i]];

        for (i = 0, j = 0; j < SIZE; ++j)
            for (k = buckets[j]; k > 0; --k)
                arr[i++] = j;
    }
}
