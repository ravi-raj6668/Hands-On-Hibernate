package test;

public class OnlyTest {
    public int z = 11;
    public static double x = 11.11;

    public static void main(String[] args) {
        OnlyTest ot = new OnlyTest();
        System.out.println(" Non static data member : " + ot.z);

        System.out.println("Static data member : " + ot.x);

        System.out.println("static data member : " + OnlyTest.x);
    }

}
