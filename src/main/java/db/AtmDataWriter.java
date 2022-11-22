package db;

import entity.Card;
import mapper.DbMapper;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class AtmDataWriter {

    private static final String FILE_NAME = "C:\\Users\\paulm\\IdeaProjects\\atm\\src\\main\\resources\\CardDB";

    static AtmDataReader reader = new AtmDataReader();
    static DbMapper mapper = new DbMapper();

    public static void refreshDbWithNewBalance(Card card) {

        try {
            List<StringBuilder> allData = reader.readDbFile();

            List<StringBuilder> newData = new ArrayList<>();

            for (StringBuilder allDatum : allData) {
                if (allDatum.substring(0).startsWith(card.getCardNumber())) {
                    String s = card.getCardNumber() + " " + card.getPin() + " " + card.getBalance();
                    newData.add(new StringBuilder(s));
                } else {
                    newData.add(allDatum);
                }
            }

            String inputStr = mapper.sbToDbValidString(newData);

            FileOutputStream fileOut = new FileOutputStream(FILE_NAME);

            System.out.println(inputStr);
            fileOut.write(inputStr.getBytes());
            fileOut.close();

        } catch (Exception e) {
            System.out.println("Problem reading file.");
        }
    }
}
