package validator;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CardValidator {

    private final String HYPHEN_NUMBER = "^([0-9]{4}-){3}[0-9]{4}";
    private final String SHORT_NUMBER = "^[0-9]{16}";
    private final String SPACE_NUMBER = "^([0-9]{4}\s){3}[0-9]{4}";

    private final String PIN_REGEX = "[0-9]{4}";

    public boolean cardNumberValidator(String cardNumber) {

        String number = cardNumber.trim();

        Pattern patternHyphen = Pattern.compile(HYPHEN_NUMBER);
        Pattern patternShort = Pattern.compile(SHORT_NUMBER);
        Pattern patternSpace = Pattern.compile(SPACE_NUMBER);

        Matcher matcherHyphen = patternHyphen.matcher(number);
        Matcher matcherShort = patternShort.matcher(number);
        Matcher matcherSpace = patternSpace.matcher(number);

        return cardNumber.length() > 15 && cardNumber.length() < 20
                && matcherHyphen.matches() || matcherShort.matches() || matcherSpace.matches();
    }

    public boolean cardPinValidator(String pin) {

        Pattern pattern = Pattern.compile(PIN_REGEX);
        Matcher matcher = pattern.matcher(pin);

        return matcher.matches();
    }

    public boolean cardBalanceValidator(BigDecimal balance) {

        return balance.doubleValue() > 0;
    }

    public String getSHORT_NUMBER() {
        return SHORT_NUMBER;
    }

    public String getSPACE_NUMBER() {
        return SPACE_NUMBER;
    }

    public String getHYPHEN_NUMBER() {
        return HYPHEN_NUMBER;
    }

    public String getPIN_REGEX() {
        return PIN_REGEX;
    }
}
