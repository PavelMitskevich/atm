package mapper;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DbMapper {

    public String sbToDbValidString(List<StringBuilder> list) {

        StringBuilder stringBuilder = new StringBuilder();

        for (StringBuilder builder : list) {

            stringBuilder.append(builder);
            stringBuilder.append('\n');

        }

        return stringBuilder.toString();
    }

    public List<String> sbToString(List<StringBuilder> cardDb) {

        return cardDb.stream()
                .map(StringBuilder::toString)
                .collect(Collectors.toList());
    }

    public Map<String, List<String>> mapDb(List<StringBuilder> cardDb) {

        List<String> lines = sbToString(cardDb);

        return lines.stream()
                .map(s -> s.split(" ", 2))
                .collect(Collectors.groupingBy(
                        s -> s[0],
                        Collectors.mapping(s -> s[1],
                                Collectors.toList())));
    }
}
