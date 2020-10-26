import java.util.ArrayList;
import java.util.HashMap;

public class JavaDataType {
    public static void main(String[] args) {
        // 1. Number
        int age = 25;
        long accout = 123456789;

        float avg1 = 12.56f;
        double avg2 = 12.24141;

        // 2. Bool
        boolean b1 = true;
        boolean b2 = false;

        System.out.println(2 > 1); // true
        System.out.println(2 <= 1); // false
        System.out.println(1 == 1); // true

        // 3. Char
        char ch = 'a';
        char asc = 97;
        char uni = '\u0061';

        System.out.println(ch);  // a
        System.out.println(asc); // a
        System.out.println(uni); // a

        // 4. String (Not Primitive)
        String str1 = "Happy Java"; // Good
        String str2 = new String("Happy Java"); // Bad

        System.out.println(str1.equals(str2)); // true
        System.out.println(str1 == str2); // false

        System.out.println(str1.indexOf("H")); // 0
        System.out.println(str1.replaceAll("Java", "Kmc")); // Happy Kmc
        System.out.println(str1.substring(0,3)); // Hap
        System.out.println(str1.toUpperCase()); // HAPPY JAVA
        
        // 5. StringBuffer
        StringBuffer sb = new StringBuffer(); // New StringBuffer Object (mutable)
        sb.append("Hi"); // Update
        sb.append(" "); // Update
        sb.append("Java"); // Update
        System.out.println(sb); // (StringBuffer)Hi Java
        System.out.println(sb.toString()); // (String)Hi Java

        String likeBuffer = "";  // New String Object (immutable) ""
        likeBuffer += "Hi"; // New String Object "Hi"
        likeBuffer += " "; // New String Object "Hi "
        likeBuffer += "Java"; // New String Object "Hi Java"

        // 6. Array
        int[] odds = {1, 3, 5, 7, 9};

        String[] weeks = new String[7];
        weeks[0] = "mon";
        weeks[1] = "tue";
        weeks[2] = "wed";
        weeks[3] = "thu";
        weeks[4] = "fri";
        weeks[5] = "sat";
        weeks[6] = "sun";

        for (int i=0; i<weeks.length; i++) {
            System.out.println(weeks[i]);
        }

        // 7. List
        ArrayList<String> pitches = new ArrayList<String>();
        pitches.add("138");
        pitches.add("129");
        pitches.add("142");

        System.out.println(pitches); // [138, 129, 142]

        pitches.add(0, "1");
        System.out.println(pitches); // [1, 138, 129, 142]

        System.out.println(pitches.get(1)); // 138
        System.out.println(pitches.size()); // 4
        System.out.println(pitches.contains("142")); // true
        System.out.println(pitches.remove("129")); // value => true
        System.out.println(pitches.remove(0)); // index => 1

        // 8. Generic
        ArrayList<String> test1 = new ArrayList<String>(); // Generic = <String> : Only Using String Type
        // No Generic => <Object> Type (Need Casting)
        // <String> Generic => <String> Type

        // 9. Map (Dictionary = Key:Value)
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("name", "kmc");
        map.put("job", "dev");

        System.out.println(map); // {name=kmc, job=dev}

        System.out.println(map.size()); // 2
        System.out.println(map.get("name")); // kmc
        System.out.println(map.containsKey("name")); // true
        System.out.println(map.remove("name")); // kmc
        System.out.println(map); // {job=dev}
        System.out.println(map.containsKey("name")); // false
    }
}
