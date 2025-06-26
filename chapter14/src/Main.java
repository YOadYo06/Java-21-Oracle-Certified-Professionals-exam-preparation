import java.io.*;
import java.net.URI;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

/**
 * @author YOadYo
 **/
public class Main implements Serializable {
    transient String name;
    transient int num;
    transient boolean bbb;

    {
        name="def";num=5;bbb=true;
    }

    Main(String name, int num, boolean bbb){
        this.name=name;
        this.num=num;
        this.bbb=bbb;
    }

    public void io(File file) {
        if (file.exists()) {
            System.out.println("Absolute Path: " +
                    file.getAbsolutePath());
            System.out.println("Is Directory: " +
                    file.isDirectory());
            System.out.println("Parent Path: " +
                    file.getParent());
            if (file.isFile()) {
                System.out.println("Size: " + file.length());
                System.out.println("Last Modified: " +
                        file.lastModified());
            } else {
                for (File subfile : file.listFiles()) {
                    System.out.println(" " + subfile.getName());
                }
            }
        }
    }

    public void nio(Path path) throws IOException {
        if (Files.exists(path)) {
            System.out.println("Absolute Path: " +
                    path.toAbsolutePath());
            System.out.println("Is Directory: " +
                    Files.isDirectory(path));
            System.out.println("Parent Path: " +
                    path.getParent());
            if (Files.isRegularFile(path)) {
                System.out.println("Size: " + Files.size(path));
                System.out.println("Last Modified: "
                        + Files.getLastModifiedTime(path));
            } else {
                try (Stream<Path> stream = Files.list(path)) {
                    stream.forEach(p ->
                            System.out.println(" " +
                            p.getFileName()));
                }
            }
        }
    }

    public void printPathInformation(Path path) {
        System.out.println("Filename is: " + path.getFileName());
        System.out.println(" Root is: " + path.getRoot());
        Path currentParent = path;
        while((currentParent = currentParent.getParent()) != null)
            System.out.println(" Current parent is: " +
                    currentParent);
        System.out.println();
    }

    public void copyPath(Path source, Path target) {
        try {
            Files.copy(source, target,
                    StandardCopyOption.REPLACE_EXISTING);
            if(Files.isDirectory(source))
                try (Stream<Path> s = Files.list(source)) {
                    s.forEach(p -> copyPath(p,
                            target.resolve(p.getFileName())));
                }
        } catch(IOException e) {
// Handle exception
        }
    }

    void copyBinaryFile(File src, File dest) throws IOException {
        try (
                var in = new BufferedInputStream(new FileInputStream(src));
                var out = new BufferedOutputStream(new FileOutputStream(dest))
        ) {
            byte[] buffer = new byte[1024];  // 1KB batch
            int lengthRead;
            while ((lengthRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, lengthRead);
            }
            out.flush(); // flush remaining data from buffer
        }
    }


//    void copyTextFile(File src, File dest) throws IOException {
//        try (var reader = new BufferedReader(new FileReader(src));
//            var writer = new BufferedWriter(new FileWriter(dest)))
//        {
//            String line = null;
//            while ((line = reader.readLine()) != null) {
//                writer.write(line);
//                writer.newLine();
//            }
//        }
//    }

    void copyTextFile(File src, File dest) throws IOException {
        try (var reader = new BufferedReader(new FileReader(src));
             var writer = new PrintWriter(new FileWriter(dest))) {
            String line = null;
            while ((line = reader.readLine()) != null)
                writer.println(line);
        }
    }

    private void copyPathAsString(Path input, Path output) throws
            IOException {
        String string = Files.readString(input);
        Files.writeString(output, string);
    }
    private void copyPathAsBytes(Path input, Path output) throws
            IOException {
        byte[] bytes = Files.readAllBytes(input);
        Files.write(output, bytes);
    }
    private void copyPathAsLines(Path input, Path output) throws
            IOException {
        List<String> lines = Files.readAllLines(input);
        Files.write(output, lines);
    }

