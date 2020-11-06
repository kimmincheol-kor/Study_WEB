import java.util.*;
import java.io.*;

public class q24 {
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // User Input
        n = Integer.parseInt(br.readLine());
        myArr myarr = new myArr(n);
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            myarr.arr[i] = Integer.parseInt(stk.nextToken());
        }
        
        // Sort
        myarr.quickSort(0, n-1);

        // Result
        System.out.println(myarr.arr[(n-1)/2]);
    }
}

class myArr {
    public int n;
    public int[] arr;

    myArr(int n) {
        this.n = n;
        arr = new int[n];
    }

    void quickSort(int start, int end) {
        if (end <= start) {
            return;
        }

        int pivot = arr[start];
        int left = start+1;
        int right = end;

        while(right > left) {
            if (arr[right] > pivot) right--;
            else if (arr[left] > pivot) swap(left, right);

            if (arr[left] <= pivot) left++;
            else if (arr[right] <= pivot) swap(left, right);
        }

        if(arr[right] < pivot) {
            swap(start, right);

            quickSort(start, right-1);
            quickSort(right+1, end);
        }
        else {
            quickSort(start, right-1);
            quickSort(right, end);
        }
    }

    void swap(int a1, int a2) {
        int temp = arr[a1];
        arr[a1] = arr[a2];
        arr[a2] = temp;
    }
}