import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileInputSource implements InputSource {
    private final String filePath;

    public FileInputSource(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String getInput() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.isEmpty()) {
                    return line.trim();
                }
            }
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
        }
        return "";
    }
}
