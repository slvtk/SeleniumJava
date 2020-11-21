import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class TaskDataGenerator {
    private static final String DATA_FOR_RANDOM_STRING = "abcdefghijklmnopqrstuvw";
    private static final SecureRandom random = new SecureRandom();

    public static void main(String[] args) throws IOException {
        String type = args[0];
        int count = Integer.parseInt(args[1]);
        String filename = args[2];
        String format = args[3];

        if (type.equals("g")) {
            generateData(count, filename, format);
        } else {
            System.out.println("Error");
        }
    }

    static void generateData(int count, String filename, String format) throws IOException {
        List<TaskData> data = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            data.add(new TaskData(
                            generateRandomString(4),
                            generateRandomString(4)
                    )
            );
        }
        FileWriter fileWriter = new FileWriter(filename + "." + format);
        for (TaskData taskData :
                data) {
            Gson gson = new Gson();
            fileWriter.append(gson.toJson(taskData)).append("\n");
        }
        fileWriter.close();
    }

    //Генерим рандомные строки
    static String generateRandomString(int length) {
        if (length < 1) throw new IllegalArgumentException();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(DATA_FOR_RANDOM_STRING.charAt(random.nextInt(DATA_FOR_RANDOM_STRING.length())));
        }
        return sb.toString();
    }
}
