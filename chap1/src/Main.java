/**
 * @author YOadYo
 **/


import java.util.Date;
import java.sql.*;

public class Main {
    { System.out.println("Snowy"); }
    public Main(){
        System.out.println("constructor");
    }
    public static int i =0;
    public static void main(String... args) {


/*        Main m = new Main();
        if(i==0){System.out.println("ddd");i++;}
        else System.out.println("Hello, World! "+ args[0]);*/

        //m.main("youness");
        String eye="\"Java Study Guide\"\n   by Jeanne & Scott";
        System.out.println(eye);

        String textBlock = """
                    "Java Study Guide"
                        by Jeanne & Scott""";
        System.out.println(textBlock);

        String pyramid = """
          *
         * *
        * * *\""" \
        \sb """;
        System.out.print(pyramid);

        //String block = """doe"""; // DOES NOT COMPILE


        long okidentifier;
        float $OK2Identifier;
        boolean _alsoOK1d3ntifi3r;
        char __SStillOkbutKnotsonice$;

        //int 3DPointClass; // identifiers cannot begin with a number
        //byte hollywood@vine; // @ is not a letter, digit, $ or _
        //String *$coffee; // first character * is not a letter, $ or _
        //double public; // public is a reserved word
        //short _; // a single underscore is not allowed

        String s1, s2;
        String s3 = "yes", s4 = "no";
        String s5=" ",s6;

        String[] argas;
        String options[];

        Date date1;
        java.util.Date date;
        java.sql.Date sqlDate;
    }
}



class Main2{
    public void checkAnswer() {
        boolean value;// No Def Value
        //findAnswer(value); // DOES NOT COMPILE
    }
    public void findAnswer(boolean check) {}

}

class Zoo {
    //var tricky1 = "sqdsd";

    public void whatTypeAmI() {
        var name = "Hello";
        var size = 7;
        var tricky = "sqdsd";
    }
    public void doesThisCompile(boolean check) {
        //var question;
        //question = 1;
        //var answer;
        if (check) {
            //answer = 2;
            } else {
            //answer = 3;
            }
        //System.out.println(answer);
    }

//    public int addition(var a, var b) { // DOES NOT COMPILE
//        return a + b;
//    }

}


