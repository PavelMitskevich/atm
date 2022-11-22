package service;

import entity.Card;
import mapper.CardMapper;
import validator.CardValidator;

public class CardService {

    CardValidator validator = new CardValidator();
    CardMapper mapper = new CardMapper();

    public Card createCard(Card card) {
        Card card1 = new Card();

        if (validator.cardNumberValidator(card.getCardNumber()) &&
                validator.cardPinValidator(card.getPin()) &&
                validator.cardBalanceValidator(card.getBalance())) {

            card1.setCardNumber(mapper.mapToView(card.getCardNumber()));
            card1.setPin(card.getPin());
            card1.setBalance(card.getBalance());

            return card1;
        } else {
            System.out.println("You have invalid parameter");
            return null;
        }
    }
}
