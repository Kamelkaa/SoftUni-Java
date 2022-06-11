package Exercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task_06_ExtractEmailsSTAR {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        String regexEmail = "(?<user>[A-Za-z0-9]+[._\\-]?[A-Za-z0-9]+)@(?<host>[A-Za-z]+-?[A-Za-z]+(\\.[A-Za-z]+-?[A-Za-z])+)";

        Pattern patternEmail = Pattern.compile(regexEmail);
        Matcher matcherEmail = patternEmail.matcher(text);

        while (matcherEmail.find()) {
            System.out.println(matcherEmail.group());
        }
    }
}
