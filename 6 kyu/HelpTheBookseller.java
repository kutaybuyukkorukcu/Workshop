// https://www.codewars.com/kata/54dc6f5a224c26032800005c

import java.util.stream.Stream;
import java.lang.StringBuilder;
import java.util.HashMap;
import java.util.Map;

public class StockList {

    public static String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
        if(lstOfArt.length == 0 || lstOf1stLetter.length == 0) {
            return "";
        }

        Map<String, Integer> result = Stream.of(lstOf1stLetter)
                .collect(HashMap<String, Integer>::new,
                        (map, code) -> {
                            if(!map.containsKey(code)) {
                                map.put(code, 0);
                            }
                        },
                        (map, u) -> {}
                );

        Stream.of(lstOfArt)
                .filter(book -> result.containsKey(((Character)book.charAt(0)).toString()))
                .forEach(book -> {
                            result.put(((Character)book.charAt(0)).toString(), result.get(((Character)book.charAt(0)).toString())+Integer.parseInt(book.split(" ")[1]));
                        }
                );
        StringBuilder stringBuilder = new StringBuilder();
        result.entrySet().stream().forEach(entry -> stringBuilder.append("(" + entry.getKey() + " : " + entry.getValue() + ") - "));
        return stringBuilder.delete(stringBuilder.length() - 3,stringBuilder.length()).toString();
    }
}

// 🧙‍♂️👍