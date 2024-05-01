import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class BookAnalyzer {
    public Map<String, Integer> analyzeBook(File file) throws IOException {
        Map<String, Integer> wordFrequency = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {

                    word = word.replaceAll("[^a-zA-Z]", "").toLowerCase();
                    if (word.length() > 2) {
                        wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
                    }
                }
            }
        }
        return wordFrequency;
    }
}
