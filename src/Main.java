import java.util.Random;

public class Main {

    public static void main(String[] args) {

        int n = 10000;
        int[] arr = new int[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt();
        }

        long start = System.currentTimeMillis();


        mergeSort(arr, 0, n-1);

        long end = System.currentTimeMillis();  //zamanı ms türünden yapıyoruz
        System.out.println("Merge Sort çalışma süresi: " + (end - start) + " Ms");


        boolean sorted = true; //Dizimiz sıralı şekilde mi diye bakıyoruz
        for (int i = 1; i < n; i++) {
            if (arr[i] < arr[i-1]) {
                sorted = false;
                break;
            }
        }

       
        int[] arr2 = new int[n];  // BruteForce Selection Sort ile
        for (int i = 0; i < n; i++) {
            arr2[i] = arr[i];
        }
        start = System.currentTimeMillis();
        selectionSort(arr2);
        end = System.currentTimeMillis();
        System.out.println("BruteForce Selection Sort çalışma süresi: " + (end - start) + " Ms");

    }

    public static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    public static void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }

}