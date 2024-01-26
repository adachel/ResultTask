package ResultTask;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        GenMenu genMenu = new GenMenu();
//        genMenu.runGenMenu();

        String file = "D:/Works/IT/Repository/Java/ResultTask/src/main/java/ResultTask/Database/database.txt";
        List<String> allLines = null;
        try {
            allLines = (Files.readAllLines(Paths.get(file)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(allLines.get(0));
        String[] temp = allLines.get(0).split(", ");
        System.out.println(temp[1]);

        for (int i = 0; i < allLines.size(); i++) {
            temp = allLines.get(0).split(", ");
            for (int j = 0; j < temp.length; j++) {
                if (temp[0].equals("[Dog") && temp[1].equals("qeqeewqe")){
                    allLines.remove(0);
                    try {
                        Files.writeString(Path.of(file), allLines.toString());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                }else {
                    System.out.println("no");
                }
            }
            break;
        }
        System.out.println(allLines);


//        for (String line : allLines) {
//
//                System.out.println(line);
//            }





    }
}