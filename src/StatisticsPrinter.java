import java.util.Map;

public class StatisticsPrinter {
    public static void printStatistics(Map<String, Integer> wordFrequency) {
        System.out.println("Statistic:");
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        System.out.println("Total words: " + wordFrequency.size());
    }
}
