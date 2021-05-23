import java.util.*;
public class main {

    public static int binarySearch(int arr[], int elementToSearch) {

        int firstIndex = 0;
        int lastIndex = arr.length - 1;

        while(firstIndex <= lastIndex) {
            int middleIndex = (firstIndex + lastIndex) / 2;
            // если средний элемент - целевой элемент, вернуть его индекс
            if (arr[middleIndex] == elementToSearch) {
                return middleIndex;
            }

            // если средний элемент меньше
            // направляем наш индекс в middle+1, убирая первую часть из рассмотрения
            else if (arr[middleIndex] < elementToSearch)
                firstIndex = middleIndex + 1;

                // если средний элемент больше
                // направляем наш индекс в middle-1, убирая вторую часть из рассмотрения
            else if (arr[middleIndex] > elementToSearch)
                lastIndex = middleIndex - 1;

        }
        return -1;
    }

    public static int interpolationSearch(int integers[], int elementToSearch) {

        int startIndex = 0;
        int lastIndex = (integers.length - 1);

        while ((startIndex <= lastIndex) && (elementToSearch >= integers[startIndex]) &&
                (elementToSearch <= integers[lastIndex])) {
            // используем формулу интерполяции для поиска возможной лучшей позиции для существующего элемента
            int pos = startIndex + (((lastIndex-startIndex) /
                    (integers[lastIndex]-integers[startIndex]))*
                    (elementToSearch - integers[startIndex]));

            if (integers[pos] == elementToSearch)
                return pos;

            if (integers[pos] < elementToSearch)
                startIndex = pos + 1;

            else
                lastIndex = pos - 1;
        }
        return -1;
    }
    static int min(int x, int y) { return (x <= y) ? x : y; }
    // искомый элемент х , n - размер массива
    static int fibMonaccianSearch(int arr[], int x, int n)
    {
        int fibMMm2 = 0; // (m-2)'th Fibonacci No.
        int fibMMm1 = 1; // (m-1)'th Fibonacci No.
        int fibM = fibMMm2 + fibMMm1; // m'th Fibonacci

        while (fibM < n) {
            fibMMm2 = fibMMm1;
            fibMMm1 = fibM;
            fibM = fibMMm2 + fibMMm1;
        }

        int offset = -1;

        while (fibM > 1) {
            int i = min(offset + fibMMm2, n - 1);

            if (arr[i] < x) {
                fibM = fibMMm1;
                fibMMm1 = fibMMm2;
                fibMMm2 = fibM - fibMMm1;
                offset = i;
            }

            else if (arr[i] > x) {
                fibM = fibMMm2;
                fibMMm1 = fibMMm1 - fibMMm2;
                fibMMm2 = fibM - fibMMm1;
            }

            else
                return i;
        }

        if (fibMMm1 ==x && arr[offset + 1] == x)
            return offset + 1;

        return -1;
    }

    public static void main(String args[])
    {
        int arr[] = { 10, 22, 35, 40, 45, 50, 80, 82, 85, 90, 100,235};
        int n = arr.length;
        int x = 100;
        int ind = fibMonaccianSearch(arr, x, n);
        if(ind>=0)
            System.out.println("Found at index: "+ ind);
        else
            System.out.println(x + " isn't present in the array");
        int inter =binarySearch(arr, x);
        System.out.println("Found at index: "+ inter);
        int bin = interpolationSearch(arr, x);
        System.out.println("Found at index: "+ bin);



    }



}

