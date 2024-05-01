import javax.imageio.IIOException;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class TextAnalyzer {
    public void run(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the book name: ");
        String bookName = scanner.nextLine();
        String filePath = "src/" + bookName + ".txt";

        BookAnalyzer bookAnalyzer = new BookAnalyzer();
        File file = new File(filePath);
        if (!file.exists()){
            System.out.println("Book not found :(");
            return;
        }

        try {
            Map<String, Integer> wordFrequency = bookAnalyzer.analyzeBook(file);
            StatisticsWriter.writeStatisticsToFile(bookName, wordFrequency);
            StatisticsPrinter.printStatistics(wordFrequency);
        } catch (IIOException e){
            System.out.println("Error reading/writing file: " + e.getMessage()) ;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
