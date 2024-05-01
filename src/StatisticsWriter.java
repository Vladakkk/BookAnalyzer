import javax.imageio.IIOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class StatisticsWriter {
    public static void writeStatisticsToFile(String bookName, Map<String, Integer> wordFrequency) throws IIOException {
        String outputFileName = bookName + "_statistic.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
            for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
                writer.write(entry.getKey() + " -> " + entry.getValue());
                writer.newLine();
            }
            writer.write("Total words: " + wordFrequency.size());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
