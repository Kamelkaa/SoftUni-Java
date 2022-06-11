package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Problem_03_ {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> collectionOfBooks = Arrays.stream(scanner.nextLine().split("&"))
                .collect(Collectors.toList());
        String text = scanner.nextLine();


        while (!text.equals("Done")) {
            String command = text.split(" \\| ")[0];

            switch (command) {
                case "Add Book":
                    String bookName = text.split(" \\| ")[1];
                    if (!collectionOfBooks.contains(bookName)) {
                        collectionOfBooks.add(0, bookName);
                    }
                    break;
                case "Take Book":
                    bookName = text.split(" \\| ")[1];
                    if (collectionOfBooks.contains(bookName)) {
                        collectionOfBooks.remove(bookName);
                    }
                    break;
                case "Swap Books":
                    String bookOne = text.split(" \\| ")[1];
                    String bookTwo = text.split(" \\| ")[2];
                    if (collectionOfBooks.contains(bookOne) && collectionOfBooks.contains(bookTwo)) {
                        int indexOne = collectionOfBooks.indexOf(bookOne);
                        int indexTwo = collectionOfBooks.indexOf(bookTwo);

                        collectionOfBooks.remove(bookTwo);
                        collectionOfBooks.add(indexOne, bookTwo);
                        collectionOfBooks.remove(bookOne);
                        collectionOfBooks.add(indexTwo, bookOne);
                    }
                    break;
                case "Insert Book":
                    bookName = text.split(" \\| ")[1];
                    collectionOfBooks.add(bookName);
                    break;
                case "Check Book":
                    int index = Integer.parseInt(text.split(" \\| ")[1]);
                    if (index >= 0 && index < collectionOfBooks.size()) {
                        System.out.println(collectionOfBooks.get(index));
                    }
                    break;
            }

            text = scanner.nextLine();
        }

        System.out.println(String.join(", ", collectionOfBooks));
    }
}
