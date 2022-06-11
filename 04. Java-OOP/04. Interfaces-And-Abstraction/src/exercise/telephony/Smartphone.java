package exercise.telephony;

import java.util.List;

public class Smartphone implements Callable, Browsable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String call() {
        StringBuilder builder = new StringBuilder();
        for (String number : numbers) {
            boolean isCorrect = true;
            for (int i = 0; i < number.length(); i++) {
                char currentSymbol = number.charAt(i);
                if (Character.isDigit(currentSymbol)) {
                    isCorrect = true;
                } else {
                    isCorrect = false;
                    break;
                }
            }
            if (isCorrect) {
                builder.append("Calling... ").append(number).append(System.lineSeparator());
            } else {
                builder.append("Invalid number!").append(System.lineSeparator());
            }
        }
        return builder.toString();
    }

    @Override
    public String browse() {
        StringBuilder builder = new StringBuilder();
        for (String url : urls) {
            boolean isCorrect = true;
            for (int i = 0; i < url.length(); i++) {
                char currentSymbol = url.charAt(i);
                if (Character.isDigit(currentSymbol)) {
                    isCorrect = false;
                    break;
                }
            }
            if (isCorrect) {
                builder.append("Browsing: ").append(url).append("!").append(System.lineSeparator());
            } else {
                builder.append("Invalid URL!").append(System.lineSeparator());
            }
        }
        return builder.toString();
    }
}
////
//@Override
//public String call() {
//    StringBuilder sb = new StringBuilder();
//
//    for (String number : numbers) {
//        if (number.matches("\\d+")) {
//            sb.append("Calling... ").append(number).append(System.lineSeparator());
//        } else {
//            sb.append("Invalid number!").append(System.lineSeparator());
//        }
//    }
//    return sb.toString().trim();
//}
//
//    @Override
//    public String browse() {
//        StringBuilder sb = new StringBuilder();
//
//        for (String url : urls) {
//            if (url.matches("^\\D+$")) {
//                sb.append(String.format("Browsing: %s!%n", url));
//            } else {
//                sb.append("Invalid URL!").append(System.lineSeparator());
//            }
//        }
//        return sb.toString().trim();
//
//    }