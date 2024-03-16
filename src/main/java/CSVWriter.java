import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVWriter {

    public void writeToCSV(String fileName, List<String> lines) throws IOException {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.append("Token,Type\n");
            for (String line : lines) {
                writer.append(line).append("\n");
            }
        }
    }
}