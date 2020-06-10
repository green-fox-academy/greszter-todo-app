
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ListBuilder {

    public static void addItem(String todoItem) {
        List<String> todo = new ArrayList<>();
        todo.add(todoItem);
        try {
            Path filePath = Paths.get("data.txt");
            Files.write(filePath, todo);
        } catch (IOException e) {
            System.out.println("Uh-oh, could not write the file!");
            System.exit(2);
        }
    }

    public static void printItems() {
        if (FileHandling.readFile("data.txt").size() == 0) {
            System.out.println("No todos for today! :)");
        } else
            for (int i = 0; i < FileHandling.readFile("data.txt").size(); i++) {
                System.out.println((i + 1) + " - " + FileHandling.readFile("data.txt").get(i));
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
        char check = 'x';
        String task = FileHandling.readFile("data.txt").get(itemNumber - 1);
        String checkedTask = check + task;

        FileHandling.readFile("data.txt").get(itemNumber - 1).replace(task, checkedTask);

        try {
            Files.write(Paths.get("data.txt"), FileHandling.readFile("data.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
