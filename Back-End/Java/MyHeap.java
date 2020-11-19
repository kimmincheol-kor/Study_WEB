public class MyHeap {
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
        int minimum = datas.get(1);
        datas.set(1, datas.get(datas.size()-1));
        datas.remove(datas.size()-1);

        int pos = 1;

        while(pos*2 < heap.size()) {
            int minIdx = pos*2;
            
            if (pos*2+1 < heap.size() && datas.get(pos*2+1) < datas.get(minIdx)) {
                minIdx = pos*2 + 1;
            }

            int temp = datas.get(pos);
            datas.set(pos, datas.get(minIdx));
            datas.set(minIdx, temp);

            pos = minIdx;
        }

        return minimum;
    }
}