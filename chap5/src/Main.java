import java.util.Arrays;

/**
@author YOadYo
**/public class Main {

    public void climb(Long t){}
    public void swing(Integer u){}
    public void jump(long v){}

    public void fly(int numMiles){
        System.out.println("int");
    }
    public void fly(short numFeet){
        System.out.println("short");
    }

    public void fly1(String s){
        System.out.print("string");
    }

    public static void fly2(int... arg){
        System.out.println("1param");

    }

    public void fly1(Object o){
        System.out.print("object");
    }

    //public static void walk(Integer[] integers){}
    public static void walk(int... integers){}

    public static void main(String[] args) {

        fly2(5);

        //walk(new int[] {1,2,5});
        walk(1,2,5);

        int l = 5;

        Integer[] ar = {1,2,3,l};

        System.out.println(Arrays.toString(ar));

        var c = new Main();

        c.fly1(4);
        System.out.print("-");
        c.fly1("d");
        System.out.println();

        c.fly((byte)5);
        c.fly((int)5);

        c.climb((long)123);
        c.swing(123);
        //c.swing(Short.valueOf((short) 5));
        c.jump((int)123L);
        c.jump(Long.valueOf(5));

        Double a = 4.0;


        c.jump(Integer.valueOf(123));

        Integer x = 8;
        int y = x;

        Long x4 = 8L;
//        Long x5 = x;
//        Long x6 = 8;

        long y4 = x4;
        long y5 = x;
        long y6 = 8;

        Long x5 = y5;
        Long x6 = y6;

        Short x1 = 8;
        short y1 = x1;
        int yy1 = x1;
        byte yyy1 = (byte)(short)x1;

        Byte x2 = 8;
        Boolean x3 = true;

        //Character hahah = null;
        //char jajaj = hahah;

        System.out.println("Hello, World!");
    }
}