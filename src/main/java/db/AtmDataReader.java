package db;

import validator.DbValidator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class AtmDataReader {

    private static final String FILE_NAME = "C:\\Users\\paulm\\IdeaProjects\\atm\\src\\main\\resources\\CardDB";
    DbValidator validator = new DbValidator();

    public List<StringBuilder> readDbFile() {
        List<StringBuilder> lines = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String value;
            while ((value = reader.readLine()) != null) {
                if (validator.isValidLine(value)) {
                    lines.add(new StringBuilder(value));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return lines;
    }
}
