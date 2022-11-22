package mapper;

import validator.CardValidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CardMapper {

    CardValidator validator = new CardValidator();

    public String mapToView(String cardNumber) {

        String number = cardNumber.trim();
        Pattern patternSpace = Pattern.compile(validator.getSPACE_NUMBER());
        Matcher matcherSpace = patternSpace.matcher(number);
        StringBuilder stringBuilder = new StringBuilder();

        if (number.length() == 16) {
            char[] chars = number.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                stringBuilder.append(chars[i]);
                if ((i + 1) % 4 == 0 && i != chars.length - 1) {
                    stringBuilder.append("-");
                }
            }
        }
        if (number.length() == 19 && matcherSpace.matches()) {
            char[] chars = number.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if ((i + 1) % 5 == 0 && i != chars.length - 1) {
                    stringBuilder.append("-");
                    continue;
                }
                stringBuilder.append(chars[i]);
            }
        } else {
            stringBuilder.append(cardNumber);

        }
        return stringBuilder.toString();

    }
}
