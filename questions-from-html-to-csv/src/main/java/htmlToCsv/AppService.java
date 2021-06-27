package htmlToCsv;

import com.sun.jdi.Value;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppService {

    private final String FIRST_SEPARATE = ">";
    private final String LAST_SEPARATE = "<";
    private final String CSV_SEPARATOR = "\";\"";

    private List<Question> questions = new ArrayList<>();

    public void addQuestion(Path file) {
        parseQuestion(file);
    }

    private void parseQuestion(Path file) {
        try (BufferedReader reader = Files.newBufferedReader(file)) {
            List<String> answer = new ArrayList<>();
            String question = "";
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("<h1 id")) {
                    line = reader.readLine().trim();
                    question = line.substring(3, line.length() - 4);
                } else if (line.contains("<ul>")) {
                    answer = readAnswers(reader);
                } else if (!line.contains("</ul>") && line.length() > 0){
                    question += "\n" + addQuestionLine(line);
                } else {
                    questions.add(new Question(question, answer));
                }
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file!", ioe);
        }
    }

    private String addQuestionLine(String str) {
        StringBuilder sb = new StringBuilder();
        String[] tmp = str.split(FIRST_SEPARATE);
        for (String stringLine : tmp) {
            sb.append(stringLine.substring(0, stringLine.indexOf(LAST_SEPARATE)));
        }
        return sb.toString();
    }

    private List<String> readAnswers(BufferedReader reader) throws IOException {
        List<String> answer = new ArrayList<>();
        int numberOfCorrectAnswer = 0;
        int i = 0;
        while (i < 4) {
            String line = reader.readLine().trim();
            if (line.contains("checkbox")) {
                numberOfCorrectAnswer = i + 1;
                line = reader.readLine().trim();
                answer.add(line.substring(0, line.indexOf(FIRST_SEPARATE) - 4));
                i++;
            } else {
                answer.add(line.substring(4, line.length() - 5));
                i++;
            }
        }
        answer.add(String.valueOf(numberOfCorrectAnswer));
        return answer;
    }

    public void writeCsv(Path file) {
        try (BufferedWriter writer = Files.newBufferedWriter(file)){
            for (Question q:questions) {
                writer.write("\"" + q.getQuestion());
                writer.write(CSV_SEPARATOR);
                for (String a:q.getAnswers()) {
                    writer.write(a + CSV_SEPARATOR);
                }
                writer.write("\"\n");
            }
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Can not write file!", ioe);
        }
    }

    public List<Question> getQuestions() {
        return questions;
    }
}
