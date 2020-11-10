import java.io.*;
import java.util.*;

public class BOJ1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        myHeap heap = new myHeap();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i=0; i<n; i++) {
            int op = Integer.parseInt(br.readLine());

            if( op == 0 ){
                result.add(heap.poll());
            }
            else {
                heap.add(op);
            }
        }

        for (int i=0; i<result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}

class myHeap {
    ArrayList<Integer> datas;

    myHeap() {
        datas = new ArrayList<>();
        datas.add(-1);
    }

    int size() {
        return datas.size();
    }

    void add(int data) {
        datas.add(data);
        int p = datas.size()-1;

        while(p > 1 && datas.get(p) < datas.get(p/2)) {
            int temp = datas.get(p);
            datas.set(p, datas.get(p/2));
            datas.set(p/2, temp);
            p = p/2;
        }
    }

    int poll() {
        if (datas.size() < 2) return 0;

        int minimum = datas.get(1);
        datas.set(1, datas.get(datas.size()-1));
        datas.remove(datas.size()-1);

        int pos = 1;

        while(pos*2 < datas.size()) {
            int minIdx = pos*2;
            
            if (minIdx+1 < datas.size() && datas.get(minIdx+1) < datas.get(minIdx)) {
                minIdx++;
            }

            if (datas.get(minIdx) < datas.get(pos)) {
                int temp = datas.get(pos);
                datas.set(pos, datas.get(minIdx));
                datas.set(minIdx, temp);

                pos = minIdx;
            }
            else {
                break;
            }
        }

        return minimum;
    }
}