    static void saveToFile(List<Main> gorillas, File dataFile)
            throws IOException {
        try (var out = new ObjectOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(dataFile)))) {
            for (Main gorilla : gorillas)
                out.writeObject(gorilla);
        }
    }

    static List<Main> readFromFile(File dataFile) throws IOException,
            ClassNotFoundException {
        var gorillas = new ArrayList<Main>();
        try (var in = new ObjectInputStream(
                new BufferedInputStream(new
                        FileInputStream(dataFile)))) {
            while (true) {
                var object = in.readObject();
                if (object instanceof Main g)
                    gorillas.add(g);
            }
        } catch (EOFException e) {
// File end reached
        }
        return gorillas;
    }

    @Override
    public String toString(){
        return ""+this.name+" + "+this.num+" + "+this.bbb+"\n";
    }

    public static void main(String[] args) throws IOException,ClassNotFoundException {
//        File zooFile1 = new File("/home/tiger/data/stripes.txt");
//        File zooFile2 = new File("/home/tiger", "data/stripes.txt");
//        File parent = new File("/home/tiger");
//        File zooFile3 = new File(parent, "data/stripes.txt");
//        System.out.println(zooFile1.exists());

//        Path zooPath1 = Paths.get("/home", "tiger", "data",
//                "stripes.txt");
//
//        Path zooPath2 =
//                FileSystems.getDefault().getPath("/home/tiger/data/stripes.t xt");
//
//
//        Path zooPath3 =
//                Path.of(URI.create("https://www.selikoff.net"));

//        File file = new File("rabbit");
//        Path newPath = file.toPath();
//        File backToFile = newPath.toFile();
        var main = new Main("hhh",3,true);

//        System.out.println("File");
//        main.io(Path.of("D:/JAVA/OCPExamPrep/chapter14/src/Main.java").toFile());
//        System.out.println("\n\nDir");
//        main.io(Path.of("D:/JAVA/OCPExamPrep/chapter14").toFile());
//
//        System.out.println("Path");
//        main.nio(Path.of("D:/JAVA/OCPExamPrep/chapter14/src/Main.java"));
//        System.out.println("\n\nDir");
//        main.nio(Path.of("D:/JAVA/OCPExamPrep/chapter14"));


//        Path path = Path.of("D:/JAVA/OCPExamPrep/chapter14/chapter14.iml");
//        boolean exists = Files.exists(path, LinkOption.NOFOLLOW_LINKS);
//        System.out.println(exists);

//        Path p = Path.of("whale");
//        p.resolve("krill");
//        System.out.println(p); // whale


        //System.out.println(Path.of("/zoo/../home").getParent().normalize().toAbsolutePath());

//        Path path = Path.of("/land/hippo/harry.happy");
//        System.out.println("The Path is: " + path);
//        for(int i=0; i<path.getNameCount(); i++)
//            System.out.println(" Element " + i + " is: " +
//                    path.getName(i));


        //var p = Path.of("/");
        //System.out.print(p.getNameCount()); // 0
        //System.out.print(p.getName(0)); // IllegalArgumentException

//        var p = Path.of("/mammal/omnivore/raccoon.image");
//        System.out.println("Path is: " + p);
//        for (int i = 0; i < p.getNameCount(); i++) {
//            System.out.println(" Element " + i + " is: " +
//                    p.getName(i));
//        }
//        System.out.println();
//        System.out.println("subpath(0,3): " + p.subpath(0, 3));
//        System.out.println("subpath(1,2): " + p.subpath(1, 2));
//        System.out.println("subpath(1,3): " + p.subpath(1, 3));

//        var q = p.subpath(0, 4); // IllegalArgumentException
//        var x = p.subpath(1, 1); // IllegalArgumentException

//        main.printPathInformation(Path.of("zoo"));
//        main.printPathInformation(Path.of("/zoo/armadillo/shells.txt"));
//        main.printPathInformation(Path.of("./armadillo/../shells.txt"));


//        Path path1 = Path.of("/cats/../panther");
//        Path path2 = Path.of("food");
//        System.out.println(path1.resolve(path2));
//
//
//        Path path3 = Path.of("/turkey/food");
//        System.out.println(path3.resolve("/tiger/cage"));


//        var path1 = Path.of("fish.txt");
//        var path2 = Path.of("friendly/birds.txt");
//        var path3 = Path.of("a/friendy/birs.txt");
//        System.out.println(path1.relativize(path3));
//        System.out.println(path3.relativize(path1));
//        System.out.println(path1.relativize(path2));
//        System.out.println(path2.relativize(path1));

//        var p1 = Path.of("/pony/../weather.txt");
//        var p2 = Path.of("/weather.txt");
//        System.out.println(p1.equals(p2)); // false
//        System.out.println(p1.normalize().equals(p2.normalize())); // true

//        System.out.println("Working directory: " + Path.of("").toAbsolutePath());
//        System.out.println(Path.of("chapter14.iml").toRealPath());
//        System.out.println(Path.of(".././chapter14/chapter14.iml").toRealPath());

//        System.out.println("Working directory: " + Path.of("").toAbsolutePath());
//        //Files.createDirectory(Path.of("/bison/field/pasture/green/YOadYo"));
//        Files.createDirectories(Path.of("/bison/field/pasture/green/YOadYo/hhh"));

//        System.out.println("Working directory: " + Path.of("").toAbsolutePath());
//        //Files.copy(Path.of("D:/JAVA/OCPExamPrep/chapter14"+"/chapter14.iml"), Path.of("D:/JAVA/OCPExamPrep/chapter14"+"/src/chapter14.iml"));
//        //Files.copy(Path.of("D:/JAVA/OCPExamPrep/chapter14/src"), Path.of("D:/JAVA/OCPExamPrep/chapter14/out/src"));
//        main.copyPath(Path.of("D:/JAVA/OCPExamPrep/chapter14/src"), Path.of("D:/JAVA/OCPExamPrep/chapter14/out/src"));
//        //Files.copy(Path.of("/turtle"), Path.of("/turtleCopy"));

//        try (var is = new FileInputStream("chapter14.iml")) {
//// Write I/O stream data to a file
//            Files.copy(is, Path.of("D:/JAVA/OCPExamPrep/chapter14/src/chapte.txt"),
//                    StandardCopyOption.REPLACE_EXISTING);
//        }
//        Files.copy(Path.of("D:/JAVA/OCPExamPrep/chapter14/src/chapte.txt"), System.out);

//        Files.delete(Path.of("D:/JAVA/OCPExamPrep/chapter14/src/chapter14.iml"));
//        Files.deleteIfExists(Path.of("/pigeon"));

//        System.out.println(Files.mismatch(
//                Path.of("D:/JAVA/OCPExamPrep/chapter14/src/file.txt"),
//                Path.of("D:/JAVA/OCPExamPrep/chapter14/src/file1.txt")));

//        try (var br = new BufferedReader(new FileReader("chapter14.iml"))) {
//                System.out.println(br.readLine());
//                System.out.println(br.readLine());
//                System.out.println(br.readLine());
//        }
//
//        try (var ois = new ObjectInputStream(
//                new BufferedInputStream(
//                        new FileInputStream("zoo-data.ser")))) {
//            System.out.print(ois.readObject());
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }


