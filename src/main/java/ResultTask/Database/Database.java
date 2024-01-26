package ResultTask.Database;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Database {


    public Database() {
    }

    public void addDatabase(List<String> list){
        String fileName = "D:/Works/IT/Repository/Java/ResultTask/src/main/java/ResultTask/Database/database.txt";
        Path file = Path.of(fileName); // путь к файлу
        if (Files.notExists(file)) {
            try {
                Files.createFile(file); // создаем файл
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            Files.writeString(file, list.toString(), StandardOpenOption.APPEND); // записывает и дописывает строку
            Files.writeString(file, "\n", StandardOpenOption.APPEND); // записывает и дописывает строку
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void changeDatabase(){




    }


    public void readDatabase() {
        Path file = Path.of("D:\\Works\\IT\\Repository\\Java\\ResultTask\\src\\main\\java\\" +
                                 "ResultTask\\Database\\database.txt");
        String content;
        try {
            content = Files.readString(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(content);
    }


}
