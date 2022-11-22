package service;

import entity.Atm;
import entity.Card;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AtmService {

    public Card getCardInfo(Map<String, List<String>> cards, String cardNumber, String pin) {

        Set<String> cardKeys = cards.keySet();

        for (String cardKey : cardKeys) {
            String[] cardValues = cards.get(cardKey).get(0).split(" ");

            if (cardKey.equals(cardNumber) &&
                    cardValues[0].equals(pin)) {
                System.out.println(cardKey);

                return Card.builder()
                        .cardNumber(cardKey)
                        .pin(pin)
                        .balance(BigDecimal.valueOf(Double.parseDouble(cardValues[1])))
                        .build();
            }
        }
        return null;
    }

    public Card withdrawMoney(Card card, BigDecimal money, Atm atm) {
        if (money.doubleValue() <= card.getBalance().doubleValue() &&
                money.doubleValue() <= atm.getCash().doubleValue()) {
            card.setBalance(BigDecimal.valueOf(card.getBalance().doubleValue() - money.doubleValue()));
            atm.setCash(BigDecimal.valueOf(atm.getCash().doubleValue() - money.doubleValue()));
            return card;
        }
        return null;
    }

    public Card refill(Card card, BigDecimal money, Atm atm) {
        if (money.doubleValue() <= 1000000) {
            card.setBalance(BigDecimal.valueOf(card.getBalance().doubleValue() + money.doubleValue()));
            atm.setCash(BigDecimal.valueOf(atm.getCash().doubleValue() + money.doubleValue()));
            return card;
        }
        return null;
    }

}