//        System.getProperty("line.separator");
//        System.lineSeparator();
//
//        System.out.print("*");
//        System.out.print(System.getProperty("line.separator").toString());
//        System.out.print("*");
//        System.out.print(System.lineSeparator().toString());
//        System.out.print("*");


//        var gorillas = new ArrayList<Main>();
//        gorillas.add(new Main("mohammed", 5, false));
//        gorillas.add(new Main("Ismael", 8, true));
//        File dataFile = new File("gorilla.ser");
//        Main.saveToFile(gorillas, dataFile);
//        var gorillasFromDisk = Main.readFromFile(dataFile);
//        System.out.print(gorillasFromDisk);

//        try (var in = new FileInputStream("zoo.txt")) {
//            System.out.println("Found file!");
//        } catch (FileNotFoundException e) {
//            System.err.println("File not found!");
//        }


//        var reader = new BufferedReader(new
//                InputStreamReader(System.in));
//        String userInput = reader.readLine();
//        System.out.println("You entered: " + userInput);

//        try (var out = System.out) {}
//        System.out.println("Hello");
//
//        try (var err = System.err) {}
//        System.err.println("Hello");

        //Console console = System.console();
//        if (console != null) {
//            String userInput = console.readLine();
//            console.writer().println("You entered: " + userInput);
//            console.flush();
//        } else {
//            System.err.println("Console not available");
//        }

//        if (console == null) {
//            throw new RuntimeException("Console not available");
//        } else {
//            console.writer().println("Welcome to Our Zoo!");
//            console.format("It has %d animals and employs %d people",
//                    391, 25);
//            console.writer().println();
//            console.printf("The zoo spans %5.1f acres", 128.91);
//            console.flush();
//        }



//        Console console = System.console();
//        if (console == null) {
//            throw new RuntimeException("Console not available");
//        } else {
//            String name = console.readLine("Please enter your name: ");
//            console.writer().format("Hi %s", name);
//            console.writer().println();
//            console.format("What is your address? ");
//            String address = console.readLine();
//            char[] password = console.readPassword("Enter a password "
//                    + "between %d and %d characters: ", 5, 10);
//            char[] verify = console.readPassword("Enter the password again: ");
//            console.printf("Passwords "
//                            + (Arrays.equals(password, verify) ? "match" : "do not match"));
//                    console.flush();
//        }

//        var logger = Logger.getLogger("errors");
//        logger.info("Code is running");
//        logger.warning("Code shouldn't have done that");
//        logger.log(Level.SEVERE, "You should worry");

//        var path = Path.of("chapter14.iml");
//        BasicFileAttributes data = Files.readAttributes(path,
//                BasicFileAttributes.class);
//        System.out.println("Is a directory? " + data.isDirectory());
//        System.out.println("Is a regular file? " +
//                data.isRegularFile());
//        System.out.println("Is a symbolic link? " +
//                data.isSymbolicLink());
//        System.out.println("Size (in bytes): " + data.size());
//        System.out.println("Last modified: " +
//                data.lastModifiedTime());

        var path = Path.of("chapter14.iml");
        BasicFileAttributeView view = Files.getFileAttributeView(path,
                BasicFileAttributeView.class);
        BasicFileAttributes attributes = view.readAttributes();
// Modify file last modified time
        FileTime lastModifiedTime = FileTime.fromMillis(
                attributes.lastModifiedTime().toMillis() + 10_000);//2025-06-20T11:40:39.8210091Z origin
        view.setTimes(lastModifiedTime, null, null);



    }
}