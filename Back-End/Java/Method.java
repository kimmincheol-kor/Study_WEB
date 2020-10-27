public class Method {

    public int sum(int a, int b) {
        return a+b;
    }

    public static void main(String[] args) {
        int a = 3;
        int b = 4;

        Method newMethod = new Method();
        int c = newMethod.sum(a, b);

        System.out.println(c);
    }
}