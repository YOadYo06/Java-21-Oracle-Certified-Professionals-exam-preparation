/**
 * @author YOadYo
 **/
public class Egg {
    public Egg() {

    }
    public static void main(String[] args) {
        Egg egg = new Egg();
        System.out.println(egg.number1);
        System.out.println(egg.bool1);
        System.out.println(egg.bytes1);
        System.out.println(egg.shrt1);
        System.out.println(egg.lng1);
        System.out.println(egg.flt1);
        System.out.println(egg.dbl1);
        System.out.println(egg.chr1);
    }
    private int number;
    private boolean bool;
    private byte bytes = 1 ;
    private short shrt = 1;
    private long lng =Long.parseLong("3123456789");
    private float flt;
    private double dbl;
    private char chr;
    //double notAtStart = _1000.00; // DOES NOT COMPILE
    //double notAtEnd = 1000.00_; // DOES NOT COMPILE
    //double notByDecimal = 1000_.00; // DOES NOT COMPILE
    double annoyingButLegal = 1_00_0.0_0; // Ugly, but compiles
    //double reallyUgly = 1 2; // don't compiles

    private Integer number1 = Integer.valueOf("aF5",16);
    private Boolean bool1 = Boolean.valueOf("ka");
    private Byte bytes1 = Byte.valueOf((byte)1) ;
    private Short shrt1 = Short.valueOf((short) 1) ;
    private Long lng1 = Long.valueOf("3123456789");
    private Float flt1 = Float.valueOf((float)1.0);
    private Double dbl1 = Double.valueOf("201.8");
    private Character chr1 = null;
    {
        System.out.println(dbl1.byteValue());
        System.out.println(dbl1.intValue());
        System.out.println(dbl1.doubleValue());
    }
}
