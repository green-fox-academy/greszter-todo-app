import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ListBuilder {

  public static void addItem(String todoItem) {
    try {
      todoItem = "[ ] " + todoItem + "\r\n";
      FileWriter writer = new FileWriter("data.txt", true);
      BufferedWriter out = new BufferedWriter(writer);
      out.write(todoItem);
      out.close();
    } catch (IOException e) {
      System.out.println("Uh-oh, could not write the file!");
      System.exit(2);
    }
  }

  public static void printItems() {
      if (FileHandling.readFile("data.txt").size() == 0) {
          System.out.println("No todos for today! :)");
      } else {
          for (int i = 0; i < FileHandling.readFile("data.txt").size(); i++) {
              System.out.println((i + 1) + " - " + FileHandling.readFile("data.txt").get(i));
          }
      }
  }

  public static void removeFromList(int itemNumber) {
    List<String> newFile = new ArrayList<>();
    newFile = FileHandling.readFile("data.txt");
    newFile.remove(itemNumber - 1);

    try {
      Files.write(Paths.get("data.txt"), newFile);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void checkItem(int itemNumber) {
    List<String> newList = new ArrayList<>();
    String checkedItem =
        FileHandling.readFile("data.txt").get(itemNumber - 1).replace("[ ]", "[x]");
    for (int i = 0; i < FileHandling.readFile("data.txt").size(); i++) {
      if (i == itemNumber - 1) {
        newList.add(checkedItem);
      } else {
        newList.add(FileHandling.readFile("data.txt").get(i));
      }
    }
    try {
      Files.write(Paths.get("data.txt"), newList);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
