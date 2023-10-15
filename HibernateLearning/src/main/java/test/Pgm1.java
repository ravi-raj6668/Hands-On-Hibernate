package test;

public class Pgm1 {
    private static int val = 10;
    static {
        System.out.println("Static block executed");
    }

    public static void print() {
        System.out.println("Static print method executed");
    }

    public void show() {
        System.out.println("Non-static show method executed");
    }

    {
        System.out.println("Non static block executed");
    }

    public Pgm1(){
        val++;
    }

    public static void main(String[] args) {
        System.out.println(Pgm1.val);

        new Pgm1();

        Pgm1.print();
        System.out.println(Pgm1.val);
    }
}
