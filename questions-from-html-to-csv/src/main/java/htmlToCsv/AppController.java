package htmlToCsv;

import java.nio.file.Path;

public class AppController {

    public static void main(String[] args) {
        AppService appService = new AppService();

        Path file = Path.of("src/main/resources/kerdesek.html");
        Path csvFile = Path.of("questions.csv");

        appService.addQuestion(file);

        appService.writeCsv(csvFile);

    }
}
