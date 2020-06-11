import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileHandling {

  public static List<String> readFile(String fileName) {
    List<String> lines = new ArrayList<>();
    try {
      Path filePath = Paths.get(fileName);
      lines = Files.readAllLines(filePath);
    } catch (IOException e) {
      System.out.println("The file does not exist");
      System.exit(2);
    }
    return lines;
  }

  public static void printLines(String filename) {
    List<String> lines = readFile(filename);
    for (String line : lines) {
      System.out.println(line);
    }
  }
}
