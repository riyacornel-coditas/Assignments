import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class Week4_test {


    record Order(int id, String customerName, double amount, String type) {
        double getDiscountedAmount() {
            double total=amount;
            double amt=0.0;
            amt= switch (type) {
                case "ONLINE" -> amount * 0.1; // 10% discount
                case "OFFLINE" -> amount * 0.05; // 5% discount
                default -> amount;
            };
            total-=amt;
            return total;
        }
    }

    private static void runTest(ExecutorService executor, String type) throws InterruptedException {
        long start = System.currentTimeMillis();

        for (int i = 0; i < 100; i++) {
            executor.submit(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES); //waits for 1 minute for all tasks to shutdown
        long end = System.currentTimeMillis();
        System.out.println(type + " Threads took: " + (end - start) + " ms\n");
    }

    static void analyzeResults() {
        System.out.println("Student Result Analyzer");
        List<Integer> marks = new ArrayList<>(List.of(85, 92, 45, 78, 99, 60));

        List<Integer> sortedMarks = marks.stream().sorted().toList();

        System.out.println("Lowest: " + sortedMarks.getFirst());
        System.out.println("Topper: " + sortedMarks.getLast());
        System.out.println("Reverse Order: " + sortedMarks.reversed());
    }


    static void logMessage(String user, String status) {
        System.out.println("Log Output");
        String log = """
            Application Log
            User: %s
            Status: %s
            """.formatted(user, status);
        System.out.print(log);
    }

    public static void main(String[] args) throws InterruptedException {

        List<Order> orders = List.of(
                new Order(1, "Alice", 5000, "ONLINE"),
                new Order(2, "Bob", 2000, "OFFLINE"),
                new Order(3, "Charlie", 10000, "ONLINE")
        );

        double totalRevenue = orders.stream()
                .mapToDouble(Order::getDiscountedAmount)
                .sum();
        System.out.println("Total R: " + totalRevenue);

        List<Order> premiumOrders = orders.stream()
                .filter(o -> o.amount() > 5000)
                .toList();
        System.out.println("Premium Orders: " + premiumOrders);

        System.out.println("\n");

        System.out.println("Starting Platform Threads");
        runTest(Executors.newFixedThreadPool(100), "Platform"); // Fixed pool

        System.out.println("Starting Virtual Threads");
        runTest(Executors.newVirtualThreadPerTaskExecutor(), "Virtual"); //Virtual threads

        System.out.println("\n");

        analyzeResults();

        System.out.println("\n");

        logMessage("Admin", "SUCCESS");
    }

}
