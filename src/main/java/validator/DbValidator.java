package validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.regex.Pattern;

public class DbValidator {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final Pattern PATTERN = Pattern.compile("^([0-9]{4}-){3}[0-9]{4}\s[0-9]{4}\s[0-9]+[.][0-9]{2}");
    public boolean isValidLine(String text) {
        boolean flag = false;
        if (text.matches(PATTERN.pattern())) {
            LOGGER.info("Successful validation");
            flag = true;
        }
        return flag;
    }
}
