import java.util.*;
import java.io.*;

public class q23 {
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        ArrayList<StudentData> arr = new ArrayList<>();

        for(int i=0; i<n; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());

            String name = stk.nextToken();
            int kor = Integer.parseInt(stk.nextToken());
            int eng = Integer.parseInt(stk.nextToken());
            int math = Integer.parseInt(stk.nextToken());

            StudentData sd = new StudentData(name, kor, eng, math);
            arr.add(sd);
        }

        Collections.sort(arr);

        for(int i=0; i<n; i++) {
            System.out.println(arr.get(i).name);
        }
    }
}

class StudentData implements Comparable<StudentData> {
    String name;
    int kor;
    int eng;
    int math;

    StudentData(String name, int kor, int eng, int math){
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    @Override
    public int compareTo(StudentData other) { 
        if (this.kor != other.kor) {
            return other.kor - this.kor;
        }
        else if (this.eng != other.eng) {
            return this.eng - other.eng;
        }
        else if (this.math != other.math) {
            return other.math - this.math;
        }
        else {
            return this.name.compareTo(other.name);
        }
    }
}