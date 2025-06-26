/**
 * @author YOadYo
 **/
public class Main {

//    void printDetails(Number height) {
//        String message = switch (height) {
//            case Number n -> "Unknown: " + n;
//            case Integer i -> "Rounded: " + i;
//            case Double d -> "Precise: " + d;
//        };
//        System.out.print(message);
//    }

//    public static void compareIntegers(Number number) {
//        if (number instanceof Integer) {
//            Integer data = (Integer)number;
//            System.out.println(data.compareTo(5));
//        }
//    }

//    public static void compareIntegers(Number number) {
//        if (number instanceof final Integer data || data.compareTo(7)>0) {
//            //data=100;
//            System.out.println(data.compareTo(5));
//        }
//    }

    public static void compareIntegers(Number number) {
        if (number instanceof final Integer data && data.compareTo(7)>0) {
            //data=100;
            System.out.println(data.compareTo(5));
        }
    }

    static void printOnlyIntegers(Number number) {
        if (!(number instanceof Integer data))
            return;
        System.out.print(data.intValue());
    }

    public static void main(String[] args) {

        System.out.println("Hello, World!");
        var x=Integer.valueOf(4);
        compareIntegers(x);

        switch(x){
            case 4 -> System.out.println("4");
            default -> System.out.println("def");
        }

        var y =switch (x){
            case 6 -> "sdsd";
            default -> 1;
        };


        int food = 5, month = 4, weather = 2, day = 0, time = 10;

//        String meal = switch food { // #1
//            case 1 -> "Dessert"
//            default -> "Porridge"
//        };

//        switch (month) // #2
//        case 4: System.out.print("January");

        switch (weather) { // #3
            case 2:
                System.out.print("Rainy");
                System.out.print("Rainy");
                break;
            case 5: {
                System.out.print("Sunny");
            }
        }

//        switch (day) { // #4
//            case 1: 13: System.out.print("January");
//            default System.out.print("July");
//        }

        String description = switch (time) { // #5
            case 10 -> "Morning";
            default -> "Late";
        };
        int hhh = Integer.valueOf(4);
        System.out.println(description);
        System.out.println(hhh);

        enum Season { SPRING, SUMMER, FALL, WINTER }
        Season value = Season.SPRING;
        String s = switch (value) { // DOES NOT COMPILE
            case WINTER -> "Cold";
            case FALL -> "Fall";
            case SPRING -> "Rainy";
            case SUMMER -> "Hot";
            default -> throw new RuntimeException("Unsupported Season");
        };



    }
}