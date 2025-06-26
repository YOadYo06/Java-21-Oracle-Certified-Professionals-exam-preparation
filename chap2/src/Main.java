/**
 * @author YOadYo
 **/
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        int cookies = 4;
        short x = 20_000;//20_000 is short
        double reward = 3.0 + 2L + 3;
        float reward1 = 3.0f + 2L + 3;
        //long reptile = (long)192301398193810323; // DOES NOT COMPILE
        long reptile = 192301398193810323L;
        byte b =(byte) -180;
        System.out.print("Zoo animal receives: "+reward+" rewardpoints\n");
        Integer zooTime = Integer.valueOf(9);
        System.out.println(zooTime instanceof Integer);
        System.out.println(zooTime instanceof Number);
        System.out.println(zooTime instanceof Object);
        System.out.println(null instanceof Object);
        //System.out.println(zooTime instanceof Short);
        //System.out.println(zooTime instanceof String);
        int number = 70;
        System.out.println("number :"+number); // 70
        System.out.println("number & number :"+ (number & number)); // 70
        System.out.println("number | number :" + (number | number)); // 70

        int negated = ~number;
        System.out.println("negated :"+negated); // -71
        System.out.println("number & negated :"+(number & negated)); // 0
        System.out.println("number | negated :"+(number | negated)); // -1

        System.out.println("number ^ number :"+(number ^ number)); // 0
        System.out.println("number ^ negated :"+(number ^ negated)); // -1

        number=5;
        System.out.println(false|| 5>(number=6));
        //System.out.println(false|| 5>=(++number));

        System.out.println("number: " + number);


    }
}