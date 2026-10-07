import edu.princeton.cs.algs4.*;
import java.util.Arrays;

public class InsertionSortSurvey {

    static final String DIR = "C:\\Users\\Admin\\Algorithms\\edu\\princeton\\cs\\algs4\\algs4-data\\";
    static void insertionSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int key = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
    }

    static double run(int[] data) {
        int[] a = data.clone();
        long start = System.nanoTime();
        insertionSort(a);
        long end = System.nanoTime();
        return (end - start) / 1e6;
    }

    static double avg(int[] data, int times) {
        double sum = 0;
        for (int t = 0; t < times; t++) sum += run(data);
        return sum / times;
    }

    static double avgRandom(int n, int times) {
        double sum = 0;
        for (int t = 0; t < times; t++) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = StdRandom.uniform(1000000);
            sum += run(a);
        }
        return sum / times;
    }

    static int[] ascending(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = i;
        return a;
    }

    static int[] descending(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = n - i;
        return a;
    }

    static int[] equalValues(int n) {
        int[] a = new int[n];
        Arrays.fill(a, 5);
        return a;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            run(descending(5000));
            run(ascending(5000));
        }
        String[] files = {"1Kints.txt", "2Kints.txt", "4Kints.txt",
                "8Kints.txt", "16Kints.txt", "32Kints.txt"};

        for (int i = 0; i < 3; i++) run(descending(5000));

        StdOut.printf("%8s %10s %10s %10s %10s %10s%n",
                "n", "(1)File", "(2)Random", "(3)Xuoi", "(4)Nguoc", "(5)Bang");

        for (String f : files) {
            In in = new In(DIR + f);
            int[] a = in.readAllInts();     // loại (1)
            int n = a.length;

            double t1 = avg(a, 3);
            double t2 = avgRandom(n, 5);
            double t3 = avg(ascending(n), 3);
            double t4 = avg(descending(n), 3);
            double t5 = avg(equalValues(n), 3);

            StdOut.printf("%8d %10.3f %10.3f %10.3f %10.3f %10.3f%n",
                    n, t1, t2, t3, t4, t5);
        }
    }
}
//với dữ liệu file, ngẫu nhiên và sắp ngược, khi n tăng gấp đôi thì thời gian tăng khoảng 4 lần (ví dụ ngẫu nhiên: 10,98 ms
// ở 16000 lên 41,43 ms ở 32000), phù hợp độ phức tạp O(n²). Với dữ liệu đã sắp xuôi và dữ liệu toàn giá trị bằng nhau,
// thời gian tăng gấp đôi khi n tăng gấp đôi (0,008 → 0,016 ms), phù hợp O(n)