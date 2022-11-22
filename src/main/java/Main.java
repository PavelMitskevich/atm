import db.AtmDataReader;
import db.AtmDataWriter;
import entity.Atm;
import entity.Card;
import mapper.DbMapper;
import service.AtmService;
import service.CardService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        AtmDataReader reader = new AtmDataReader();
        AtmService atmService = new AtmService();
        CardService cardService = new CardService();
        DbMapper dbMapper = new DbMapper();
        Atm atm = new Atm();

        atm.setCash(BigDecimal.valueOf(1000000));

        Card testCard = new Card();
        testCard.setCardNumber("1234 5678 9012 3455");
        testCard.setPin("1111");
        testCard.setBalance(new BigDecimal("120.5"));

        Card card = cardService.createCard(testCard);

        List<StringBuilder> dbReader = reader.readDbFile();
        System.out.println(dbReader);
        System.out.println("----------------------------------\n");

        Map<String, List<String>> cards = dbMapper.mapDb(dbReader);
        System.out.println(cards);
        System.out.println("----------------------------------\n");

        Card validCard = atmService.getCardInfo(cards, "2222-2222-2222-2222", "2222");
        System.out.println(validCard);
        System.out.println("----------------------------------\n");

        validCard = atmService.withdrawMoney(validCard, BigDecimal.valueOf(101.5), atm);
        System.out.println(validCard);
        System.out.println(atm);
        System.out.println("----------------------------------\n");

        validCard = atmService.refill(validCard, BigDecimal.valueOf(100000), atm);
        System.out.println(validCard);
        System.out.println(atm);
        System.out.println("----------------------------------\n");

        AtmDataWriter.refreshDbWithNewBalance(validCard);
    }
}
