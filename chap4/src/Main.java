/**
@author YOadYo
**/
public class Main {
    public static void main(String[] args) {

        var name = "animals";
        System.out.println(name.charAt(0)); // a
        System.out.println(name.charAt(6)); // s
        //System.out.println(name.charAt(7)); // exception

        var s = "Weâ€™re done feeding the animals";
        System.out.println(s.charAt(0) + " " + s.codePointAt(0)); // W

        System.out.println(s.charAt(2) + " " + s.codePointAt(2)); //

        System.out.println(s.codePointBefore(3)); //

        System.out.println(s.codePointCount(0,4)); // 4

        System.out.println(name.substring(3)); //

        System.out.println(name.substring(name.indexOf('m'))); //

        System.out.println(name.substring(3, 4)); // m
        System.out.println(name.substring(3, 7));

        System.out.println(name.substring(3, 3)); // empty string
        //System.out.println(name.substring(3, 2)); // exception
        //System.out.println(name.substring(3, 8)); // exception

        System.out.println(name.indexOf('a')); // 0
        System.out.println(name.indexOf("al")); // 4
        System.out.println(name.indexOf('a', 4)); // 4
        System.out.println(name.indexOf("al", 5)); // -1
        System.out.println(name.indexOf('a', 2, 4)); // -1
        System.out.println(name.indexOf("al", 2, 6)); // 4

        System.out.println("abc".equals("ABC")); // false
        System.out.println("ABC".equals("ABC")); // true
        System.out.println("ABC".equals(6)); // false
        System.out.println("abc".equalsIgnoreCase("ABC")); // true


        System.out.println("abc".startsWith("a")); // true
        System.out.println("abc".startsWith("A")); // false
        System.out.println("abc".startsWith("b", 1)); // true
        System.out.println("abc".startsWith("b", 2)); // false
        System.out.println("abc".endsWith("c")); // true
        System.out.println("abc".endsWith("a")); // false
        System.out.println("abc".contains("b")); // true
        System.out.println("abc".contains("B")); // false


        System.out.println("abcabc".replace('a', 'A')); // AbcAbc
        System.out.println("abcabc".replace("ab", "AAAA")); // AbcAbc

        System.out.println("abc".strip()); // abc
        System.out.println("\t a b c\n".strip()); // a b c
        String text = " abc\t ";
        System.out.println(text.trim().length()); // 3
        System.out.println(text.strip().length()); // 3
        System.out.println(text.stripLeading().length()); // 5
        System.out.println(text.stripTrailing().length()); // 4

        var block = """
                    a
                     b
                    c""";
        var concat =  " a\n"
                    + "  b\n"
                    + " c";
        System.out.println(block.length()); // 6
        System.out.println(concat.length()); // 9
        System.out.println(block.indent(1).length()); // 10
        System.out.println(concat.indent(-1).length()); // 7
        System.out.println(concat.indent(-4).length()); // 6
        System.out.println(concat.stripIndent().length()); // 6

        System.out.println(" ".isEmpty()); // false
        System.out.println("".isEmpty()); // true
        System.out.println(" ".isBlank()); // true
        System.out.println("".isBlank()); // true

        var name1 = "Kate";
        var orderId = 5;
// All print: Hello Kate, order 5 is ready
        System.out.println("Hello "+name1+", order "+orderId+" is ready");
                System.out.println(String.format("Hello %s, order %d is ready",
                        name1, orderId));
                String xyz = "Hello %s, order %d is ready";
                String xyz1 = "Hello %s, order %d is ready".formatted("Ziad", 5);
        System.out.println("Hello %s, %norder %d is ready"
                .formatted(name1, orderId));
        System.out.println(xyz
                .formatted(name1, orderId));
        System.out.println(xyz1);
        System.out.println(xyz);

        var pi = 3.14159265359;
        System.out.format("[%f]\n",pi); // [3.141593]
        System.out.format("[%12.8f]\n",pi); //[  3.14159265]
        System.out.format("[%012f]\n",pi); // [00003.141593]
        System.out.format("[%12.2f]\n",pi); // [ 3.14]
        System.out.format("[%.3f]",pi); // [3.142]

        StringBuilder sb1=new StringBuilder("a");
        StringBuilder sb2=new StringBuilder("a");
        System.out.println("\n"+sb1.equals(sb2));


        var first = "rat" + 1;
        var second = "r" + "a" + "t" + "1";
        var third = "r" + "a" + "t" + new String("1");
        System.out.println("\n");
        System.out.println(first == second);
        System.out.println(first == second.intern());
        System.out.println(first == third);
        System.out.println(first == third.intern());


        int[] moreNumbers = new int[] {42, 55, 99};
        int[] moreNumbers1 = {42, 55, 99};
        
        int[] numAnimals;
        int [] numAnimals2;
        int []numAnimals3;
        int numAnimals4[];
        int numAnimals5 [];


    }

}
