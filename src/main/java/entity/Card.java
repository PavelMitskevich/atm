package entity;

import lombok.*;

import java.math.BigDecimal;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Card {

    private String pin;

    private BigDecimal balance;

    private String cardNumber;

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getPin() {
        return pin;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        if (!pin.equals(card.pin)) return false;
        if (!Objects.equals(balance, card.balance)) return false;
        return cardNumber.equals(card.cardNumber);
    }

    @Override
    public int hashCode() {
        int result = pin.hashCode();
        result = 31 * result + (balance != null ? balance.hashCode() : 0);
        result = 31 * result + cardNumber.hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Card{");
        sb.append("pin=").append(pin);
        sb.append(", balance=").append(balance);
        sb.append(", cardNumber='").append(cardNumber).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
