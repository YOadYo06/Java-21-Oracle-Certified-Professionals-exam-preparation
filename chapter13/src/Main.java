import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author YOadYo
 **/

class PlatformVsVirtual {
    static void waitUp() {
        try {
            Thread.sleep(1_000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class Zoo {
    public static void pause() { // Definethe thread task
        try {
                Thread.sleep(10_000); // Wait forseconds
            } catch (InterruptedException e) {

        }
        System.out.println("Thread finished!");
        }


    }


public class Main {

    private static int doWork(int input) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {}
        return input;
    }

    static void printHello(Lock myLock) {
        try {
            myLock.lock();
            System.out.println("Hello");
        } finally {
            myLock.unlock();
        } }

    private static int counter = 0;

    private int sheepCount = 0;
    //private AtomicInteger sheepCount = new AtomicInteger(0);
//    private void incrementAndReport() {
//        System.out.print(sheepCount.incrementAndGet() + " ");
//    }
    private void incrementAndReport() {
        synchronized (this) {
            System.out.print((++sheepCount) + " ");
        }
    }

    private void removeLions() { System.out.println("Removing lions"); }
        private void cleanPen() { System.out.println("Cleaning the pen"); }
            private void addLions() { System.out.println("Adding lions"); }
                public void performTask(CyclicBarrier c1, CyclicBarrier c2) {
                    try {
                        removeLions();
                        c1.await();
                        cleanPen();
                        c2.await();
                        addLions();
                    } catch (InterruptedException | BrokenBarrierException e) {
// Handle checked exceptions here
                    }
                }


    public static void main(String[] args) throws
            InterruptedException, Exception{

//        var threads = Stream.generate(() -> Thread.ofPlatform()
//                        .unstarted(PlatformVsVirtual::waitUp))
//                .limit(1_000_000)
//                .toList();
//        threads.forEach(Thread::start);
//        for (var t : threads)
//            t.join();

//        var thread1 = new Thread(() -> System.out.println("Super Important"));
//        thread1.setPriority(Thread.MAX_PRIORITY);
//        thread1.start();
//        var thread2 = new Thread(() -> System.out.println("Less Important"));
//        thread2.start();
//        thread2.setPriority(2);




//        Thread.ofPlatform().start(() -> System.out.print("Hello "));
//        System.out.print("World ");




//
//        Runnable printInventory =
//                () -> System.out.println("Printing zoo inventory");
//        Runnable printRecords = () -> {
//            for (int i = 0; i < 3; i++)
//                System.out.println("Printing record: " + i);
//            };
//        new Thread(printInventory).run();
//        new Thread(printInventory).run();
//
//        new Thread(printInventory).run();
//
//        new Thread(printInventory).run();
//
//        System.out.println("begin");
//        var platformThread = Thread.ofPlatform()
//        .priority(10)
//        .start(printInventory);
//        var virtualThread = Thread.ofVirtual()
//        .start(printRecords);
//        var constructorThread = new Thread(printInventory);
//        constructorThread.start();
//        System.out.println("end");
//        platformThread.join();
//        virtualThread.join();
//        constructorThread.join();




//        var job = Thread.ofPlatform().daemon(true).start(Zoo::pause);
//        System.out.println("Main method finished!");


//        var thread = Thread.ofPlatform().start(() -> {
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                System.out.println("Interrupted!");
//            }});
//        thread.interrupt();



//        var thread = Thread.ofPlatform().start(() -> {
//            while(true) {
//                if(Thread.interrupted())
//                    System.out.println("Someone interrupted us!");
//            }});
//        thread.interrupt();



//        Runnable printInventory =
//                () -> System.out.println("Printing zoo inventory");
//        Runnable printRecords = () -> {
//            for (int i = 0; i < 3; i++)
//                System.out.println("Printing record: " + i);
//            };
//
//        try (ExecutorService service = Executors.newSingleThreadExecutor()) {
//            System.out.println("begin");
//            service.execute(printInventory);
//            service.execute(printRecords);
//            service.execute(printInventory);
//            System.out.println("end");
//        }

//        try (var service = Executors.newSingleThreadExecutor()) {
//            Future<?> result = service.submit(() -> {
//                for (long i = 0; i < 1_000_000_000L; i++) counter++;
//            });
//            result.get(1, TimeUnit.SECONDS); // Returns null for Runnable
//            System.out.println("Reached!");
//        } catch (Exception e) {
//            System.out.println("Not reached in time");
//        }


//        try (var service = Executors.newSingleThreadExecutor()) {
//            Future<Integer> result = service.submit(() -> 30 + 11);
//            System.out.println(result.get()); // 41
//        }

//        var service = Executors.newSingleThreadExecutor();
//        service.submit(() -> System.out.println("Never stops"));


//        try (var service = Executors.newSingleThreadScheduledExecutor())
//        {
//            Runnable task1 = () -> System.out.println("Hello Zoo");
//            Callable<String> task2 = () -> "Monkey";
//            ScheduledFuture<?> r1 = service.schedule(task1, 10,
//                    TimeUnit.SECONDS);
//            ScheduledFuture<?> r2 = service.schedule(task2, 1,
//                    TimeUnit.MINUTES);
//        }


//        try (var service = Executors.newFixedThreadPool(20)) {
//            Main manager = new Main();
//            for (int i = 0; i < 10; i++)
//                service.submit(() ->
//                    manager.incrementAndReport());
//        }


//        try (var service = Executors.newFixedThreadPool(20)) {
//            var manager = new Main();
//            for (int i = 0; i < 10; i++)
//                service.submit(() -> manager.incrementAndReport());
//
//        }

//        var myLock = new ReentrantLock();
//        Thread.ofPlatform().start(() -> printHello(myLock));
//        if (myLock.tryLock()) {
//            try {
//                System.out.println("Lock obtained, entering protected code");
//            } finally {
//                myLock.unlock();
//            }
//        } else {
//            System.out.println("Unable to acquire lock, doing something else");
//        }

//        var lock = new ReentrantReadWriteLock();
//        lock.writeLock().lock();
//        lock.readLock().lock();
//        System.out.println(lock.isWriteLocked()); // true
//        System.out.println(lock.getReadLockCount()); // 1
//        lock.writeLock().unlock();
//        System.out.println(lock.isWriteLocked()); // false
//        System.out.println(lock.getReadLockCount()); // 1
//        lock.readLock().unlock();
//        System.out.println(lock.getReadLockCount()); // 0

//        var lock = new ReentrantReadWriteLock();
//        lock.readLock().lock();
//        lock.writeLock().lock(); // Wait forever


//        try (var service = Executors.newFixedThreadPool(4)) {
//            var manager = new Main();
//            var c1 = new CyclicBarrier(4);
//            var c2 = new CyclicBarrier(4,
//                    () -> System.out.println("*** Pen Cleaned!"));
//            for (int i = 0; i < 4; i++)
//                service.submit(() -> manager.performTask(c1,c2));
//        }

//        var foodData = new ConcurrentHashMap<String, Integer>();
//        foodData.put("penguin", 1);
//        foodData.put("flamingo", 2);
//        for (String key : foodData.keySet())
//            foodData.remove(key);


//        ThreadLocalRandom.current()
//                .ints()
//                .limit(5)
//                .forEach(System.out::println);

//        long start = System.currentTimeMillis();
//        List.of(1, 2, 3, 4, 5)
//        .parallelStream()
//        .map(w -> doWork(w))
//        .forEachOrdered(s -> System.out.print(s + " "));
//        System.out.println();
//        var timeTaken = (System.currentTimeMillis()-start)/1000;
//        System.out.println("Time: " + timeTaken + " seconds");

//        System.out.print(List.of(1, 2, 3, 4, 5, 6)
//                .parallelStream()
//                .findAny()
//                .get());

//        IntStream.range(1,100).parallel().sorted().forEach(System.out::println);


//        System.out.println(List.of('w', 'o', 'l', 'f','b','z','a','f')
//                .parallelStream()
//                .reduce("",
//                        (s1, c) -> s1 + c,
//                        (s2, s3) -> s2 + s3)); // wolf
//
//        System.out.println(List.of(1, 2, 3, 4, 5, 6)
//                .parallelStream()
//                .reduce(0, (a, b) -> (a - b))); // PROBLEMATIC ACCUMULATOR
//
//        System.out.println(List.of("w","o","l","f")
//                .parallelStream()
//                .reduce("X", String::concat)); // XwXoXlXf

//        Stream<String> stream = Stream.of("w", "o", "l", "f").parallel();
//        SortedSet<String> set =
//                stream.collect(ConcurrentSkipListSet::new,
//                        Set::add,
//                        Set::addAll);
//        System.out.println(set); // [f, l, o, w]


        Stream<String> ohMy = Stream.of("lions", "tigers",
                "bears").parallel();
        ConcurrentMap<Integer, String> map = ohMy
                .collect(Collectors.toConcurrentMap(String::length,
                        k -> k,
                        (s1, s2) -> s1 + "," + s2));
        System.out.println(map); // {5=lions,bears, 6=tigers}
        System.out.println(map.getClass()); // java.util.concurrent.ConcurrentHashMap

    }
}